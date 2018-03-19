package JDBC;
///连接数据库
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
	 //1.连接数据库
	 public   Connection getConnection() {
	        try {
	            Class.forName(DRVIER);
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            if(connection==null){    
	                System.out.println("与oracle数据库连接失败！");  
	                return null;
	            }else{    
	                System.out.println("与oracle数据库连接成功！"); 
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
	 //2.查询：查看card-info表的所有信息，传入连接名
	 public  ResultSet SelectCardInfo(Connection conn ) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.card_info";
		        try {  
		            pstm = conn.prepareStatement(sql);//预处理语句
		            System.out.println("SQL + "+sql);
		           
		            rs = pstm.executeQuery(); 
		            System.out.println("查询成功！");
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
		          System.out.println("查询失败！");
		           e.printStackTrace();
		           return null;
		        } finally {
		          //  ReleaseResource();
		        }
		  }
	 //3.查询：按照card_id查看card_info，参数：连接，卡号
	 public  ResultSet SelectCardInfoByCardId(Connection conn ,String card_id) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.card_info where card_id = '";
		     sql = sql + card_id + "'";
		        try {  
		            pstm = conn.prepareStatement(sql);//预处理语句
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
		          System.out.println("按照学号查询成功！");
		          return rs;
		        } catch (SQLException e) {
		          System.out.println("按照学号查询失败！");
		          e.printStackTrace();
		          return null;
		        }
	}
	 //4.查询：按照card_name查看card_info，参数：连接，卡号
	 public  ResultSet SelectCardInfoByCardName(Connection conn ,String card_name) {
			 pstm = null;
			 rs = null;
			 //select * from sys.card_info where card_name = '观音'
		     String sql = "select * from sys.card_info where card_name = '";
		     sql = sql + card_name + "'";
		        try {  
		            pstm = conn.prepareStatement(sql);//预处理语句
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
		         System.out.println("按照姓名查询成功！");
		         return rs;
		        } catch (SQLException e) {
		          System.out.println("按照学号查询失败！");
		           e.printStackTrace();
		           return null;
		        } 
     }
	 //5.查询：按照card_losted查看card_info，参数：连接
	 public ResultSet SelectCardInfoByCardLosted(Connection conn) {
		 System.out.println("------------- ");  
		     pstm = null;
			 rs = null;
		     String sql = "select * from sys.card_info where card_losted = '1'";
		     System.out.println("SQL + "+sql);  
		     try {  
		            pstm = conn.prepareStatement(sql);//预处理语句
		            System.out.println("SQL + "+sql);  
		            rs = pstm.executeQuery();
		            System.out.println("按照丢失查询成功！");
		           /* while (rs.next()){
		            	 System.out.println("按照丢失查询成功！");
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
		           System.out.println("按照丢失查询失败！");
		           e.printStackTrace();
		           return null;
		     } 
	   }
	 //6.挂失：按照 card_info挂失  参数：连接，卡号
	 public  void UpdateCardInfoLosted(Connection conn,String card_id) {
		 pstm = null;
		 rs = null;
	     String sql = "update sys.card_info set sys.card_info.card_losted = '1' where card_id = '";
	     sql = sql + card_id + "'";
	     try {  
	            pstm = conn.prepareStatement(sql);//预处理语句
	            System.out.println("挂失  + "+sql);  
	            rs = pstm.executeQuery();
	            while (rs.next()){
	            	 System.out.println("按照丢失查询成功！");
	            	 String card_id1 = rs.getString(1);
	            	 String card_password = rs.getString(2);
	            	 String card_name = rs.getString(3);
	            	 String card_losted = rs.getString(4);
	            	 System.out.println(card_id1);
	            	 System.out.println(card_password);
	            	 System.out.println(card_name);
	            	 System.out.println(card_losted);
	            }
	            System.out.println("更新挂失操作成功！");
	     } catch (SQLException e) {
	           System.out.println("更新挂失操作失败！");
	           e.printStackTrace();
	     } 
    }
	 //7.增加：在card_info中插入数据，参数是：连接名,卡号,密码,用户名,挂失
	 public  void AddCardInfo(Connection conn ,String card_id,String card_password,String card_name,String losted) {
	        String sql = "insert into sys.card_info values(?,?,?,?)";
	        try {
	            // 执行插入数据操作
	            pstm = conn.prepareStatement(sql);
	            pstm.setString(1, card_id);
	            pstm.setString(2, card_password);
	            pstm.setString(3, card_name);
	            pstm.setString(4, losted);
	            pstm.executeUpdate();
	            System.out.println("card_info插入成功！");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("card_info插入失败！");
	        } 
		}
	   //8.删除：在card_info中删除数据，参数是：连接名,卡号
	    public  void DelCardInfo(Connection conn ,String card_id) {
	        String sql = "delete from sys.card_info where card_id = '";
	        sql = sql + card_id + "'";
	        System.out.println("SQL" + sql);
	        try {
	            pstm = conn.prepareStatement(sql);
	            pstm.executeUpdate();
	            System.out.println("card_info删除成功！");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("card_info删除失败！");
	        } 
		}
	 //9.释放资源
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
