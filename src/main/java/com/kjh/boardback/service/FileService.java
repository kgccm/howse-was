package com.kjh.boardback.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    
    String uploda(MultipartFile file);
    Resource getImage(String fileName);
    String upload(MultipartFile file);
}
