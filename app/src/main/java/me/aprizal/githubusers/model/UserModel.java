package me.aprizal.githubusers.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private int avatar;
    private String name;
    private String username;
    private String follower;
    private String following;
    private String company;
    private String location;
    private String repository;

    public UserModel(int avatar, String name, String username, String follower, String following, String company, String location, String repository) {
        this.avatar = avatar;
        this.name = name;
        this.username = username;
        this.follower = follower;
        this.following = following;
        this.company = company;
        this.location = location;
        this.repository = repository;
    }

    public UserModel() {
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    protected UserModel(Parcel in) {
        avatar = in.readInt();
        name = in.readString();
        username = in.readString();
        follower = in.readString();
        following = in.readString();
        company = in.readString();
        location = in.readString();
        repository = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(avatar);
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(follower);
        dest.writeString(following);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(repository);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };
}
