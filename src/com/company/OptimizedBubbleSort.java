package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class OptimizedBubbleSort {

    Comparator<ExamResult> comparator;
    private int swaps;
    private int comparisons;

    public OptimizedBubbleSort(Comparator<ExamResult> comparator) {
        this.comparator = comparator;
    }

    public ArrayList<ExamResult> sort(ArrayList<ExamResult> list) {
        ExamResult temp;
        int lastSwap = list.size()-1;
        swaps = 0;
        comparisons = 0;

        while(lastSwap > 0) {
            int end=lastSwap;
            lastSwap=0;
            for (int left = 0; left < end; ++left) {
                comparisons++;
                if (comparator.compare(list.get(left), list.get(left+1)) > 0) {
                    temp = list.get(left);
                    while(left < end && comparator.compare(temp, list.get(left+1)) > 0) {
                        comparisons++;
                        list.set(left, list.get(left+1));
                        left++;
                    }
                    lastSwap = left;
                    list.set(left, temp);
                    swaps++;
                }
            }
        }
        return list;
    }

    public int getSwaps() {
        return swaps;
    }

    public int getComparisons() {
        return comparisons;
    }
}
