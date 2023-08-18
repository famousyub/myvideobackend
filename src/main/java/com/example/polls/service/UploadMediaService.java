package com.example.polls.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.polls.dao.UploadMediaDao;
import com.example.polls.model.Video;
import com.example.polls.model.VideoStatus;
import com.example.polls.utils.FileStorageUtil;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UploadMediaService {

    @Autowired
    private UploadMediaDao dao;

    @Autowired
    private FileStorageUtil storageUtil;

    public byte[] getFile(String path) throws IOException {
        return storageUtil.getFile(path);
    }

    public Optional<Video> findById(Long id) {
        return dao.findById(id);
    }

    @Transactional
    public Video createFile(MultipartFile file) throws IOException {
    	Video media = new Video();
        media.setOriginalFileName(Paths.get(file.getOriginalFilename()).getFileName().toString());
        media.setOriginalFileExtension(FilenameUtils.getExtension(media.getOriginalFileName()));
      //  media.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
        media.setWrite(false);
        media.setCompressed(false);
      
        String path = storageUtil.createFile(file);
        media.setOriginalFilePath(path);
        media.setDescription("eduction "  + file.getName() );
        media.setTags(Paths.get(file.getOriginalFilename()).getFileName().toString());
        media.setTitle(Paths.get(file.getOriginalFilename()).getFileName().toString() + " " +media.getOriginalFileName() );
        media.setVideoshare(file.getBytes());
        media.setVideoUrl(path);
        media.setVideoStatus(VideoStatus.PUBLIC);
        media.setSearchtext(file.getName());
        
        return dao.upload(media);
    }

    @Transactional
    public void compressed(Video media) {
        dao.convert(media);
    }

    @Transactional
    public void thumbnail(Video media) {
        dao.generateThumbnail(media);
    }

}