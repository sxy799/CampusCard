package JDBC;
///连接数据库
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
	 //2.查询：查看consume-info表的所有信息，传入连接名
	 public  ResultSet SelectConsumeInfo(Connection conn ) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.consume_info";
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
		        } finally {
		          //  ReleaseResource();
		        }
		  }
	 //3.查询：按照card_id查看consume_info，参数：连接，卡号
	 public  ResultSet SelectCardInfoByCardId(Connection conn ,String card_id) {
			 pstm = null;
			 rs = null;
		     String sql = "select * from sys.consume_info where card_id = '";
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
	 //4.得到余额：  参数：连接，卡号，consume_how,money
	     public  double UpdateConsumeInfoMoney(Connection conn,String card_id,double consume_how) {
		 pstm = null;
		 rs = null;
		 double money = 0.0; 
	     String sql = "select money from sys.consume_info where card_id = '";
	     sql = sql + card_id + "'";
	     try {  
	            pstm = conn.prepareStatement(sql);//预处理语句
	            System.out.println("得到余额  + "+sql);  
	            rs = pstm.executeQuery();
	            while (rs.next()){
	            	 money = rs.getDouble(1);
	            	 System.out.println(money);
	            }
	            System.out.println("查找余额操作成功！");
	     } catch (SQLException e) {
	           System.out.println("查找余额操作失败！");
	           e.printStackTrace();
	           return 0.0;
	     }
	     double  ans = consume_how + money;
	     //update sys.consume_info set sys.consume_info.money = 80.56 where card_id = 'we221111'; 
	     sql ="update sys.consume_info set sys.consume_info.money = "+String.valueOf(money)+" where card_id = '";
	     sql = sql + card_id + "'";
	     System.out.println("SQL" + sql);
	     try {  
	            pstm = conn.prepareStatement(sql);//预处理语句
	            rs = pstm.executeQuery();
	            System.out.println("更新余额操作成功！");
	            return rs.getDouble(1);
	     } catch (SQLException e) {
	           System.out.println("更新余额操作失败！");
	           e.printStackTrace();
	           return 0.0;
	     }
	 }
	 //7.增加：在consume_info中插入数据，参数是：连接名,卡号,card_id,consume_time,consume_name,consume_how
	 public  void AddConsumeInfo(Connection conn ,String card_id,String consume_name,String consume_how,double money) {
		   ///得到时间
		    Calendar c = new GregorianCalendar();
		    java.util.Date d = c.getTime();
		    DateFormat df = new SimpleDateFormat("yyyyMMdd");
		    String consume_time = df.format(d);
		    System.out.println(d);
		    
		    String sql = "insert into sys.card_info values(?,?,?,?,?)";
	        try {
	            // 执行插入数据操作
	            pstm = conn.prepareStatement(sql);
	            pstm.setString(1, card_id);
	            pstm.setString(2, consume_time);
	            pstm.setString(3, consume_name);
	            pstm.setString(4, consume_how);
	            pstm.setDouble(5, money);
	            pstm.executeUpdate();
	            System.out.println("card_info插入成功！");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("card_info插入失败！");
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
