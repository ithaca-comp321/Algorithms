package com.williamfiset.algorithms.sorting;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.williamfiset.algorithms.sorting.SortingTest.SortingAlgorithm.KOTLIN_INNATE_SORT;


public class SortingTimingTest {
    static void shuffleArray(int[] ar)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
    @Test
    public void builtinSortTimingTest() throws Exception {

        long start, end;
        double javaTotal, kotlinTotal;
        int testRuns = 25;
        int maxBooks = 100000;

        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(12);
        InplaceSort kotlinSort = new KotlinInnateSort();
        //System.out.println("builtinSortTimingTest");
        //System.out.println("n\tJava\tKotlin");

        int[] warmup = IntStream.range(1, maxBooks).toArray();
        for (int i = 0; i < 100; i++){
            shuffleArray(warmup);
            Arrays.sort(warmup);
            shuffleArray(warmup);
            kotlinSort.sort(warmup);

        }


        for (int i = 10000; i <= maxBooks; i += 100) {
            javaTotal = 0;
            kotlinTotal = 0;

            int[] a = IntStream.range(1, i).toArray();


            for (int j = 0; j < testRuns; j++) {
                shuffleArray(a);
                start = System.nanoTime();
                Arrays.sort(a);
                end = System.nanoTime();
                javaTotal += (end - start) / 1000000000.0;

                shuffleArray(a);
                start = System.nanoTime();
                kotlinSort.sort(a);
                end = System.nanoTime();
                kotlinTotal += (end - start) / 1000000000.0;
            }
            System.out.println(i + "\t" + df.format(javaTotal/testRuns) + "\t" + df.format(kotlinTotal/testRuns));
        }
    }

    @Test
    public void insertionSortTimingTest() throws Exception {

        long start, end;
        double javaTotal, kotlinTotal;
        int testRuns = 25;
        int maxSize = 2500;

        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(12);
        InplaceSort javaSort = new InsertionSort();
        InplaceSort kotlinSort = new KotlinInsertionSort();
        //System.out.println("insertionSortTimingTest");
        //System.out.println("n\tJava\tKotlin");

        int[] warmup = IntStream.range(1, maxSize).toArray();
        for (int i = 0; i < 100; i++){
            shuffleArray(warmup);
            javaSort.sort(warmup);
            shuffleArray(warmup);
            kotlinSort.sort(warmup);

        }


        for (int i = 1; i <= maxSize; i += 1) {
            javaTotal = 0;
            kotlinTotal = 0;

            int[] a = IntStream.range(1, i).toArray();


            for (int j = 0; j < testRuns; j++) {
                shuffleArray(a);
                start = System.nanoTime();
                javaSort.sort(a);
                end = System.nanoTime();
                javaTotal += (end - start) / 1000000000.0;

                shuffleArray(a);
                start = System.nanoTime();
                kotlinSort.sort(a);
                end = System.nanoTime();
                kotlinTotal += (end - start) / 1000000000.0;
            }
            System.out.println(i + "\t" + df.format(javaTotal/testRuns) + "\t" + df.format(kotlinTotal/testRuns));
        }
    }

    @Test
    public void mergeSortTimingTest() throws Exception {

        long start, end;
        double javaTotal, kotlinTotal;
        int testRuns = 5;
        int maxSize = 100000;
        int increment = 100;

        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(12);
        InplaceSort javaSort = new MergeSort();
        InplaceSort kotlinSort = new KotlinFunctionalMergeSort();
        //System.out.println("mergeSortTimingTest");
        //System.out.println("n\tJava\tKotlin");

        int[] warmup = IntStream.range(1, maxSize).toArray();
        for (int i = increment; i < increment * 10; i+=increment){
            shuffleArray(warmup);
            javaSort.sort(warmup);
            shuffleArray(warmup);
            kotlinSort.sort(warmup);

        }


        for (int i = increment; i <= maxSize; i += increment) {
            javaTotal = 0;
            kotlinTotal = 0;

            int[] a = IntStream.range(1, i).toArray();


            for (int j = 0; j < testRuns; j++) {
                shuffleArray(a);
                start = System.nanoTime();
                javaSort.sort(a);
                end = System.nanoTime();
                javaTotal += (end - start) / 1000000000.0;

                shuffleArray(a);
                start = System.nanoTime();
                kotlinSort.sort(a);
                end = System.nanoTime();
                kotlinTotal += (end - start) / 1000000000.0;
            }
            System.out.println(i + "\t" + df.format(javaTotal/testRuns) + "\t" + df.format(kotlinTotal/testRuns));
        }
    }

    @Test
    public void quickSortTimingTest() throws Exception {

        long start, end;
        double javaTotal, kotlinTotal;
        int testRuns = 5;
        int maxSize = 100000;
        int increment = 100;

        DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setMaximumFractionDigits(12);
        InplaceSort javaSort = new QuickSort();
        InplaceSort kotlinSort = new FunctionalQuickSort();
        //System.out.println("mergeSortTimingTest");
        //System.out.println("n\tJava\tKotlin");

        int[] warmup = IntStream.range(1, maxSize).toArray();
        for (int i = increment; i < increment * 10; i+=increment){
            shuffleArray(warmup);
            javaSort.sort(warmup);
            shuffleArray(warmup);
            kotlinSort.sort(warmup);

        }


        for (int i = increment; i <= maxSize; i += increment) {
            javaTotal = 0;
            kotlinTotal = 0;

            int[] a = IntStream.range(1, i).toArray();


            for (int j = 0; j < testRuns; j++) {
                shuffleArray(a);
                start = System.nanoTime();
                javaSort.sort(a);
                end = System.nanoTime();
                javaTotal += (end - start) / 1000000000.0;

                shuffleArray(a);
                start = System.nanoTime();
                kotlinSort.sort(a);
                end = System.nanoTime();
                kotlinTotal += (end - start) / 1000000000.0;
            }
            System.out.println(i + "\t" + df.format(javaTotal/testRuns) + "\t" + df.format(kotlinTotal/testRuns));
        }
    }
}
