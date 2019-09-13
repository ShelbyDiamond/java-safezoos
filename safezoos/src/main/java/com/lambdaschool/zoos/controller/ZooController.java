package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController {

    @Autowired
    private ZooService zooService;

    // localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos",
            produces = {"application/json"})
    public ResponseEntity<?> listAllZoos() {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    // localhost:2019/zoos/zoos/ADD_ID_NUMBER_HERE
    // available ID numbers to test: 1, 2, 3, 4, 5
    @GetMapping(value = "/zoos/{zooId}",
            produces = {"application/json"})
    public ResponseEntity<?> getZooById(
            @PathVariable
                    Long zooId) {
        Zoo z = zooService.findZooById(zooId);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    // localhost:2019/zoos/ENTER_ZOO_NAME_HERE
    // !!!REMEMBER!!! - URL Encoding Functions
    // sample - localhost:2019/zoos/Smithsonian%20National%20Zoo
    @GetMapping(value = "/{zooName}",
            produces = {"application/json"})
    public ResponseEntity<?> getZooByName(
            @PathVariable
                    String zooName) {
        Zoo z = zooService.findZooByName(zooName);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }
}
