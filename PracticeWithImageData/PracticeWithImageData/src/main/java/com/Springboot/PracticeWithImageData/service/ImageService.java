package com.Springboot.PracticeWithImageData.service;

import com.Springboot.PracticeWithImageData.model.Photo;
import com.Springboot.PracticeWithImageData.repository.PictureRepository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ImageService {
    private final PictureRepositoryServiceImplementation pictureRepositoryServiceImplementation;

    public ImageService(PictureRepositoryServiceImplementation pictureRepositoryServiceImplementation) {

        this.pictureRepositoryServiceImplementation = pictureRepositoryServiceImplementation;
    }

    public String addPhoto(Photo photo) {
        photo = pictureRepositoryServiceImplementation.savePhoto(photo);
        return photo.getId();
    }

    public byte[] getPhoto(String id) {
        Photo photo = pictureRepositoryServiceImplementation.getPhotoById(id);
        return photo.getImage().getData();
    }

    public byte[] getAllPictures() {
        ByteArrayOutputStream byteArrayOutputStream = null;
        List<Photo> photos = null;
        try {
             photos = pictureRepositoryServiceImplementation.getAllPhotos();
            byteArrayOutputStream = new ByteArrayOutputStream();
            for (Photo photo : photos) {
                byteArrayOutputStream.write(photo.getImage().getData());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

}
