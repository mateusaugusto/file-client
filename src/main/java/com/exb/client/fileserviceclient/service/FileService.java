package com.exb.client.fileserviceclient.service;


import DTO.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {
    String getBaseUrl();

    String getToken() throws IOException;

    Boolean exist(String aSessionId, String path);

    String getParent(String aSessionId, String path);

    String upload(String aSessionId, MultipartFile file);

    List<FileDTO> listFile(String aSessionId);

    List<String> list(String aSessionId);

    byte[] openForReading(String aSessionId, String path);
}
