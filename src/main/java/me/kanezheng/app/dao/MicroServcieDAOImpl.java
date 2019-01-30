package me.kanezheng.app.dao;

import me.kanezheng.app.response.FindResultResponse;
import me.kanezheng.app.model.MicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MicroServcieDAOImpl implements IMicroServiceDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(MicroService ms){
        String sql = "INSERT INTO msmaintain_tbl (msName, msTeam, msMaintainer, msDesc, " +
                     "codeLang, bIsRestWS, servicePort) VALUES (?,?,?,?,?,?,?)";
        Object args[] = {ms.getMsName(),ms.getMsTeam(),ms.getMsMaintainer(),ms.getMsDesc(),
                         ms.getCodeLang(),ms.getbIsRestWS(),ms.getServicePort()};

        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int update(MicroService ms){
        String sql = "UPDATE msmaintain_tbl SET msTeam=?, msMaintainer=?, msDesc=?, codeLang=?," +
                     "bIsRestWS=?, servicePort=?";
        Object args[] = {ms.getMsTeam(), ms.getMsMaintainer(), ms.getMsDesc(),ms.getCodeLang(),
                         ms.getbIsRestWS(), ms.getServicePort()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int delete(String msName){
        String sql = "DELETE FROM msmaintain_tbl WHERE msName=?";
        Object args[] = {msName};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public MicroService findMicroServiceByName(String msName){

        String sql = "SELECT * FROM msmaintain_tbl WHERE msName=";

        StringBuilder strsql=new StringBuilder(sql);
        strsql.append("'");
        strsql.append(msName);
        strsql.append("'");


        List rows = jdbcTemplate.queryForList(strsql.toString());

        if (rows.size() == 0){
            return null;
        }else {
            Map rowMap = (Map) rows.get(0);
            MicroService ms = new MicroService();
            ms.setMsName((String) rowMap.get("msName"));
            ms.setMsTeam((String) rowMap.get("msTeam"));
            ms.setMsMaintainer((String) rowMap.get("msMaintainer"));
            ms.setMsDesc((String) rowMap.get("msDesc"));
            ms.setCodeLang((String) rowMap.get("codeLang"));

            Boolean bIsRestWS = (Boolean) rowMap.get("bIsRestWS");
            ms.setbIsRestWS(bIsRestWS);

            if(bIsRestWS){
                ms.setServicePort((int) rowMap.get("servicePort"));
            }else {
                ms.setServicePort(-1);
            }

            return ms;
        }
    }

    @Override
    public FindResultResponse findPageAble (int pageNum, int pageSize) {

        /* 查询总数 */
        String sql = "SELECT COUNT(*) FROM msmaintain_tbl";
        int totalCount = jdbcTemplate.queryForObject(sql, Integer.class);

        /* 基于当前的pageSize计算出总页数 */
        int totalPageNum = (int)Math.ceil((double)totalCount / (double)pageSize);

        /* 用StringBuilder拼装分页查询sql语句 */
        StringBuilder sqlSb = new StringBuilder("SELECT * FROM msmaintain_tbl LIMIT ");
        int offSet = (pageNum - 1) * pageSize;
        sqlSb.append(offSet);
        sqlSb.append(",");
        sqlSb.append(pageSize);
        sql = sqlSb.toString();

        ArrayList<MicroService> list = new ArrayList<>();
        List rows = jdbcTemplate.queryForList(sql);
        for (Object item : rows)
        {
            Map rowMap = (Map) item;
            MicroService ms = new MicroService();
            ms.setMsName((String) rowMap.get("msName"));
            ms.setMsTeam((String) rowMap.get("msTeam"));
            ms.setMsMaintainer((String) rowMap.get("msMaintainer"));
            ms.setMsDesc((String) rowMap.get("msDesc"));
            ms.setCodeLang((String) rowMap.get("codeLang"));

            Boolean bIsRestWS = (Boolean) rowMap.get("bIsRestWS");
            ms.setbIsRestWS(bIsRestWS);

            if(bIsRestWS){
                Number num = (Number)rowMap.get("servicePort");
                ms.setServicePort(num.intValue());
            }else {
                ms.setServicePort(-1);
            }

            list.add(ms);
        }

        FindResultResponse rs  = new FindResultResponse();
        rs.setPageNum(pageNum);
        rs.setPageSize(pageSize);
        rs.setTotalCount(totalCount);
        rs.setTotalPageNum(totalPageNum);
        rs.setResultSet(list);
        return rs;
    }
}
