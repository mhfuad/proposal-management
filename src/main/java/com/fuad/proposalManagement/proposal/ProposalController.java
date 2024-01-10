package com.fuad.proposalManagement.proposal;

import com.fuad.proposalManagement.user.User;
import com.fuad.proposalManagement.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/proposal")
public class ProposalController {

    @Autowired
    private ProposalService service;

    @Autowired
    private ProposalRepository repository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Proposal save(@RequestBody Proposal proposal, HttpServletRequest request){
        return service.save(proposal, request);
    }

    @GetMapping
    public List<Proposal> all(){
        return repository.findAll();
    }

    @GetMapping("/file/{file}")
    public ResponseEntity<?> getFile(@PathVariable String file) throws IOException {
        byte[] imageData = service.getFile(file);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .body(imageData);
    }

}
