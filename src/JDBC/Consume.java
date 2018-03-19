package JDBC;
///�������ݿ�
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Consume {
	 public String USERNAME = "we000000";
	 public String PASSWORD = "we000000";
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
	 //2.��ѯ���鿴consume-info���������Ϣ������������
	 public  ResultSet SelectConsumeInfo(Connection conn ) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.consume_info";
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
		        } finally {
		          //  ReleaseResource();
		        }
		  }
	 //3.��ѯ������card_id�鿴consume_info�����������ӣ�����
	 public  ResultSet SelectCardInfoByCardId(Connection conn ,String card_id) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.consume_info where card_id = '";
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
	 //4.�õ���  ���������ӣ����ţ�consume_how,money
	     public  double UpdateConsumeInfoMoney(Connection conn,String card_id,double consume_how) {
		 pstm = null;
		 rs = null;
		 double money = 0.0; 
	     String sql = "select money from sys.consume_info where card_id = '";
	     sql = sql + card_id + "'";
	     try {  
	            pstm = conn.prepareStatement(sql);//Ԥ�������
	            System.out.println("�õ����  + "+sql);  
	            rs = pstm.executeQuery();
	            while (rs.next()){
	            	 money = rs.getDouble(1);
	            	 System.out.println(money);
	            }
	            System.out.println("�����������ɹ���");
	     } catch (SQLException e) {
	           System.out.println("����������ʧ�ܣ�");
	           e.printStackTrace();
	           return 0.0;
	     }
	     double  ans = consume_how + money;
	     //update sys.consume_info set sys.consume_info.money = 80.56 where card_id = 'we221111'; 
	     sql ="update sys.consume_info set sys.consume_info.money = "+String.valueOf(money)+" where card_id = '";
	     sql = sql + card_id + "'";
	     System.out.println("SQL" + sql);
	     try {  
	            pstm = conn.prepareStatement(sql);//Ԥ�������
	            rs = pstm.executeQuery();
	            System.out.println("�����������ɹ���");
	            return rs.getDouble(1);
	     } catch (SQLException e) {
	           System.out.println("����������ʧ�ܣ�");
	           e.printStackTrace();
	           return 0.0;
	     }
	 }
	 //7.���ӣ���consume_info�в������ݣ������ǣ�������,����,card_id,consume_time,consume_name,consume_how
	 public  void AddConsumeInfo(Connection conn ,String card_id,String consume_name,String consume_how,double money) {
		   ///�õ�ʱ��
		    Calendar c = new GregorianCalendar();
		    java.util.Date d = c.getTime();
		    DateFormat df = new SimpleDateFormat("yyyyMMdd");
		    String consume_time = df.format(d);
		    System.out.println(d);
		    
		    String sql = "insert into sys.card_info values(?,?,?,?,?)";
	        try {
	            // ִ�в������ݲ���
	            pstm = conn.prepareStatement(sql);
	            pstm.setString(1, card_id);
	            pstm.setString(2, consume_time);
	            pstm.setString(3, consume_name);
	            pstm.setString(4, consume_how);
	            pstm.setDouble(5, money);
	            pstm.executeUpdate();
	            System.out.println("card_info����ɹ���");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("card_info����ʧ�ܣ�");
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
