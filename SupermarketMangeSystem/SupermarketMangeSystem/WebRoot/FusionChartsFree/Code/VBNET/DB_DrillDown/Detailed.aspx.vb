﻿Imports DataConnection
Imports Utilities
Imports InfoSoftGlobal
Partial Class DB_DrillDown_Detailed
    Inherits System.Web.UI.Page
    Public Function CreateChart() As String
        'This page is invoked from Default.asp. When the user clicks on a pie
        'slice in Default.asp, the factory Id is passed to this page. We need
        'to get that factory id, get information from database and then show
        'a detailed chart.

        'First, get the factory Id
        Dim FactoryId As Integer
        Dim util As New Util
        'Request the factory Id from Querystring
        FactoryId = Request.QueryString("FactoryId")

        Dim oRs As DbConn, strQuery As String
        'strXML will be used to store the entire XML document generated
        Dim strXML As String

        'Generate the graph element string
        strXML = "<graph caption='Factory " & FactoryId & " Output ' subcaption='(In Units)' xAxisName='Date' showValues='1' decimalPrecision='0' rotateNames='1' >"
        'Now, we get the data for that factory
        strQuery = "select * from Factory_Output where FactoryId=" & FactoryId
        oRs = New DbConn(strQuery)
        While oRs.ReadData.Read()
            'Here, we convert date into a more readable form for set name.

            strXML = strXML & "<set name='" & Convert.ToDateTime(oRs.ReadData("DatePro")).ToString("dd") & "/" & Convert.ToDateTime(oRs.ReadData("DatePro")).ToString("MM") & "' value='" & oRs.ReadData("Quantity").ToString() & "' color='" & util.getFCColor() & "'/>"


        End While
        'Close <graph> element
        strXML = strXML & "</graph>"
        oRs.ReadData.Close()

        'Create the chart - Column 2D Chart with data from strXML
        Return FusionCharts.RenderChart("../FusionCharts/FCF_Column2D.swf", "", strXML, "FactoryDetailed", "600", "300", False, False)
    End Function
End Class
