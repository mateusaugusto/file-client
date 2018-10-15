package com.exb.client.fileserviceclient.service.impl;

import DTO.FileDTO;
import com.exb.client.fileserviceclient.infrastructure.SupportService;
import com.exb.client.fileserviceclient.service.FileService;
import com.exb.client.fileserviceclient.util.FileServerEndPoints;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Service
public class FileServiceImpl extends SupportService implements FileService {

    private static Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public Logger getLogger() {
        return this.logger;
    }

    @Override
    public String getBaseUrl() {
        return FileServerEndPoints.FILE_HOST.getUrl();
    }


    @Override
    public String getToken() throws IOException {
        return this.getOauth2TokenInfo().getAccessToken();
    }


    public Boolean exist(String aSessionId, String path) {
        assert StringUtils.isNotBlank(aSessionId) || StringUtils.isNotBlank(path);

        HttpEntity<Object> request = this.getRequest();
        ResponseEntity<Boolean> response;
        Boolean result;

        URI uri = UriComponentsBuilder
                .fromUriString(FileServerEndPoints.FILE_EXIST.getUrl() + "/" + aSessionId)
                .queryParam("path", path)
                .build()
                .toUri();

        response = getRestTemplate().exchange(uri, HttpMethod.GET, request, Boolean.class);

        if (response.getStatusCode().equals(OK)) {
            getLogger().info(String.format("Getting status to file exist : %s", response.getStatusCode().toString()));
            result = response.getBody();
        } else {
            throw new RuntimeException("error");
        }
        return result;
    }

    @Override
    public String getParent(String aSessionId, String path) {
        assert StringUtils.isNotBlank(aSessionId) || StringUtils.isNotBlank(path);

        HttpEntity<Object> request = this.getRequest();
        ResponseEntity<String> response;
        String result;

        URI uri = UriComponentsBuilder
                .fromUriString(FileServerEndPoints.FILE_PARENT.getUrl() + "/" + aSessionId)
                .queryParam("path", path)
                .build()
                .toUri();

        response = getRestTemplate().exchange(uri, HttpMethod.GET, request, String.class);

        if (response.getStatusCode().equals(OK)) {
            getLogger().info(String.format("Getting parent for file : %s", response.getStatusCode().toString()));
            result = response.getBody();
        } else {
            throw new RuntimeException("error");
        }
        return result;
    }

    @Override
    public String upload(String aSessionId, MultipartFile file) {
        assert StringUtils.isNotBlank(aSessionId) || file == null;

        HttpEntity<Object> request = this.getRequest();
        ResponseEntity<String> response;
        String result;

        URI uri = UriComponentsBuilder
                .fromUriString(FileServerEndPoints.FILE_UPLOAD.getUrl() + "/" + aSessionId)
                .queryParam("file", file)
                .build()
                .toUri();

        response = getRestTemplate().exchange(uri, HttpMethod.POST, request, String.class);

        if (response.getStatusCode().equals(OK)) {
            getLogger().info(String.format("upload  file  : %s", response.getStatusCode().toString()));
            result = response.getBody();
        } else {
            throw new RuntimeException("error");
        }
        return result;
    }


    @Override
    public List<FileDTO> listFile(String aSessionId) {
        assert StringUtils.isNotBlank(aSessionId);

        HttpEntity<Object> request = this.getRequest();
        ResponseEntity<List<FileDTO>> response;
        List<FileDTO>  result;

        ParameterizedTypeReference<List<FileDTO>> ptr = new ParameterizedTypeReference<List<FileDTO>>() { };

        response = getRestTemplate().exchange(FileServerEndPoints.FILE_LIST_DTO.getUrl() + "/" + aSessionId, HttpMethod.GET, request, ptr);

        if (response.getStatusCode().equals(OK)) {
            getLogger().info(String.format("Listing Files : %s", response.getStatusCode().toString()));
            result = response.getBody();
        } else {
            throw new RuntimeException("error");
        }
        return result;
    }


    @Override
    public List<String> list(String aSessionId) {
        assert StringUtils.isNotBlank(aSessionId);

        HttpEntity<Object> request = this.getRequest();
        ResponseEntity<List<String>> response;
        List<String>  result;

        ParameterizedTypeReference<List<String>> ptr = new ParameterizedTypeReference<List<String>>() { };

        response = getRestTemplate().exchange(FileServerEndPoints.FILE_LIST.getUrl() + "/" + aSessionId, HttpMethod.GET, request, ptr);

        if (response.getStatusCode().equals(OK)) {
            getLogger().info(String.format("Listing path files: %s", response.getStatusCode().toString()));
            result = response.getBody();
        } else {
            throw new RuntimeException("error");
        }
        return result;
    }


    @Override
    public byte[] openForReading(String aSessionId, String path) {
        assert StringUtils.isNotBlank(aSessionId) || StringUtils.isNotBlank(path) ;

        HttpEntity<Object> request = this.getRequest();
        ResponseEntity<byte[]> response;
        byte[] result;

        URI uri = UriComponentsBuilder
                .fromUriString(FileServerEndPoints.FILE_OPEN_READING.getUrl() + "/" + aSessionId)
                .queryParam("path", path)
                .build()
                .toUri();

        response = getRestTemplate().exchange(uri, HttpMethod.GET, request, byte[].class);

        if (response.getStatusCode().equals(OK)) {
            getLogger().info(String.format("upload  file  : %s", response.getStatusCode().toString()));
            result = response.getBody();
        } else {
            throw new RuntimeException("error");
        }

        return result;
    }

}
