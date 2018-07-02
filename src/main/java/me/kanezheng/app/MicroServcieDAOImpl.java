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
        return jdbcTemplate.update("INSERT INTO msmaintain_tbl(ms_name, ms_team, ms_maintainer, ms_description) VALUES (?,?,?,?)",
                ms.getMsName(),ms.getMsTeam(),ms.getMsMaintainer(),ms.getMsDesc());
    }

    @Override
    public int update(MicroService ms){
        return jdbcTemplate.update("UPDATE msmaintain_tbl SET ms_team=?,ms_maintainer=?,ms_description=?",
                ms.getMsTeam(), ms.getMsMaintainer(), ms.getMsDesc());
    }

    @Override
    public int delete(String msname){
        return jdbcTemplate.update("DELETE FROM TABLE msmaintain_tbl WHERE ms_name=?", msname);
    }

    @Override
    public MicroService findMicroServiceByName(String msname){
        List<MicroService> list = jdbcTemplate.query("SELECT * FROM msmaintain_tbl WHERE ms_name=?", new Object[]{msname}, new BeanPropertyRowMapper<>(MicroService.class));
        if (list!=null && list.size()>0){
            return list.get(0);
        }else {
            return null;
        }
    }
    
    @Override
    public List<MicroService> findMicroServiceList () {
        ArrayList<MicroService> list = new ArrayList<>();
        List rows = jdbcTemplate.queryForList("SELECT * FROM msmaintain_tbl");

        for (Object item : rows)
        {
            Map rowMap = (Map) item;
            MicroService ms = new MicroService();
            ms.setMsName((String) rowMap.get("ms_name"));
            ms.setMsTeam((String) rowMap.get("ms_team"));
            ms.setMsMaintainer((String) rowMap.get("ms_maintainer"));
            ms.setMsDesc((String) rowMap.get("ms_description"));

            list.add(ms);
        }

        return list;

    }
}
