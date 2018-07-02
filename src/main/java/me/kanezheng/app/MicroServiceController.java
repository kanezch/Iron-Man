package me.kanezheng.app;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/microservice")
public class MicroServiceController {

    @Autowired
    IMsService msService;

    @RequestMapping(value="/list",method = RequestMethod.GET)
    public  List<MicroService> getMicroServices(){
        return msService.findMicroServiceList();
    }

    @RequestMapping(value="/{msname}", method = RequestMethod.GET)
    public MicroService getMicroServiceByName(@PathVariable("msname") String msname){
        return  msService.findMicroServiceByName(msname);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addMicroService(@RequestParam(value = "msname")String msname,
                                  @RequestParam(value = "msteam")String msteam,
                                  @RequestParam(value = "msmaintainer")String msmaintainer,
                                  @RequestParam(value = "msdescription")String msdescription){
        MicroService ms = new MicroService();
        ms.setMsname(msname);
        ms.setMsname(msteam);
        ms.setMsname(msmaintainer);
        ms.setMsname(msdescription);

        int c = msService.add(ms);
        if (c==1){
            return ms.toString();
        }else {
            return "fail";
        }
    }
}
