import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Kane Zheng
 */
public class ConnectDatabase {
    public static void main(String[] args) {

        System.out.println("MySQL Connect Example.");
        Connection conn = null;
        String url = "jdbc:mysql://172.27.24.128:3306/";
        String dbName = "test";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "Aa123456";


        PreparedStatement  pstmt = null;
        ResultSet rs = null;

        try {
            /**
             * 数据库连接与关闭
             */
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");


            /**
             * 查询
             */
            String sql = "SELECT * from msmaintain_tbl;";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println(rs.getMetaData().getColumnCount());


            /**
             * 关闭资源
             */
            rs.close();
            pstmt.close();
            conn.close();
            System.out.println("Disconnected from database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

