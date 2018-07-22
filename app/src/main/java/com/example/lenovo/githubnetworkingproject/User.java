package com.example.lenovo.githubnetworkingproject;

import com.google.gson.annotations.SerializedName;

import retrofit2.http.GET;
import retrofit2.http.Url;

public class User {
    @SerializedName("login")
    String UserName;
    @SerializedName("avatar_url")
    String url;
    int followers;
    int following;
    @SerializedName("followers_url")
    String followersURL;
    @SerializedName("repos_url")
    String reposURL;
    public String getUserName(){
        return UserName;
    }
    public void setUserName(String userName)
    {
        this.UserName=userName;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url)
    {
        this.url=url;
    }
    public void setFollowers(int followers)
    {
        this.followers=followers;
    }
    public int getFollowers()
    {
        return followers;
    }
    public void setFollowing(int following)
    {
        this.following=following;
    }
    public int getFollowing()
    {
        return following;
    }
    public void setFollowersURL(String FollowersUrl)
    {
        this.followersURL=FollowersUrl;
    }

    public String getFollowersURL() {
        return followersURL;
    }

    public void setReposURL(String reposURL) {
        this.reposURL = reposURL;
    }

    public String getReposURL() {
        return reposURL;
    }
}
