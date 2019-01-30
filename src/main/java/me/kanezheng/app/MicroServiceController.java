package me.kanezheng.app;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.validation.Valid;


@RestController
@RequestMapping(value = "/v1/microservices")
public class MicroServiceController {

    private final static Log logger = LogFactory.getLog(MicroServiceController.class);

    @Autowired
    IMsService msService;

    @RequestMapping(value="",method = RequestMethod.GET)
    public  ResponseEntity<FindResultResponse> getMicroServices(@RequestParam(value = "pageNum")Integer pageNum,
                                                                @RequestParam(value = "pageSize")Integer pageSize){

        FindResultResponse resultResponse = msService.findPageAble(pageNum, pageSize);

        logger.info(String.format("Get all microservices:pageNum=%s, pageSize=%s", pageNum, pageSize));

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

        logger.info(String.format("Add new microservice:%s", ms.toString()));

        int c = msService.add(ms);
        if (c == 1){
            return new ResponseEntity(HttpStatus.CREATED);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{msName}", method = RequestMethod.PUT)
    public ResponseEntity updateMicroService(@Valid @RequestBody MicroService ms){
        logger.info(String.format("Update microservice:%s", ms.toString()));

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
