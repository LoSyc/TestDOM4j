package org.maker.testdom4j.bean;

/**
 * Created by DELL on 2014/4/11.
 */
public class Student {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getExamid() {
        return examid;
    }

    public void setExamid(String examid) {
        this.examid = examid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", idcard='" + idcard + '\'' +
                ", examid='" + examid + '\'' +
                ", location='" + location + '\'' +
                ", grade=" + grade +
                '}';
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    private String name;
    private String idcard;
    private String examid;
    private String location;
    private double grade;

}
