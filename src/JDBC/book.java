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
	//0.得到续借时间
	 public String GetTime () {
	   Calendar c = new GregorianCalendar();
	   java.util.Date d = c.getTime();
	   c.add(Calendar.DAY_OF_MONTH, 10);//今天的基础上加一天
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
	 //2.查询：查看book-info表的所有信息，传入连接名
	 public  ResultSet SelectBookInfo(Connection conn ) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.book_info";
		        try {  
		            pstm = conn.prepareStatement(sql);//预处理语句
		            System.out.println("SQL + "+sql);
		            rs = pstm.executeQuery(); 
		            System.out.println("查询成功！");
		            return rs;
		        } catch (SQLException e) {
		          System.out.println("查询失败！");
		           e.printStackTrace();
		           return null;
		        } 
		  }
	 //3.查询：按照card_id查看book_info，参数：连接，卡号
	 public  ResultSet SelectBookInfoByCardId(Connection conn ,String card_id) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.book_info where card_id = '";
		     sql = sql + card_id + "'";
		        try {  
		            pstm = conn.prepareStatement(sql);//预处理语句
		            System.out.println("SQL + "+sql);
		            rs = pstm.executeQuery();		     
		          System.out.println("按照学号查询成功！");
		          return rs;
		        } catch (SQLException e) {
		          System.out.println("按照学号查询失败！");
		          e.printStackTrace();
		          return null;
		        }
	}
	 //5.查询：按照borrowed查看book_info，参数：连接
	 public ResultSet SelectBookInfoByBorrowed(Connection conn) {
		 System.out.println("------------- ");  
		     pstm = null;
			 rs = null;
		     String sql = "select * from sys.book_info where borrowed = '1' ";
		     System.out.println("SQL + "+sql);  
		     try {  
		            pstm = conn.prepareStatement(sql);//预处理语句
		            System.out.println("SQL + "+sql);  
		            rs = pstm.executeQuery();
		            System.out.println("按照未归还查询成功！");
		            return rs;
		     } catch (SQLException e) {
		           System.out.println("按照未归还查询失败！");
		           e.printStackTrace();
		           return null;
		     } 
	   }
	 //6.还书：按照 card_Id 更新参数
	 public  void UpdateBookInfoReturn(Connection conn,String card_id,String book_id) {
		 pstm = null;
		 rs = null;
		 //update sys.book_info set sys.book_info.borrowed = '0' where card_id = 'we222222' and book_id = '2001';
	     String sql = "update sys.book_info set sys.book_info.borrowed = '1' where card_id = '";
	     sql = sql + card_id + "' and book_id = '" + book_id + "'";
	     try {  
	            pstm = conn.prepareStatement(sql);//预处理语句
	            System.out.println("还书  + "+sql);  
	            rs = pstm.executeQuery();
	            System.out.println("更新还书 操作成功！");
	     } catch (SQLException e) {
	           System.out.println("更新还书 操作失败！");
	           e.printStackTrace();
	     } 
    }
	 //6.续借：按照 card_Id 更新归还期限
	 public  void UpdateBookInfoDeadline(Connection conn,String card_id) {
		 pstm = null;
		 rs = null;
		 String t = GetTime();
		 System.out.println("----" + t);
		 //update sys.book_info set sys.book_info.borrowed = '0' where card_id = 'we222222' and book_id = '2001';
	     String sql = "update sys.book_info set sys.book_info.deadline = '"+ t +"' where card_id = '";
	     sql = sql + card_id + "'" ;
	     try {  
	            pstm = conn.prepareStatement(sql);//预处理语句
	            System.out.println("续借  + "+sql);  
	            rs = pstm.executeQuery();
	            System.out.println("更新还书 操作成功！");
	     } catch (SQLException e) {
	           System.out.println("更新还书 操作失败！");
	           e.printStackTrace();
	     } 
    }
	 //7.借书：在book_info中插入数据，参数是：连接名,card_id, book_id,book_name,borrowed,deadline
	 public  void AddBookInfo(Connection conn ,String card_id, String book_id, String book_name,String borrowed,String deadline) {
	        String sql = "insert into sys.book_info values(?,?,?,?,?)";
	        try {
	            // 执行插入数据操作
	            pstm = conn.prepareStatement(sql);
	            pstm.setString(1, card_id);
	            pstm.setString(2, book_id);
	            pstm.setString(3, book_name);
	            pstm.setString(4, borrowed);
	            pstm.setString(5, deadline);
	            pstm.executeUpdate();
	            System.out.println("book_info插入成功！");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("book_info插入失败！");
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
