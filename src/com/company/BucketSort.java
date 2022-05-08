package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class BucketSort {

    private Comparator<ExamResult> comparator;
    private int swaps;
    private int swapsOBS;
    private int comparisons;
    private int comparisonsOBS;

    public BucketSort(Comparator<ExamResult> comparator) {
        this.comparator = comparator;
    }

    private int chooseBucket(double value, int bucketsAmount) {
        return (int) (value / (5.5 * (bucketsAmount - 1)));
    }

    public ArrayList<ExamResult> sort(ArrayList<ExamResult> list) {
        swaps = 0;
        comparisons = 0;
        swapsOBS = 0;
        comparisonsOBS = 0;
        int bucketsAmount = (int) Math.sqrt(list.size());
        ArrayList<ArrayList<ExamResult>> buckets = new ArrayList<>();
        ArrayList<ExamResult> res = new ArrayList<>();
        OptimizedBubbleSort obs = new OptimizedBubbleSort(comparator);

        for(int i = 0; i < bucketsAmount; i++)
            buckets.add(new ArrayList<>());

        for(ExamResult er : list)
            buckets.get(chooseBucket(er.getGrade(), bucketsAmount)).add(er);

        for(ArrayList<ExamResult> bucket : buckets) {
            obs.sort(bucket);
            swapsOBS += obs.getSwaps();
            comparisonsOBS += obs.getComparisons();
        }

        for(ArrayList<ExamResult> bucket : buckets) {
            swaps += bucket.size();
            res.addAll(bucket);
        }

        return res;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwapsOBS() {
        return swapsOBS;
    }

    public int getComparisonsOBS() {
        return comparisonsOBS;
    }
}
