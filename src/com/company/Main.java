package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {

    public static ArrayList<ExamResult> createList(int size) {
        double[] grades = {2, 3, 3.5, 4, 4.5, 5, 5.5};
        ArrayList<ExamResult> examResults = new ArrayList<>();
        Random random = new Random();

        for(int i = 1; i < size+1; i++)
            examResults.add(new ExamResult(grades[random.nextInt(0, 7)], i));

        return examResults;
    }

    public static void main(String[] args) {
        ArrayList<ExamResult> examResults = createList(100);
        Comparator<ExamResult> gradeComp = Comparator.comparingDouble(ExamResult::getGrade);
        Comparator<ExamResult> idxComp = Comparator.comparingInt(ExamResult::getIdx);
        CompoundComparator<ExamResult> resultComp = new CompoundComparator<>();

        resultComp.addComparator(gradeComp);
        resultComp.addComparator(idxComp);

        BucketSort bs = new BucketSort(resultComp);
        OptimizedBubbleSort obs = new OptimizedBubbleSort(resultComp);
        bs.sort(examResults);
        obs.sort(examResults);
        System.out.println("BUCKET SORT");
        System.out.println("Porownania: " + bs.getComparisons() + "\tPrzepisania: " + bs.getSwaps());
        System.out.println("Porownania + porownania wewnetrzenego sortowania: "
                + (bs.getComparisons() + bs.getComparisonsOBS())
                + "\tPrzepisania + zamiany wewnetrznego sortowania: " + (bs.getSwaps() + bs.getSwapsOBS()));
        System.out.println("\nBUBBLE SORT");
        System.out.println("Porownania: " + obs.getComparisons() + "\tZamiany: " + obs.getSwaps());
    }
}
