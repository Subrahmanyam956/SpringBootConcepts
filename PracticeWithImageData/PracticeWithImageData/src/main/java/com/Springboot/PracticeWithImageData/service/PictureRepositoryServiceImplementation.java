package com.Springboot.PracticeWithImageData.service;

import com.Springboot.PracticeWithImageData.model.Photo;
import com.Springboot.PracticeWithImageData.repository.PictureRepository;

import java.util.List;

public class PictureRepositoryServiceImplementation {
    private final PictureRepository pictureRepository;

    public PictureRepositoryServiceImplementation(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public Photo getPhotoById(String id) {
        return pictureRepository.findById(id).get();
    }

    public Photo savePhoto(Photo photo) {
        return pictureRepository.save(photo);
    }

    public List<Photo> getAllPhotos() {
        return pictureRepository.findAll();
    }

}
