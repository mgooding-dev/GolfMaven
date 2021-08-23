package com.golfmaven.models;

public class Course {

    private int courseId;
    private String courseName;
    private String locationCity;
    private String locationState;
    private String locationCountry;
    private int parF9;
    private int parB9;
    private int par18;
    private int handicap1;
    private int handicap2;

    public Course() {}

    public Course(int courseId, String courseName, String locationCity,
                  String locationState, String locationCountry, int parF9,
                  int parB9, int par18, int handicap1, int handicap2) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.locationCity = locationCity;
        this.locationState = locationState;
        this.locationCountry = locationCountry;
        this.parF9 = parF9;
        this.parB9 = parB9;
        this.par18 = par18;
        this.handicap1 = handicap1;
        this.handicap2 = handicap2;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public int getParF9() {
        return parF9;
    }

    public void setParF9(int parF9) {
        this.parF9 = parF9;
    }

    public int getParB9() {
        return parB9;
    }

    public void setParB9(int parB9) {
        this.parB9 = parB9;
    }

    public int getPar18() {
        return par18;
    }

    public void setPar18(int par18) {
        this.par18 = par18;
    }

    public int getHandicap1() {
        return handicap1;
    }

    public void setHandicap1(int handicap1) {
        this.handicap1 = handicap1;
    }

    public int getHandicap2() {
        return handicap2;
    }

    public void setHandicap2(int handicap2) {
        this.handicap2 = handicap2;
    }
}
