package bai1;

import java.util.*;
import java.io.*;


class OddThread extends Thread{
    int n;
    public OddThread(int var) {
        n = var;
    }
    public void run() {
        for (int i = 1; i <= n; i++) {
            if(i%2!=0) {
                System.out.println("Odd number: " + i);
            }try {
                OddThread.sleep(10);
            } catch (Exception e) {
            }
        }
    }
}

class EvenThread extends Thread{
    int n;
    public EvenThread(int var) {
        n = var;
    }
    public void run() {
        for (int i = 1; i <= n; i++) {
            if(i%2==0) {
                System.out.println("Even number: " + i);
            } try {
                EvenThread.sleep(10);
            } catch (Exception e) {
            }
        }
    }
}

public class GFG {

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        OddThread odd = new OddThread(n);
        EvenThread even = new EvenThread(n);

        odd.start();
        even.start();
    }
}