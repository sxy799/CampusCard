package JDBC;


///连接数据库
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 

public class JDBC{ 
	
	 public String USERNAME = "we000000";
	 public String PASSWORD = "we000000";
	 public String DRVIER = "oracle.jdbc.OracleDriver";
	 public String URL = "jdbc:oracle:thin:@127.0.0.1:1521:WEST";
	 Connection connection = null;
	 PreparedStatement pstm = null;
	 ResultSet rs = null;
	 
	 //传入表名字 tablename 查看在表的内容
	 public  ResultSet SelectTable(String tablename) {
		 connection = null;
		 pstm = null;
		 rs = null;
		 System.out.println("表名" + tablename);
		 boolean Selecttable = getConnection();
	     String sql = "select * from sys.";
	        try {  
	            pstm = connection.prepareStatement(sql+tablename);//预处理语句
	            //pstm.setString(1, tablename);
	            System.out.println("SQL + "+sql);
	            System.out.println("查询成功！");
	            rs = pstm.executeQuery();
	         return rs;
	        } catch (SQLException e) {
	          System.out.println("查询失败！");
	           e.printStackTrace();
	           return null;
	        } 
	  }
	 //传入用户名和密码验证登录
	 public boolean LoginCheck(String login_name,String login_password) {
		 ///连接数据库
		  System.out.println("用户名" + login_name);  
		  System.out.println("用户密码" + login_password); 
	    //以we000000  的身份查看在admin_info
	     String sql = "select * from sys.admin_info where admin_id= ? and admin_password = ?";
	        try {  
	        	System.out.println("LoginCheck setbefore :" + sql); 
	            pstm = connection.prepareStatement(sql);//预处理语句
	            pstm.setString(1, login_name);
	            pstm.setString(2, login_password);
	        	System.out.println("LoginCheck setafter :" + sql); 

	            rs = pstm.executeQuery();
	            if(rs.next()) {
	                return true;
	            }
	            else 
	            {
	            	return false;
	            }
	        } catch (SQLException e) {
	           e.printStackTrace();
	           return false;
	        } 
	    }
	 public boolean LoginCheckUser(String login_name,String login_password) {
		 ///连接数据库
		  System.out.println("用户名" + login_name);  
		  System.out.println("用户密码" + login_password); 
	    //以we000000  的身份查看在admin_info
	     String sql = "select * from sys.card_info where card_id= ? and card_password = ?";
	        try {  
	            pstm = connection.prepareStatement(sql);//预处理语句
	            pstm.setString(1, login_name);
	            pstm.setString(2, login_password);
	            rs = pstm.executeQuery();
	            if(rs.next()) {
	                return true;
	            }
	            else 
	            {
	            	return false;
	            }
	        } catch (SQLException e) {
	           e.printStackTrace();
	           return false;
	        } 
	    }
	 //返回用户的名字
	 public String  getusername(String username){
		 boolean connflag = getConnection();
		  System.out.println("username" + username);
		  String sql = "select admin_name from sys.admin_info where admin_id= ? ";
	        try {  
	            pstm = connection.prepareStatement(sql);//预处理语句
	            pstm.setString(1, username);
	            System.out.println("SQL" + sql);
	            rs = pstm.executeQuery();
	            String ret = "";
	            if (rs.next()) { ret =  rs.getString(1);}
	            return ret;
	        } catch (SQLException e) {
	           e.printStackTrace();
	           return null;
	        } finally {
	            ReleaseResource();
	        }
	 }
	 //连接数据库
	    public boolean  getConnection() {
	        try {
	            Class.forName(DRVIER);
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            if(connection==null){    
	                System.out.println("与oracle数据库连接失败！");  
	                return false;
	            }else{    
	                System.out.println("与oracle数据库连接成功！"); 
	                return true;
	            }    
	        } catch (ClassNotFoundException e) {
	            System.out.println("RuntimeException");
	            throw new RuntimeException("class not find !", e);
	        } catch (SQLException e) {
	        	 System.out.println("SQLException");
	            throw new RuntimeException("get connection error!", e);
	        } finally {
	        	
	        }
	        //return connection;
	    }
	  //释放资源
      public void ReleaseResource() {
	        if (connection != null) {
	            try {
	                connection.close();  
	            }
	            catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
