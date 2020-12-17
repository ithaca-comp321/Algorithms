package com.williamfiset.algorithms.sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;


public class FunctionalMergeSort implements InplaceSort {

    @Override
    public void sort(int[] values) {
        Spliterator<Integer> sortedValues = mergesort(Arrays.stream(values).spliterator());
        final int[] i = {0};
        sortedValues.forEachRemaining(x -> values[i[0]++] = x);
    }

    public static Spliterator<Integer> mergesort(Spliterator<Integer> spl) {

        if (spl.hasCharacteristics(Spliterator.SORTED)) return spl;

        if (spl.estimateSize() <= 1) return spl;

        Spliterator<Integer> spliterator1 = spl.trySplit(); //left half of spl

        // Split array into two parts and recursively sort them
        Spliterator<Integer> left = mergesort(spliterator1);
        Spliterator<Integer> right = mergesort(spl);

        // Combine the two arrays into one larger array
        return merge(left, right);
    }

    // Merge two sorted arrays into a larger sorted array
    public static Spliterator<Integer> merge(Spliterator<Integer> left, Spliterator<Integer> right) {
        LinkedList<Integer> intList = new LinkedList<>();
        int next;
        final Integer[] nextLeft = new Integer[1];
        final Integer[] nextRight = new Integer[1];

        boolean nextLeftNotNull = left.tryAdvance(x -> nextLeft[0] = x);
        boolean nextRightNotNull = right.tryAdvance(x -> nextRight[0] = x);

        while (nextLeftNotNull && nextRightNotNull){
            if (nextLeft[0] < nextRight[0]) {
                next = nextLeft[0];
                nextLeftNotNull = left.tryAdvance(x -> nextLeft[0] = x);
            } else {
                next = nextRight[0];
                nextRightNotNull = right.tryAdvance(x -> nextRight[0] = x);
            }
            intList.add(next);
        }

        if (nextLeftNotNull) {
            intList.add(nextLeft[0]);
            left.forEachRemaining(intList::add);
        } else {
            intList.add(nextRight[0]);
            right.forEachRemaining(intList::add);
        }
        return intList.spliterator();
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(6,4,7,1,2,67,5);
        Spliterator<Integer> spliterator1 = list.spliterator();

        Spliterator<Integer> sorted = mergesort(spliterator1);
        sorted.forEachRemaining(System.out::println);
    }
}