package me.kanezheng.app;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/microservices")
public class MicroServiceController {

    @Autowired
    IMsService msService;

    @RequestMapping(value="",method = RequestMethod.GET)
    public  List<MicroService> getMicroServices(){
        return msService.findMicroServiceList();
    }

    @RequestMapping(value="/{msName}", method = RequestMethod.GET)
    public MicroService getMicroServiceByName(@PathVariable("msName") String msName){
        return  msService.findMicroServiceByName(msName);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addMicroService(@RequestParam(value = "msName")String msName,
                                  @RequestParam(value = "msTeam")String msTeam,
                                  @RequestParam(value = "msMaintainer")String msMaintainer,
                                  @RequestParam(value = "msDesc")String msDesc,
                                  @RequestParam(value = "codeLang")String codeLang,
                                  @RequestParam(value = "bIsRestWS")Boolean bIsRestWS,
                                  @RequestParam(value = "servicePort")int servicePort){
        MicroService ms = new MicroService();
        ms.setMsName(msName);
        ms.setMsTeam(msTeam);
        ms.setMsMaintainer(msMaintainer);
        ms.setMsDesc(msDesc);
        ms.setCodeLang(codeLang);
        ms.setbIsRestWS(bIsRestWS);
        ms.setServicePort(servicePort);

        int c = msService.add(ms);
        if (c==1){
            return ms.toString();
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/{msName}", method = RequestMethod.PUT)
    public String updateMicroService(@PathVariable("msName")String msName,
                                     @RequestParam(value = "msTeam")String msTeam,
                                     @RequestParam(value = "msMaintainer")String msMaintainer,
                                     @RequestParam(value = "msDesc")String msDesc,
                                     @RequestParam(value = "codeLang")String codeLang,
                                     @RequestParam(value = "bIsRestWS")Boolean bIsRestWS,
                                     @RequestParam(value = "servicePort")int servicePort){
        MicroService ms = new MicroService();
        ms.setMsName(msName);
        ms.setMsTeam(msTeam);
        ms.setMsMaintainer(msMaintainer);
        ms.setMsDesc(msDesc);
        ms.setCodeLang(codeLang);
        ms.setbIsRestWS(bIsRestWS);
        ms.setServicePort(servicePort);

        int c = msService.update(ms);
        if (c==1){
            return ms.toString();
        }else {
            return "fail";
        }
    }


    @RequestMapping(value = "/{msName}", method = RequestMethod.DELETE)
    public String deleteMicroService(@PathVariable("msName")String msName){
       int c = msService.delete(msName);
        if (c==1){
            return "success";
        }else {
            return "fail";
        }
    }
}
