package com.exb.client.fileserviceclient.util;

public enum FileServerEndPoints {


    FILE_HOST("http://localhost:8080/"),

    FILE_ENDPOINT(FileServerEndPoints.FILE_HOST.getUrl() + "file/"),

    FILE_EXIST(FILE_ENDPOINT.getUrl() + "exist"),

    FILE_PARENT(FILE_ENDPOINT.getUrl() + "parent"),

    FILE_LIST_DTO( FILE_ENDPOINT.getUrl() + "all"),

    FILE_LIST(FILE_ENDPOINT.getUrl() + "list"),

    FILE_OPEN_READING(FILE_ENDPOINT.getUrl() + "open/reading/"),

    FILE_UPLOAD( FILE_ENDPOINT.getUrl() + "upload");

    private String url;

    FileServerEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
