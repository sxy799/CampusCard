package JDBC;
///�������ݿ�
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 

public class Card {
	 public String USERNAME = "we010000";
	 public String PASSWORD = "we010000";
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
	 //2.��ѯ���鿴card-info���������Ϣ������������
	 public  ResultSet SelectCardInfo(Connection conn ) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.card_info";
		        try {  
		            pstm = conn.prepareStatement(sql);//Ԥ�������
		            System.out.println("SQL + "+sql);
		           
		            rs = pstm.executeQuery(); 
		            System.out.println("��ѯ�ɹ���");
		            return rs;
		           /*while (rs.next()){
		            	String card_id = rs.getString(1);
		            	String card_password = rs.getString(2);
		            	String card_name = rs.getString(3);
		            	String card_losted = rs.getString(4);
		            	 System.out.println(card_id);
		            	 System.out.println(card_password);
		            	 System.out.println(card_name);
		            	 System.out.println(card_losted);
		          }*/
		        } catch (SQLException e) {
		          System.out.println("��ѯʧ�ܣ�");
		           e.printStackTrace();
		           return null;
		        } finally {
		          //  ReleaseResource();
		        }
		  }
	 //3.��ѯ������card_id�鿴card_info�����������ӣ�����
	 public  ResultSet SelectCardInfoByCardId(Connection conn ,String card_id) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.card_info where card_id = '";
		     sql = sql + card_id + "'";
		        try {  
		            pstm = conn.prepareStatement(sql);//Ԥ�������
		            System.out.println("SQL + "+sql);
		            rs = pstm.executeQuery();
		           /* while (rs.next()){
		            	String card_id1 = rs.getString(1);
		            	String card_password = rs.getString(2);
		            	String card_name = rs.getString(3);
		            	String card_losted = rs.getString(4);
		            	 System.out.println(card_id1);
		            	 System.out.println(card_password);
		            	 System.out.println(card_name);
		            	 System.out.println(card_losted);
		           
		          }*/
		          System.out.println("����ѧ�Ų�ѯ�ɹ���");
		          return rs;
		        } catch (SQLException e) {
		          System.out.println("����ѧ�Ų�ѯʧ�ܣ�");
		          e.printStackTrace();
		          return null;
		        }
	}
	 //4.��ѯ������card_name�鿴card_info�����������ӣ�����
	 public  ResultSet SelectCardInfoByCardName(Connection conn ,String card_name) {
			 pstm = null;
			 rs = null;
			 //select * from sys.card_info where card_name = '����'
		     String sql = "select * from sys.card_info where card_name = '";
		     sql = sql + card_name + "'";
		        try {  
		            pstm = conn.prepareStatement(sql);//Ԥ�������
		            System.out.println("SQL + "+sql);  
		            rs = pstm.executeQuery();
		            /*while (rs.next()){
		            	String card_id = rs.getString(1);
		            	String card_password = rs.getString(2);
		            	String card_name1 = rs.getString(3);
		            	String card_losted = rs.getString(4);
		            	 System.out.println(card_id);
		            	 System.out.println(card_password);
		            	 System.out.println(card_name1);
		            	 System.out.println(card_losted);
		          }*/
		         System.out.println("����������ѯ�ɹ���");
		         return rs;
		        } catch (SQLException e) {
		          System.out.println("����ѧ�Ų�ѯʧ�ܣ�");
		           e.printStackTrace();
		           return null;
		        } 
     }
	 //5.��ѯ������card_losted�鿴card_info������������
	 public ResultSet SelectCardInfoByCardLosted(Connection conn) {
		 System.out.println("------------- ");  
		     pstm = null;
			 rs = null;
		     String sql = "select * from sys.card_info where card_losted = '1'";
		     System.out.println("SQL + "+sql);  
		     try {  
		            pstm = conn.prepareStatement(sql);//Ԥ�������
		            System.out.println("SQL + "+sql);  
		            rs = pstm.executeQuery();
		            System.out.println("���ն�ʧ��ѯ�ɹ���");
		           /* while (rs.next()){
		            	 System.out.println("���ն�ʧ��ѯ�ɹ���");
		            	String card_id = rs.getString(1);
		            	String card_password = rs.getString(2);
		            	String card_name1 = rs.getString(3);
		            	String card_losted = rs.getString(4);
		            	 System.out.println(card_id);
		            	 System.out.println(card_password);
		            	 System.out.println(card_name1);
		            	 System.out.println(card_losted);
		            }*/
		            return rs;
		     } catch (SQLException e) {
		           System.out.println("���ն�ʧ��ѯʧ�ܣ�");
		           e.printStackTrace();
		           return null;
		     } 
	   }
	 //6.��ʧ������ card_info��ʧ  ���������ӣ�����
	 public  void UpdateCardInfoLosted(Connection conn,String card_id) {
		 pstm = null;
		 rs = null;
	     String sql = "update sys.card_info set sys.card_info.card_losted = '1' where card_id = '";
	     sql = sql + card_id + "'";
	     try {  
	            pstm = conn.prepareStatement(sql);//Ԥ�������
	            System.out.println("��ʧ  + "+sql);  
	            rs = pstm.executeQuery();
	            while (rs.next()){
	            	 System.out.println("���ն�ʧ��ѯ�ɹ���");
	            	 String card_id1 = rs.getString(1);
	            	 String card_password = rs.getString(2);
	            	 String card_name = rs.getString(3);
	            	 String card_losted = rs.getString(4);
	            	 System.out.println(card_id1);
	            	 System.out.println(card_password);
	            	 System.out.println(card_name);
	            	 System.out.println(card_losted);
	            }
	            System.out.println("���¹�ʧ�����ɹ���");
	     } catch (SQLException e) {
	           System.out.println("���¹�ʧ����ʧ�ܣ�");
	           e.printStackTrace();
	     } 
    }
	 //7.���ӣ���card_info�в������ݣ������ǣ�������,����,����,�û���,��ʧ
	 public  void AddCardInfo(Connection conn ,String card_id,String card_password,String card_name,String losted) {
	        String sql = "insert into sys.card_info values(?,?,?,?)";
	        try {
	            // ִ�в������ݲ���
	            pstm = conn.prepareStatement(sql);
	            pstm.setString(1, card_id);
	            pstm.setString(2, card_password);
	            pstm.setString(3, card_name);
	            pstm.setString(4, losted);
	            pstm.executeUpdate();
	            System.out.println("card_info����ɹ���");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("card_info����ʧ�ܣ�");
	        } 
		}
	   //8.ɾ������card_info��ɾ�����ݣ������ǣ�������,����
	    public  void DelCardInfo(Connection conn ,String card_id) {
	        String sql = "delete from sys.card_info where card_id = '";
	        sql = sql + card_id + "'";
	        System.out.println("SQL" + sql);
	        try {
	            pstm = conn.prepareStatement(sql);
	            pstm.executeUpdate();
	            System.out.println("card_infoɾ���ɹ���");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("card_infoɾ��ʧ�ܣ�");
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
