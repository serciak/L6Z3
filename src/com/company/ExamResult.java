package com.company;

public class ExamResult {

    private int idx;
    private double grade;

    public ExamResult(double grade, int idx) {
        this.grade = grade;
        this.idx = idx;
    }

    @Override
    public String toString() {
        return idx + "\t" + grade;
    }

    public int getIdx() {
        return idx;
    }

    public double getGrade() {
        return grade;
    }
}
