import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DAO {
    /**
     * ���һ������
     * @param ms ΢�������
     * @return Count
     * @throws Exception e
     */
    public int addMicroService(MicroService ms) throws Exception {
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

    /**
     * ɾ��һ������
     * @param msname
     * @return
     * @throws Exception
     */
    public int delMicroService(String msname) throws Exception {
        int result = 0;
        Connection conn = DBUtils.getConnection();

        String sql = "DELETE FROM msmaintain_tbl where msname=?";
        PreparedStatement psmt = conn.prepareStatement(sql);
        psmt.setString(1, msname);

        result = psmt.executeUpdate();
        DBUtils.close(null, psmt, conn);
        return result;
    }

/*    public int updateMicroService(String sql, Object... args) {

    }*/

    /**
     * ��ѯһ������
     * @param msname
     * @return
     * @throws Exception
     */
    public MicroService getMicroService(String msname) throws Exception {
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

/*    public Set<MicroService> getAllMicroServices() {

    }*/
}
