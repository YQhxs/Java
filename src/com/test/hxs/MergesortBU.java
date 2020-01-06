package com.test.hxs;

import java.util.Random;

import static java.lang.Math.min;

public class MergesortBU {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
//        每次进入归并，需把上次归并结果放入临时数组aux，而且每次只操作lo，hi（最后一次才是整个数组）个
//            当然也可以不用这一步，直接把调换角色，把排好序的结果输出到aux数组里
        }
        int i = lo, j = mid + 1;
//        分别从左右两部分数组的首地址开始
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        for (int sz = 1; sz < a.length; sz += sz) {
            for (int lo = 0; lo < a.length - sz;lo += 2*sz ) {
                merge(a,aux,lo,lo+sz-1,min(lo+2*sz -1,a.length-1));
            }
        }

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
