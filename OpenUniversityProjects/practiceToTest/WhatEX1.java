package practiceToTest;

public class WhatEX1 {

    public static int what(int a[], int num) {
        int size = 0;
        boolean found = true;
        for (int i = 1; i <= a.length && found; i++) {
            if (f(a, num * i))
                size++;
            else
                found = false;
        }
        return size;
    }

    public static boolean f(int a[], int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x)
                return true;
        }
        return false;
    }

    public static int betterWhat(int a[], int num) {
        int current = num;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == current) {
                count++;
                current += num;
            }
        }
        return count;
    }

    // public static boolean betterF(int a[], int x) {
    // for (int i = 0; i < a.length; i++) {
    // if (a[i] == x)
    // return true;
    // }
    // return false;
    // }
}