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
    
    @Override
    public List<MicroService> findMicroServiceList () {
        ArrayList<MicroService> list = new ArrayList<>();
        List rows = jdbcTemplate.queryForList("SELECT * FROM MicroService");

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
        }

        return list;

    }
}
