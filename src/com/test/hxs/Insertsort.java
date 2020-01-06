package com.test.hxs;

import java.util.Random;

public class Insertsort {
    public static void sort(Comparable[] a) {

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j - 1])) {
                    exch(a, j, j - 1);
                }
            }
        }
//        show(a);
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
