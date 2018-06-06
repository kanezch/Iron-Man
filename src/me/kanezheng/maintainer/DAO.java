package me.kanezheng.maintainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;


public class DAO {
    /**
     * 新增微服务
     * @param ms
     * @return rs
     * @throws Exception
     */
    public int insertOne(MicroService ms) throws Exception {
        int result = 0;

        Connection conn = DBUtils.getConnection();

        String sql = "INSERT INTO msmaintain_tbl" +
                "(ms_name,ms_team,ms_maintainer,ms_description) value(?,?,?,?)";

        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, ms.getMsname());
        psmt.setString(2, ms.getMsteam());
        psmt.setString(3, ms.getMsmaintainer());
        psmt.setString(4, ms.getDescription());
        result = psmt.executeUpdate();

        DBUtils.close(null, psmt, conn);

        return result;
    }

    /**e
     * 删除微服务
     * @param msname name of ms
     * @return result
     * @throws Exception e
     */
    public int deleteOne(String msname) throws Exception {
        int result = 0;
        Connection conn = DBUtils.getConnection();

        String sql = "DELETE FROM msmaintain_tbl where msname=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, msname);

        result = psmt.executeUpdate();
        DBUtils.close(null, psmt, conn);
        return result;
    }



    /**
     * 获取微服务
     * @param msname ms
     * @return rs
     * @throws Exception e
     */
    public MicroService findOne(String msname) throws Exception {
        MicroService ms = null;
        Connection conn = DBUtils.getConnection();

        String sql = "SELECT FROM msmaintain_tbl where msname=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, msname);

        ResultSet rs = psmt.executeQuery();
        if (rs.next()){
            ms = new MicroService();
            ms.setMsname(rs.getString(1));
            ms.setMsteam(rs.getString(2));
            ms.setMsmaintainer(rs.getString(3));
            ms.setDescription(rs.getString(4));
        }

        DBUtils.close(null, psmt, conn);
        return ms;
    }

    /**
     *
     * @return <MicroService> msSet
     * @throws Exception e
     */

    public Set<MicroService> findAll () throws Exception {
        Connection conn = DBUtils.getConnection();
        Set<MicroService> msSet = new HashSet<MicroService>();

        String sql = "SELECT * FROM msmaintain_tbl;";
        PreparedStatement psmt = conn.prepareStatement(sql);

        ResultSet rs = psmt.executeQuery();
        while (rs.next()){
            MicroService ms = new MicroService();

            ms.setMsname(rs.getString(1));
            ms.setMsteam(rs.getString(2));
            ms.setMsmaintainer(rs.getString(3));
            ms.setDescription(rs.getString(4));

            msSet.add(ms);
        }

        return msSet;
    }

    /**
     * 更新一条记录
     * @param ms
     * @return
     * @throws Exception
     */
    public int updateOne(MicroService ms) throws Exception {
        int result = 0;

        Connection conn = DBUtils.getConnection();

        String sql = "UPDATE msmaintain_tbl SET " +
                "ms_team=?,ms_maintainer=?,ms_description=? WHERE ms_name=?";

        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, ms.getMsteam());
        psmt.setString(2, ms.getMsmaintainer());
        psmt.setString(3, ms.getDescription());
        psmt.setString(4, ms.getMsname());
        result = psmt.executeUpdate();

        DBUtils.close(null, psmt, conn);

        return result;
    }
}
