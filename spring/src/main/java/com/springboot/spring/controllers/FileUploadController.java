package com.springboot.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.springboot.spring.helper.FileUpload;

@RestController
public class FileUploadController {

    @Autowired
    private FileUpload fileUpload;

    @PostMapping("upload/file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {

        try {
            if (file.isEmpty()) {
                return new ResponseEntity<>("Please provide a file", HttpStatus.BAD_REQUEST);
            }
            if (!file.getContentType().equals("image/jpeg")) {
                return new ResponseEntity<>("Please provide a correct file type the image should be of jpeg format",
                        HttpStatus.BAD_REQUEST);
            }
            // uploading image
            boolean ok = fileUpload.uploadfile(file);
            if (ok) {                       
                return new ResponseEntity<>(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image").path(file.getOriginalFilename()).toUriString(), HttpStatus.OK);
            }
            // ServletUriComponentsBuilder.fromCurrentContextPath()  this give the localhost:8080 in which our server is running further after that /image also added and after that filename
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot upload file" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
