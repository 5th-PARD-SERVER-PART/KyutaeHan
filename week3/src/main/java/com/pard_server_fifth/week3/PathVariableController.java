package com.pard_server_fifth.week3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {
    @RequestMapping("/path/{name}")
    public String path(@PathVariable("name") String myName){
        return "1st pathVariable controller name : " + myName;
    }

    @RequestMapping("/pathV2/{name}")
    public String path2(@PathVariable String name){
        return "2nd pathVariable controller name : " + name;
    }

    @RequestMapping("/pathV3/{name}/{age}")
    public String path3(@PathVariable String name, @PathVariable int age){
        return "3rd user name : "+name + " age : "+ age;
    }
}
