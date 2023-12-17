package com.sheshagroups.satech.demoapp;

public class CWFileModel {
    public String uploadET;
    public String uploadURL;

    public CWFileModel(String uploadET, String uploadURL) {
        this.uploadET = uploadET;
        this.uploadURL = uploadURL;
    }

    public String getUploadET() {
        return uploadET;
    }

    public void setUploadET(String uploadET) {
        this.uploadET = uploadET;
    }

    public String getUploadURL() {
        return uploadURL;
    }

    public void setUploadURL(String uploadURL) {
        this.uploadURL = uploadURL;
    }
}
