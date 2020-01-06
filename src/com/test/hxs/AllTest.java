package com.test.hxs;

import java.util.Random;
import java.util.Scanner;

public class AllTest {
    public static void main(String[] args) {
        int n ;
        Scanner in = new Scanner(System.in);
        n=in.nextInt();
        Comparable[] a = new Comparable[n];
        Comparable[] b = new Comparable[n];
        Comparable[] c = new Comparable[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
//       有序数组
        for (int i = 0; i < n; i++) {
            b[i] = r.nextInt(100000);
            c[i] = r.nextInt(100000);
        }
//        随机数组
        for (int i = 90; i < 100; i++) {
            b[i] = 100;
        }
        for (int i = 10; i < 20; i++) {
            b[i] = 90;
        }
        for (int i = 300; i < 330; i++) {
            b[i] = 110;
        }
        for (int i = 900; i < 940; i++) {
            b[i] = 120;
        }
//        重复数组

        long startime = System.nanoTime();
        Insertsort.sort(a);
        long endtime = System.nanoTime();
        System.out.println("插入 有序数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        Insertsort.sort(b);
        endtime = System.nanoTime();
        System.out.println("插入 重复数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        Insertsort.sort(c);
        endtime = System.nanoTime();
        System.out.println("插入 随机数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        Mergesort.sort(a);
        endtime = System.nanoTime();
        System.out.println("归并 有序数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        Mergesort.sort(b);
        endtime = System.nanoTime();
        System.out.println("归并 重复数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        Mergesort.sort(c);
        endtime = System.nanoTime();
        System.out.println("归并 随机数组" + (endtime - startime) + " ns");
//
        startime = System.nanoTime();
        MergesortBU.sort(a);
        endtime = System.nanoTime();
        System.out.println("归并BU 有序数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        MergesortBU.sort(b);
        endtime = System.nanoTime();
        System.out.println("归并BU 重复数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        MergesortBU.sort(c);
        endtime = System.nanoTime();
        System.out.println("归并BU 随机数组" + (endtime - startime) + " ns");
//
        startime = System.nanoTime();
        Quicksort3way.sort(a);
        endtime = System.nanoTime();
        System.out.println("3路 有序数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        Quicksort3way.sort(b);
        endtime = System.nanoTime();
        System.out.println("3路 重复数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        Quicksort3way.sort(c);
        endtime = System.nanoTime();
        System.out.println("3路 随机数组" + (endtime - startime) + " ns");
//
        startime = System.nanoTime();
        Rquicksort.sort(a);
        endtime = System.nanoTime();
        System.out.println("随机快排 有序数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        Rquicksort.sort(b);
        endtime = System.nanoTime();
        System.out.println("随机快排 重复数组" + (endtime - startime) + " ns");

        startime = System.nanoTime();
        Rquicksort.sort(c);
        endtime = System.nanoTime();
        System.out.println("随机快排 随机数组" + (endtime - startime) + " ns");
//

    }

}
