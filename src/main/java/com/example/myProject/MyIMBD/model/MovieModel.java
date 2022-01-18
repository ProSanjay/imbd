package com.example.myProject.MyIMBD.model;

import java.util.List;
public class MovieModel {
    private String mName;
    private Integer mRatting;
    private String mGenre;
    private  String mYearOfRelease;
    private  String mPrimaryLanguage;
    private List<String> mListOfActors;
    private String mId;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public List<String> getmListOfActors() {
        return mListOfActors;
    }

    public void setmListOfActors(List<String> mListOfActors) {
        this.mListOfActors = mListOfActors;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Integer getmRatting() {
        return mRatting;
    }

    public void setmRatting(Integer mRatting) {
        this.mRatting = mRatting;
    }

    public String getmGenre() {
        return mGenre;
    }

    public void setmGenre(String mGenre) {
        this.mGenre = mGenre;
    }

    public String getmYearOfRelease() {
        return mYearOfRelease;
    }

    public void setmYearOfRelease(String mYearOfRelease) {
        this.mYearOfRelease = mYearOfRelease;
    }

    public String getmPrimaryLanguage() {
        return mPrimaryLanguage;
    }

    public void setmPrimaryLanguage(String mPrimaryLanguage) {
        this.mPrimaryLanguage = mPrimaryLanguage;
    }

}
