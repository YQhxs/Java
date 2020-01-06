package com.test.hxs;

import java.util.Random;

public class Quicksort3way {
    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int lt = lo, i = lo, gt = hi;
        Comparable value = a[lo];
        while (i <= gt) {
            if (less(a[i], value)) {
                exch(a, i++, lt++);
            } else if (less(value, a[i])) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int left, int right) {
        Comparable temp;
        temp = a[right];
        a[right] = a[left];
        a[left] = temp;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void sort(Comparable[] a) {
//        Random r  = new Random();
//        exch(a,0,r.nextInt(a.length));
        sort(a, 0, a.length - 1);
//        show(a);
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Random r = new Random();
        Integer[] a = new Integer[100];

        for (int i = 0; i < 100; i++) {
            a[i] = r.nextInt(1000);
        }

        long startime = System.nanoTime();
        sort(a);
        long endtime = System.nanoTime();
        System.out.println((endtime - startime) + " ns");
    }

}


