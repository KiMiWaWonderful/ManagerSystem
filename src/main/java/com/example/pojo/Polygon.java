package com.example.pojo;

import java.util.List;

public class Polygon {

    //Point[] points;
    List<Point> points;

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public Polygon(List<Point> points) {
        this.points = points;
    }

    public Polygon() {
    }

//    public Point[] getPoints() {
//        return points;
//    }
//
//    public void setPoints(Point[] points) {
//        this.points = points;
//    }
//
//    public Polygon(Point[] points) {
//        this.points = points;
//    }
//
//    public Polygon() {
//    }
//
//    @Override
//    public String toString() {
//        return "Polygon{" +
//                "points=" + Arrays.toString(points) +
//                '}';
//    }
}
