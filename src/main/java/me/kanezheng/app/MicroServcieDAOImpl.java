package me.kanezheng.app;

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
        String sql = "INSERT INTO MicroService (name, team, maintainer, description, " +
                     "codelanguage, isrestwebservice, serviceport) VALUES (?,?,?,?,?,?)";
        Object args[] = {ms.getMsName(),ms.getMsTeam(),ms.getMsMaintainer(),ms.getMsDesc(),
                         ms.getCodeLang(),ms.getbIsRestWS(),ms.getServicePort()};

        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int update(MicroService ms){
        String sql = "UPDATE MicroService SET team=?,maintainer=?,description=?,codelanguage=?," +
                     "isrestwebservice=?,serviceport=?";
        Object args[] = {ms.getMsTeam(), ms.getMsMaintainer(), ms.getMsDesc(),ms.getCodeLang(),
                         ms.getbIsRestWS(), ms.getServicePort()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int delete(String msName){
        String sql = "DELETE FROM MicroService WHERE name=?";
        Object args[] = {msName};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public MicroService findMicroServiceByName(String msName){

        String sql = "SELECT * FROM MicroService WHERE name=";

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
            ms.setMsName((String) rowMap.get("name"));
            ms.setMsTeam((String) rowMap.get("team"));
            ms.setMsMaintainer((String) rowMap.get("maintainer"));
            ms.setMsDesc((String) rowMap.get("description"));
            ms.setCodeLang((String) rowMap.get("codelanguage"));

            Boolean bIsRestWS = (Boolean) rowMap.get("isrestwebservice");
            ms.setbIsRestWS(bIsRestWS);

            if(bIsRestWS){
                ms.setServicePort((int) rowMap.get("serviceport"));
            }else {
                ms.setServicePort(-1);
            }

            return ms;
        }
    }
    
//    @Override
//    public List<MicroService> findMicroServiceList () {
//        ArrayList<MicroService> list = new ArrayList<>();
//        List rows = jdbcTemplate.queryForList("SELECT * FROM MicroService");
//
//        for (Object item : rows)
//        {
//            Map rowMap = (Map) item;
//            MicroService ms = new MicroService();
//            ms.setMsName((String) rowMap.get("name"));
//            ms.setMsTeam((String) rowMap.get("team"));
//            ms.setMsMaintainer((String) rowMap.get("maintainer"));
//            ms.setMsDesc((String) rowMap.get("description"));
//            ms.setCodeLang((String) rowMap.get("codelanguage"));
//
//            Boolean bIsRestWS = (Boolean) rowMap.get("isrestwebservice");
//            ms.setbIsRestWS(bIsRestWS);
//
//            if(bIsRestWS){
//                ms.setServicePort((int) rowMap.get("serviceport"));
//            }else {
//                ms.setServicePort(-1);
//            }
//
//            list.add(ms);
//        }
//
//        return list;
//    }

    public FindResultResponse findPageAble (int pageNum, int pageSize) {

        /* 查询总数 */
        String sql = "SELECT COUNT(*) FROM MicroService";
        int totalCount = jdbcTemplate.queryForObject(sql, Integer.class);

        /* 基于当前的pageSize计算出总页数 */
        int totalPageNum = (int)Math.ceil((double)totalCount / (double)pageSize);

        /* 用StringBuilder拼装分页查询sql语句 */
        StringBuilder sqlSb = new StringBuilder("SELECT * FROM MicroService LIMIT ");
        int offSet = (pageNum - 1) * pageSize;
        sqlSb.append(offSet);
        sqlSb.append(",");
        sqlSb.append(pageSize);
        sql = sqlSb.toString();

        System.out.println(sql);
        ArrayList<MicroService> list = new ArrayList<>();
        List rows = jdbcTemplate.queryForList(sql);
        for (Object item : rows)
        {
            Map rowMap = (Map) item;
            MicroService ms = new MicroService();
            ms.setMsName((String) rowMap.get("name"));
            ms.setMsTeam((String) rowMap.get("team"));
            ms.setMsMaintainer((String) rowMap.get("maintainer"));
            ms.setMsDesc((String) rowMap.get("description"));
            ms.setCodeLang((String) rowMap.get("codelanguage"));

            Boolean bIsRestWS = (Boolean) rowMap.get("isrestwebservice");
            ms.setbIsRestWS(bIsRestWS);

            if(bIsRestWS){
                ms.setServicePort((int) rowMap.get("serviceport"));
            }else {
                ms.setServicePort(-1);
            }

            list.add(ms);

            System.out.println(ms.toString());
        }

        System.out.println("list size is:" + list.size());

        FindResultResponse rs  = new FindResultResponse();
        rs.setPageNum(pageNum);
        rs.setPageSize(pageSize);
        rs.setTotalCount(totalCount);
        rs.setTotalPageNum(totalPageNum);
        rs.setResultSet(list);
        return rs;
    }
}
