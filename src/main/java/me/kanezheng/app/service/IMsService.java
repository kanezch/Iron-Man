package me.kanezheng.app.service;

import me.kanezheng.app.response.FindResultResponse;
import me.kanezheng.app.model.MicroService;

/**
 * Created by
 *
 * @author kane
 * @date 2018/6/30
 */
public interface IMsService {
    int add(MicroService ms);
    int update(MicroService ms);
    int delete(String msName);
    MicroService findMicroServiceByName(String msName);
    FindResultResponse findPageAble(int pageNum, int pageSize);
}
