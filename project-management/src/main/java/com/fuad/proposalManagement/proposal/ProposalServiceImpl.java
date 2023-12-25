package com.fuad.proposalManagement.proposal;

import com.fuad.proposalManagement.user.User;
import com.fuad.proposalManagement.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

@Service
public class ProposalServiceImpl implements ProposalService{

    @Autowired
    private ProposalRepository repository;
    @Autowired
    private UserRepository userRepository;

    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";



    @Override
    public Proposal save(Proposal proposal, HttpServletRequest request) {
        String image = fileUpload(proposal.getImage(), proposal.getImage_name());
        proposal.setImage(image);
        System.out.println(image);
        return proposal;
//        proposal.setStatus(false);
//        String userName = request.getUserPrincipal().getName();
//        User user = userRepository.findByUsername(userName).orElse(null);
//        if(user != null){
//            proposal.setUser(user);
//        }
//        createDirectory();
//
//        return repository.save(proposal);
    }

    public static void createDirectory(){
        Path directoryPath = Paths.get(UPLOAD_DIRECTORY);
        if (!directoryPath.toFile().exists()) {
            directoryPath.toFile().mkdirs();
        }
    }

    public static String fileUpload(String image, String name){
        byte[] decodedBytes = Base64.getDecoder().decode(image);
        String file_name = fileName(name);
        try{
            FileOutputStream fos = new FileOutputStream(UPLOAD_DIRECTORY+file_name);
            fos.write(decodedBytes);
            return file_name;
        }catch (IOException e){

            System.out.println(e.getMessage());
            return "error";
        }
    }

    public static String fileName(String name){
        return "/"+UUID.randomUUID().toString()+name.trim()+".pdf";
    }

    @Override
    public byte[] getFile(String fileName) throws IOException {
        String filePath = UPLOAD_DIRECTORY+"/"+fileName;
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}







































