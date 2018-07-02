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
    int delete(String msname);
    MicroService findMicroServiceByName(String msname);
    List<MicroService> findMicroServiceList();
}
