package com.example.java_development.module4;

public class PointEntity {
    private int id;
    private String name;
    private String stub;
    private int point;

    public PointEntity(String name, String stub, int point) {
        this.name = name;
        this.stub = stub;
        this.point = point;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStub() {
        return stub;
    }

    public void setStub(String stub) {
        this.stub = stub;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", stub='" + stub + '\'' +
                ", point=" + point;
    }
}
