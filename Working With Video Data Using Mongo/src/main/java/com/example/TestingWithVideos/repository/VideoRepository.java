package com.example.TestingWithVideos.repository;

import com.example.TestingWithVideos.model.VideoSave;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<VideoSave, String> {
}
