package tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class WordGenerator {  
    private static Configuration configuration = null;  
    private static Map<String, Template> allTemplates = null;  
      
    static {  
        configuration = new Configuration();  
        configuration.setDefaultEncoding("utf-8");  
        configuration.setClassForTemplateLoading(WordGenerator.class, "/wyp/tools");  
        allTemplates = new HashMap<>(); 
        try {  
            allTemplates.put("resume", configuration.getTemplate("resume.ftl"));  
        } catch (IOException e) {  
            e.printStackTrace();  
            throw new RuntimeException(e);  
        }  
    }  
  
    private WordGenerator() {  
        throw new AssertionError();  
    }  
  
    public static File createDoc(Map<?, ?> dataMap, String type) {  
        String name = "temp" + (int) (Math.random() * 100000) + ".doc";  
        File f = new File(name);  
        Template t = allTemplates.get(type);  
        try {  
            // 杩欎釜鍦版柟涓嶈兘浣跨敤FileWriter鍥犱负闇�瑕佹寚瀹氱紪鐮佺被鍨嬪惁鍒欑敓鎴愮殑Word鏂囨。浼氬洜涓烘湁鏃犳硶璇嗗埆鐨勭紪鐮佽�屾棤娉曟墦寮�  
            Writer w = new OutputStreamWriter(new FileOutputStream(f), "utf-8");  
            t.process(dataMap, w);  
            w.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
            throw new RuntimeException(ex);  
        }  
        return f;  
    }  
  
}  