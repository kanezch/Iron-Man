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
                ms.getMsname(),ms.getMsteam(),ms.getMsmaintainer(),ms.getDescription());
    }

    @Override
    public int update(MicroService ms){
        return jdbcTemplate.update("UPDATE msmaintain_tbl SET ms_team=?,ms_maintainer=?,ms_description=?",
                ms.getMsteam(), ms.getMsmaintainer(), ms.getDescription());
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

/*        System.out.println("kane:findmslist!!");

        List<MicroService> list = jdbcTemplate.query("select * from msmaintain_tbl", new Object[]{}, new BeanPropertyRowMapper(MicroService.class));
        if (list != null && list.size() > 0) {
            System.out.println("kane:list.size="+list.size());
            return list;
        } else {
            return null;
        }*/
        ArrayList<MicroService> list = new ArrayList<>();
        List rows = jdbcTemplate.queryForList("SELECT * FROM msmaintain_tbl");
        for (int i = 0; i < rows.size(); i++) {
            Map rowMap = (Map) rows.get(i);

            MicroService ms = new MicroService();
            ms.setMsname((String) rowMap.get("ms_name"));
            ms.setMsteam((String) rowMap.get("ms_team"));
            ms.setMsmaintainer((String) rowMap.get("ms_maintainer"));
            ms.setDescription((String) rowMap.get("ms_description"));

            list.add(ms);
        }

        return list;

    }
}
