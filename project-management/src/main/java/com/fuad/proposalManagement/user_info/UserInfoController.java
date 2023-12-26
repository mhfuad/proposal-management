package com.fuad.proposalManagement.user_info;

import com.fuad.proposalManagement.user.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user_info")
public class UserInfoController {
    private UserInfoService service;
    private UserRepository userRepository;
    @Autowired
    private UserInfoRepository repository;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";

    //public ResponseObject<UserResponse> registerUser(@Valid @RequestBody UserRegistrationRequest request, BindingResult result){
    @PostMapping("/create")
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserInfoRequest request) throws IOException {
        if(request.getImage().equals("")|| request.getImage().isEmpty() || request.getImage() == null){
            User user = userRepository.findById(request.getUser_id()).orElse(null);
            if(user == null){
                return ResponseEntity.badRequest().body("No user found");
            }
            UserInfo info = new UserInfo();
            info.setFatherName(request.getFatherName());
            info.setMotherName(request.getMotherName());
            info.setAddress(request.getAddress());
            user.setUserInfo(info);
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }
        Path directoryPath = Paths.get(UPLOAD_DIRECTORY);
        if (!directoryPath.toFile().exists()) {
            directoryPath.toFile().mkdirs();
        }
        try{
            byte[] imageBytes = Base64.getMimeDecoder().decode(request.getImage().split(",")[1]);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));
            File output = new File(UPLOAD_DIRECTORY+"/profile.jpg");
            ImageIO.write(image, "jpg", output);

            return ResponseEntity.ok(UPLOAD_DIRECTORY+"/profile.jpg");
        }catch (Exception e){
            System.out.println("error = "+e);
            return ResponseEntity.ok("error = "+e);
        }
    }

    private String generateUniqueFileName(String originalFileName) {
        return UUID.randomUUID().toString() + "_" + originalFileName;
    }

}
