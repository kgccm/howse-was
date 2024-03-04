package com.kjh.boardback.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    
    String uploda(MultipartFile file);
}
