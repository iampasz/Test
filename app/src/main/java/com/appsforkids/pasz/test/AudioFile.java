package com.appsforkids.pasz.test;


public class AudioFile {

    private long id;
    private String file_name;
    private String name;
    private String author;
    private String description;
    private String internet_link;
    private Boolean status = false;
    private String image;
    private String type;

    public void setId(long id) {
        this.id = id;
    }

    public void setFileName(String file_name) {
        this.file_name = file_name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInternetLink(String internet_link) {
        this.internet_link = internet_link;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getInternet_link() {
        return internet_link;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getImage() {
        return image;
    }

    public String getType() {
        return type;
    }
}
