package me.kanezheng.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class MicroServcieDAOImpl implements IMicroServiceDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int add(MicroService ms){
        return jdbcTemplate.update("INSERT INTO MicroService (name, team, maintainer, description, " +
                                   "codelanguage, isrestwebservice, serviceport) VALUES (?,?,?,?,?,?)",
                                    ms.getMsName(),ms.getMsTeam(),ms.getMsMaintainer(),ms.getMsDesc(),
                                    ms.getCodeLang(),ms.getbIsRestWS(),ms.getServicePort());
    }

    @Override
    public int update(MicroService ms){
        return jdbcTemplate.update("UPDATE MicroService SET team=?,maintainer=?,description=?,codelanguage=?," +
                                   "isrestwebservice=?,serviceport=?)", ms.getMsTeam(), ms.getMsMaintainer(),
                                   ms.getMsDesc(),ms.getCodeLang(), ms.getbIsRestWS(), ms.getServicePort());
    }

    @Override
    public int delete(String msName){
        return jdbcTemplate.update("DELETE FROM TABLE MicroService WHERE name=?", msName);
    }

    @Override
    public MicroService findMicroServiceByName(String msName){
        List<MicroService> list = jdbcTemplate.query("SELECT * FROM MicroService WHERE name=?", new Object[]{msName},
                                                     new BeanPropertyRowMapper<>(MicroService.class));
        if (list!=null && list.size()>0){
            return list.get(0);
        }else {
            return null;
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
            }


            list.add(ms);
        }

        return list;

    }
}
