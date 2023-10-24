package com.Springboot.PracticeWithImageData.controller;

import com.Springboot.PracticeWithImageData.model.Photo;
import com.Springboot.PracticeWithImageData.service.ImageService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController("image")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value = "/addImage")
    public String addImage(@RequestParam("image") MultipartFile image,
                           @RequestParam("title")String title) {
        String id = String.valueOf(UUID.randomUUID());
        Photo newPhoto = null;
        try {
            newPhoto = new Photo();
            newPhoto.setId(id);
            newPhoto.setTitle(title);
            newPhoto.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return imageService.addPhoto(newPhoto);
    }

    @GetMapping(value = "/getImage")
    public byte[] getPicture(@RequestParam(value = "id") String id) {
        byte[] ans = null;
        try {
            ans = imageService.getPhoto(id);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ans;
    }

    @GetMapping(value = "/images")
    public byte[] getAllImages() {
        byte[] ans = null;
        try {
            ans = imageService.getAllPictures();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return ans;
    }

}
