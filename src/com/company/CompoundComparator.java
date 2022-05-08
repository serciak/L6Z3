package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class CompoundComparator<T> implements Comparator<T> {

    private final ArrayList<Object> comparators = new ArrayList<>();

    public void addComparator(Comparator<T> comp) {
        comparators.add(comp);
    }

    @Override
    public int compare(T o1, T o2) {
        int result = 0;

        for(Object o : comparators) {
            Comparator<T> comp = (Comparator<T>) o;
            result = comp.compare(o1, o2);
            if(result != 0)
                break;
        }
        return result;
    }
}
