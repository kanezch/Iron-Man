package me.kanezheng.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsServiceImpl implements IMsService{

    @Autowired
    IMicroServiceDAO microServiceDAO;

    @Override
    public int add(MicroService ms) {
        return microServiceDAO.add(ms);
    }

    @Override
    public int update(MicroService ms) {
        return microServiceDAO.update(ms);
    }

    @Override
    public int delete(String msname) {
        return microServiceDAO.delete(msname);
    }

    @Override
    public MicroService findMicroServiceByName(String msname) {
        return microServiceDAO.findMicroServiceByName(msname);
    }

    @Override
    public List<MicroService> findMicroServiceList() {
        return microServiceDAO.findMicroServiceList();
    }
}
