package com.fuad.proposalManagement.home;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/home")
    public String homePage(){
        return "Hello World";
    }

    @GetMapping("/image/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable String name) throws IOException {
        //byte[] image = UPLOAD_DIRECTORY+"/"+name;
        //return IOUtils.toByteArray(in);
        return null;
    }

}
