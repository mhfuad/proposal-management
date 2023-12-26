package com.fuad.proposalManagement.proposal;

import com.fuad.proposalManagement.user.User;
import com.fuad.proposalManagement.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

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
        String userName = request.getUserPrincipal().getName();
        User user = userRepository.findByUsername(userName).orElse(null);
        if(user != null){
            proposal.setUser(user);
        }
        return repository.save(proposal);
    }

    @GetMapping
    public List<Proposal> all(){
        return repository.findAll();
    }

}
