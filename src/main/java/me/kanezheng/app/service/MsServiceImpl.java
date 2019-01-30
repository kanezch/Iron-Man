package me.kanezheng.app.service;

import me.kanezheng.app.response.FindResultResponse;
import me.kanezheng.app.dao.IMicroServiceDAO;
import me.kanezheng.app.model.MicroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public FindResultResponse findPageAble(int pageNum, int pageSize) {
        return microServiceDAO.findPageAble(pageNum, pageSize);
    }
}
