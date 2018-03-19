package JDBC;


///�������ݿ�
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
	 
	 //��������� tablename �鿴�ڱ������
	 public  ResultSet SelectTable(String tablename) {
		 connection = null;
		 pstm = null;
		 rs = null;
		 System.out.println("����" + tablename);
		 boolean Selecttable = getConnection();
	     String sql = "select * from sys.";
	        try {  
	            pstm = connection.prepareStatement(sql+tablename);//Ԥ�������
	            //pstm.setString(1, tablename);
	            System.out.println("SQL + "+sql);
	            System.out.println("��ѯ�ɹ���");
	            rs = pstm.executeQuery();
	         return rs;
	        } catch (SQLException e) {
	          System.out.println("��ѯʧ�ܣ�");
	           e.printStackTrace();
	           return null;
	        } 
	  }
	 //�����û�����������֤��¼
	 public boolean LoginCheck(String login_name,String login_password) {
		 ///�������ݿ�
		  System.out.println("�û���" + login_name);  
		  System.out.println("�û�����" + login_password); 
	    //��we000000  ����ݲ鿴��admin_info
	     String sql = "select * from sys.admin_info where admin_id= ? and admin_password = ?";
	        try {  
	        	System.out.println("LoginCheck setbefore :" + sql); 
	            pstm = connection.prepareStatement(sql);//Ԥ�������
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
		 ///�������ݿ�
		  System.out.println("�û���" + login_name);  
		  System.out.println("�û�����" + login_password); 
	    //��we000000  ����ݲ鿴��admin_info
	     String sql = "select * from sys.card_info where card_id= ? and card_password = ?";
	        try {  
	            pstm = connection.prepareStatement(sql);//Ԥ�������
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
	 //�����û�������
	 public String  getusername(String username){
		 boolean connflag = getConnection();
		  System.out.println("username" + username);
		  String sql = "select admin_name from sys.admin_info where admin_id= ? ";
	        try {  
	            pstm = connection.prepareStatement(sql);//Ԥ�������
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
	 //�������ݿ�
	    public boolean  getConnection() {
	        try {
	            Class.forName(DRVIER);
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            if(connection==null){    
	                System.out.println("��oracle���ݿ�����ʧ�ܣ�");  
	                return false;
	            }else{    
	                System.out.println("��oracle���ݿ����ӳɹ���"); 
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
	  //�ͷ���Դ
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
