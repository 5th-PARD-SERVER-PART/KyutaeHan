package com.pard_server_fifth.week3_hw1;

import org.springframework.web.bind.annotation.*;

//RestMethod
@RestController
public class hw1_3 {
    @GetMapping("/getUsers")
    public String getUsers() {
        return """
               This is GET Method
               Your Members are:
               22100767 한규태
               22200360 서경미
               """;
    }

    @PostMapping("/post")
    public String postUser(){
        return "add user";
    }

    @PutMapping("/put")
    public String putUser(){
        return "Edit the whole information of the user";
    }

    //@RequestMapping(value = "/head", method = RequestMethod.HEAD)
    @GetMapping("/head")
    public String headUser() {
        return "This is similar to the GET method, but it returns only the header information without the body.";
    }

    @GetMapping("/options")
    public String optionsUser(){
        return """
                Your available methods are:
                Get : (url/getUsers)
                Get : (url/get/{userId})
                Head : (url/head)
                Post : (url/post)
                Put : (url/put)
                Patch : (url/patch/{userId})
                Delete : (url/delete/{userId})
                Options : (url/options)
                """;
    }


    @GetMapping("/get/{userId}")
    public String getUser(@PathVariable Integer userId){
        if(userId.equals(22100767)){
            return "userId : "+ userId + " 한규태 학생입니다.";
        }
        else if(userId.equals(22200360)){
            return "userId : "+userId+ " 서경미 학생입니다.";
        }
        else{
            return "No such user, try 22100767 or 22200360";
        }

    }

    @PatchMapping("/patch/{userId}")
    public String patchUser(@PathVariable Integer userId){
        if(userId.equals(22100767)||userId.equals(22200360) ) {
            return "patch user Id : " + userId;
        }
        else {
            return "No such user, try 22100767 or 22200360";
        }
    }

    @DeleteMapping("/delete/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return "Delete UserId : " + userId;
    }


}
