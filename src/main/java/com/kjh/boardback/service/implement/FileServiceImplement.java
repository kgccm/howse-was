package com.kjh.boardback.service.implement;

import org.springframework.stereotype.Service;
import com.kjh.boardback.service.FileService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;

@Service
public class FileServiceImplement implements FileService {

    @Value("${file.path}")
    private String filePath;
    @Value("${file.url}")
    private String fileUrl;

    @Override
    public String upload(MultipartFile file) {

        if (file.isEmpty())
            return null;

        String originalFileName = file.getOriginalFilename();
        @SuppressWarnings("null")
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        String saveFileName = uuid + extension;
        String savePath = filePath + saveFileName;

        File directory = new File(filePath);
        if (!directory.exists()) {
            directory.mkdirs(); // 경로가 없으면 디렉토리 생성
        }

        try {
            file.transferTo(new File(savePath));
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        String url = fileUrl + saveFileName;
        return url;
    }

    @Override
    public Resource getImage(String fileName) {

        Resource resource = null;

        try {
            File file = new File(filePath + fileName);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + filePath + fileName);
            }

            resource = new UrlResource("file:" + filePath + fileName);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        return resource;
    }

}