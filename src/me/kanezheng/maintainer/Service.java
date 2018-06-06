package me.kanezheng.maintainer;

import java.util.Set;

public class Service {
    private DAO dao;

    public Service() {
        this.dao = new DAO();
    }

    public int add(MicroService ms) throws Exception
    {
        return this.dao.insertOne(ms);
    }

    public int delete(String msname) throws Exception
    {
        return this.dao.deleteOne(msname);
    }

    public int update(MicroService ms) throws Exception
    {
        return this.dao.updateOne(ms);
    }

    public MicroService findOne(String msname) throws Exception
    {
        return this.dao.findOne(msname);
    }

    public Set<MicroService> findAll() throws Exception
    {
        return this.dao.findAll();
    }

}
