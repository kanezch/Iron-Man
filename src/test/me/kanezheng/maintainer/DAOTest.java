package test.me.kanezheng.maintainer; 

import me.kanezheng.maintainer.DAO;
import me.kanezheng.maintainer.MicroService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 
import org.junit.Assert.*;

/** 
* DAO Tester. 
* 
* @author <Authors name> 
* @since <pre>六月 6, 2018</pre> 
* @version 1.0 
*/ 
public class DAOTest { 

@Before
public void before() throws Exception {

} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: insertOne(MicroService ms) 
* 
*/ 
@Test
public void testInsertOne() throws Exception { 
//TODO: Test goes here...
    String msname = "devlogmgr";
    String msteam ="物联网";
    String msmaintainer = "胡昆智";
    String description = "日志管理微服务";

    MicroService ms = new MicroService(msname, msteam, msmaintainer,description);

    DAO dao = new DAO();
    int result = dao.insertOne(ms);
    Assert.assertEquals(result, 1);
} 

/** 
* 
* Method: deleteOne(String msname) 
* 
*/ 
@Test
public void testDeleteOne() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findOne(String msname) 
* 
*/ 
@Test
public void testFindOne() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateOne(MicroService ms) 
* 
*/ 
@Test
public void testUpdateOne() throws Exception { 
//TODO: Test goes here... 
} 


} 
