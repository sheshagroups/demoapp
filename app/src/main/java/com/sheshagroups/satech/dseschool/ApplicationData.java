package com.sheshagroups.satech.dseschool;

public class ApplicationData {
    public String applicationURL, studentcaption;

    public ApplicationData(){

    }

    public String getApplicationURL() {
        return applicationURL;
    }

    public void setApplicationURL(String applicationURL) {
        this.applicationURL = applicationURL;
    }

    public String getStudentcaption() {
        return studentcaption;
    }

    public void setStudentcaption(String studentcaption) {
        this.studentcaption = studentcaption;
    }

    public ApplicationData(String applicationURL, String studentcaption) {
        this.applicationURL = applicationURL;
        this.studentcaption = studentcaption;
    }
}
