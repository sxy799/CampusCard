package JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class book {
	//0.�õ�����ʱ��
	 public String GetTime () {
	   Calendar c = new GregorianCalendar();
	   java.util.Date d = c.getTime();
	   c.add(Calendar.DAY_OF_MONTH, 10);//����Ļ����ϼ�һ��
	   java.util.Date d2 = c.getTime();
	    DateFormat df = new SimpleDateFormat("yyyyMMdd");
	    String str = df.format(d);
	    String str2 = df.format(d2);
	    System.out.println(d);
	    System.out.println(d2);
	  return str2;
	 }
	 public String USERNAME = "we020000";
	 public String PASSWORD = "we020000";
	 public String DRVIER = "oracle.jdbc.OracleDriver";
	 public String URL = "jdbc:oracle:thin:@127.0.0.1:1521:WEST";
	 Connection connection = null;
	 PreparedStatement pstm = null;
	 ResultSet rs = null;
	 //1.�������ݿ�
	 public   Connection getConnection() {
	        try {
	            Class.forName(DRVIER);
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            if(connection==null){    
	                System.out.println("��oracle���ݿ�����ʧ�ܣ�");  
	                return null;
	            }else{    
	                System.out.println("��oracle���ݿ����ӳɹ���"); 
	                return connection;
	            }    
	        } catch (ClassNotFoundException e) {
	            System.out.println("RuntimeException");
	            throw new RuntimeException("class not find !", e);
	        } catch (SQLException e) {
	        	 System.out.println("SQLException");
	            throw new RuntimeException("get connection error!", e);
	        } 
	    }
	 //2.��ѯ���鿴book-info���������Ϣ������������
	 public  ResultSet SelectBookInfo(Connection conn ) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.book_info";
		        try {  
		            pstm = conn.prepareStatement(sql);//Ԥ�������
		            System.out.println("SQL + "+sql);
		            rs = pstm.executeQuery(); 
		            System.out.println("��ѯ�ɹ���");
		            return rs;
		        } catch (SQLException e) {
		          System.out.println("��ѯʧ�ܣ�");
		           e.printStackTrace();
		           return null;
		        } 
		  }
	 //3.��ѯ������card_id�鿴book_info�����������ӣ�����
	 public  ResultSet SelectBookInfoByCardId(Connection conn ,String card_id) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.book_info where card_id = '";
		     sql = sql + card_id + "'";
		        try {  
		            pstm = conn.prepareStatement(sql);//Ԥ�������
		            System.out.println("SQL + "+sql);
		            rs = pstm.executeQuery();		     
		          System.out.println("����ѧ�Ų�ѯ�ɹ���");
		          return rs;
		        } catch (SQLException e) {
		          System.out.println("����ѧ�Ų�ѯʧ�ܣ�");
		          e.printStackTrace();
		          return null;
		        }
	}
	 //5.��ѯ������borrowed�鿴book_info������������
	 public ResultSet SelectBookInfoByBorrowed(Connection conn) {
		 System.out.println("------------- ");  
		     pstm = null;
			 rs = null;
		     String sql = "select * from sys.book_info where borrowed = '1' ";
		     System.out.println("SQL + "+sql);  
		     try {  
		            pstm = conn.prepareStatement(sql);//Ԥ�������
		            System.out.println("SQL + "+sql);  
		            rs = pstm.executeQuery();
		            System.out.println("����δ�黹��ѯ�ɹ���");
		            return rs;
		     } catch (SQLException e) {
		           System.out.println("����δ�黹��ѯʧ�ܣ�");
		           e.printStackTrace();
		           return null;
		     } 
	   }
	 //6.���飺���� card_Id ���²���
	 public  void UpdateBookInfoReturn(Connection conn,String card_id,String book_id) {
		 pstm = null;
		 rs = null;
		 //update sys.book_info set sys.book_info.borrowed = '0' where card_id = 'we222222' and book_id = '2001';
	     String sql = "update sys.book_info set sys.book_info.borrowed = '1' where card_id = '";
	     sql = sql + card_id + "' and book_id = '" + book_id + "'";
	     try {  
	            pstm = conn.prepareStatement(sql);//Ԥ�������
	            System.out.println("����  + "+sql);  
	            rs = pstm.executeQuery();
	            System.out.println("���»��� �����ɹ���");
	     } catch (SQLException e) {
	           System.out.println("���»��� ����ʧ�ܣ�");
	           e.printStackTrace();
	     } 
    }
	 //6.���裺���� card_Id ���¹黹����
	 public  void UpdateBookInfoDeadline(Connection conn,String card_id) {
		 pstm = null;
		 rs = null;
		 String t = GetTime();
		 System.out.println("----" + t);
		 //update sys.book_info set sys.book_info.borrowed = '0' where card_id = 'we222222' and book_id = '2001';
	     String sql = "update sys.book_info set sys.book_info.deadline = '"+ t +"' where card_id = '";
	     sql = sql + card_id + "'" ;
	     try {  
	            pstm = conn.prepareStatement(sql);//Ԥ�������
	            System.out.println("����  + "+sql);  
	            rs = pstm.executeQuery();
	            System.out.println("���»��� �����ɹ���");
	     } catch (SQLException e) {
	           System.out.println("���»��� ����ʧ�ܣ�");
	           e.printStackTrace();
	     } 
    }
	 //7.���飺��book_info�в������ݣ������ǣ�������,card_id, book_id,book_name,borrowed,deadline
	 public  void AddBookInfo(Connection conn ,String card_id, String book_id, String book_name,String borrowed,String deadline) {
	        String sql = "insert into sys.book_info values(?,?,?,?,?)";
	        try {
	            // ִ�в������ݲ���
	            pstm = conn.prepareStatement(sql);
	            pstm.setString(1, card_id);
	            pstm.setString(2, book_id);
	            pstm.setString(3, book_name);
	            pstm.setString(4, borrowed);
	            pstm.setString(5, deadline);
	            pstm.executeUpdate();
	            System.out.println("book_info����ɹ���");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("book_info����ʧ�ܣ�");
	        } 
		}
	 //9.�ͷ���Դ
	 public void ReleaseResource() {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (pstm != null) {
	            try {
	                pstm.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
