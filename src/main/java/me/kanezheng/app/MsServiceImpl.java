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
    public int delete(String msName) {
        return microServiceDAO.delete(msName);
    }

    @Override
    public MicroService findMicroServiceByName(String msName) {
        return microServiceDAO.findMicroServiceByName(msName);
    }

    @Override
    public List<MicroService> findMicroServiceList() {
        return microServiceDAO.findMicroServiceList();
    }
}
