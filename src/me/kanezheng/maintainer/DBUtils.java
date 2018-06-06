package me.kanezheng.maintainer;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    /**
     * 与数据库建立连接
     * @return 返回连接对像
     * @throws Exception
     */

    public static Connection getConnection() throws Exception {

        System.out.println(DBUtils.class.getResource("").getPath());

        Properties properties = new Properties();
        InputStream inStream = DBUtils.class.getClassLoader().getResourceAsStream("me/kanezheng/maintainer/jdbc.properties");
        properties.load(inStream);

        String url = properties.getProperty("url");
        String driver = properties.getProperty("jdbcDriver");
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");

        Class.forName(driver).newInstance();

        return DriverManager.getConnection(url, userName, password);
    }

    /**
     * 释放资源
     * @param rs    ResultSet对象
     * @param pstmt PreparedStatement对象
     * @param conn  Connection对象
     */
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
