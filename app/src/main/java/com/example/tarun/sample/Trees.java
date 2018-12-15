package com.example.tarun.sample;

import java.util.ArrayList;

public class Trees {
    private static ArrayList<Integer> trees = new ArrayList<>();
    private static double mean;
    private static int[] ages = new int[500];


    public static void addTree(int age){
        trees.add(age);
        updateMean(age);
        ages[age]++;
    }


    private static void updateMean(int newAge){
        mean = (mean*(trees.size()-1) + newAge)/trees.size();
    }

    public static double getMeanAge(){
        return mean;
    }


    public static int getMedianAge(){
        if(trees.size() == 0)
            return 0;
        long sum = 0;
        int i = 0;
        while(i < 500){
            sum += ages[i];
            if(sum > trees.size()/2)
                break;
            i++;
        }
        return i;
    }

    public static ArrayList<Integer> getTrees() {
        return trees;
    }
    public static int getTreeCount(){
        return trees.size();
    }
}
