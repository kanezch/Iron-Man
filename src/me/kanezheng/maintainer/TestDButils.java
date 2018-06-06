package me.kanezheng.maintainer;

import java.sql.Connection;

public class TestDButils {
    public static void main(String[] args) throws Exception {

        Connection conn = DBUtils.getConnection();
        conn.close();
    }
}
