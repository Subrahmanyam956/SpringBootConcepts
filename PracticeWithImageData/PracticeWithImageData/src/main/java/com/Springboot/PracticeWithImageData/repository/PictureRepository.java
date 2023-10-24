package com.Springboot.PracticeWithImageData.repository;

import com.Springboot.PracticeWithImageData.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends MongoRepository<Photo, String> {
}
