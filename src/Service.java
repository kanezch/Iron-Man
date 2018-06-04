public class Service {
    public static DAO dao = new DAO();

    public int add(MicroService ms) throws Exception
    {
        return this.dao.addMicroService(ms);
    }

    public int delete(String msname) throws Exception
    {
        return this.dao.delMicroService(msname);
    }

//    public int update(String msname)
//    {
//        return this.dao.
//    }

    public MicroService find(String msname) throws Exception
    {
        return this.dao.getMicroService(msname);
    }

//    public Set<MicroService> findAll()
//    {
//        return this.dao.getAllMicroServices();
//    }

}
