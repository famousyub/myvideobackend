package com.example.polls.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageUtil {

    public String getHomeDirectory() {
        return System.getProperty("user.home");
    }

    public String createFile(MultipartFile file) throws IOException {
        String dirPath = new StringBuilder(getHomeDirectory()).append(File.separator)
                .append("Videos").append(File.separator)
                .append("original").append(File.separator)
                .append(LocalDate.now()).toString();

        String fileName = String.format(
                "%s.%s",
                UUID.randomUUID().toString(),
                FilenameUtils.getExtension(file.getOriginalFilename())
        );

        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String location = new StringBuilder(dirPath).append(File.separator).append(fileName).toString();
        Path path = Paths.get(location);
        Files.write(path, file.getBytes());
        return location;
    }

    public byte[] getFile(String path) throws IOException {
        File file = new File(path);
        byte[] b = null;
        if (file.exists()) {
            b = FileUtils.readFileToByteArray(file);
        }
        return b;
    }

}