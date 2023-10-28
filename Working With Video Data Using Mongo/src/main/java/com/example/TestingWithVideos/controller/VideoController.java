package com.example.TestingWithVideos.controller;

import com.example.TestingWithVideos.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class VideoController {
    Logger logger = LoggerFactory.getLogger(VideoController.class);
    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @PostMapping(value = "/video/saveVideo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public String saveVideo(@RequestParam("file")MultipartFile file) throws IOException {
        logger.info("Caught the request");
        String videoTitle = UUID.randomUUID().toString();
        String title = videoService.addVideo(videoTitle, file);
        System.gc();
        logger.info("finished Saving");
        return title;
    }

    @GetMapping("/video/getVideo")
    @ResponseStatus(HttpStatus.OK)
    public byte[] getVideo(@RequestParam("id") String id) throws IOException {
        logger.info("Caught the request");
        return videoService.getVideo(id).getStream().toString().getBytes();
    }
}
