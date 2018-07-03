package me.kanezheng.app;

import java.util.List;

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
    List<MicroService> findMicroServiceList();
}
