package com.labs.app.entity;

public class GithubUser {

    String name;
    String bio;
    String avatar_url;
    String html_url;

    public GithubUser() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", html_url='" + html_url + '\'' +
                '}';
    }
}
