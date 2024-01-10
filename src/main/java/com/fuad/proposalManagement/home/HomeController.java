package com.fuad.proposalManagement.home;

import com.fuad.proposalManagement.proposal.ProposalService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.Name;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @Autowired
    private ProposalService proposalService;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    @GetMapping("/home")
    public String homePage(){
        return "Hello World";
    }

    @GetMapping("/image/{name}")
    public ResponseEntity<byte[]> getImage(@PathVariable String name) throws IOException {
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .body(proposalService.getFile(name));
    }

}
