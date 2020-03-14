package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
		
		/**
 * �������ݿ���User������
 */
public class UserDao {

    //����JDBCTemplate������
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * ��¼����
     * @param loginUser ֻ���û���������
     * @return user�����û�ȫ������,û�в�ѯ��������null
     */
    public User login(User loginUser){
        try {
            //1.��дsql
            String sql = "select * from user where username = ? and password = ?";
            //2.����query����
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
            
        } catch (DataAccessException e) {
            //e.printStackTrace();//��¼��־
            return null;
        }
    }
}