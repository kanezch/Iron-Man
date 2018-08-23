package me.kanezheng.app;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/v1/microservices")
public class MicroServiceController {

    private static final Logger logger = LogManager.getLogger(MicroServiceController.class);

    @Autowired
    IMsService msService;

    @RequestMapping(value="",method = RequestMethod.GET)
    public  ResponseEntity<FindResultResponse> getMicroServices(@RequestParam(value = "pageNum")Integer pageNum,
                                                                @RequestParam(value = "pageSize")Integer pageSize){

        logger.info("Get all microservices:" + "pageNum=" + pageNum + ", pageSize=" + pageSize);
        FindResultResponse resultResponse = msService.findPageAble(pageNum,pageSize);


        logger.info("Get microServices succeed!");
        return new ResponseEntity(resultResponse, HttpStatus.OK);
    }

    @RequestMapping(value="/{msName}", method = RequestMethod.GET)
    public ResponseEntity<MicroService> getMicroServiceByName(@PathVariable("msName") String msName){

        MicroService m = msService.findMicroServiceByName(msName);
        if (null == m){

            throw new MicroServiceNotFoundException("Not Found!");
        }else {

            return new ResponseEntity(m, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addMicroService(@Valid @RequestBody MicroService ms){

        logger.info("Add new microservice:{}", ms.toString());

        int c = msService.add(ms);
        if (c == 1){
            return new ResponseEntity(HttpStatus.CREATED);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{msName}", method = RequestMethod.PUT)
    public ResponseEntity updateMicroService(@Valid @RequestBody MicroService ms){

        logger.info("Update microservice:{}", ms.toString());
        int c = msService.update(ms);
        if (c == 1){
            return new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(value = "/{msName}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMicroService(@PathVariable("msName")String msName){
       int c = msService.delete(msName);
        if (c == 1){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
