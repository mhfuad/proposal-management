package com.fuad.proposalManagement.proposal;

import com.fuad.proposalManagement.user.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;

public interface ProposalService {

    Proposal save(Proposal proposal, HttpServletRequest request);

    byte[] getFile(String file) throws IOException;
}
