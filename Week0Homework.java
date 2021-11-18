package edu.cornellcollege.week0homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Harper Kates
 * 11/17/21
 * CSC 144-4
 */
public class Week0Homework {
    
    public static List<Integer> makeList(int size, Random rng){
        List<Integer> result=new ArrayList<>();
        for(int i=0; i<size; i++){
            result.add(rng.nextInt(100));
        } //for
        return result;
    } //makeList
    
    public static void printList(List<Integer> data){
        for(int datum:data){
            System.out.println(datum);
        } //for
    } //printList
    
    public static int smallestInteger(List<Integer> data){
        int bestGuessSoFar=data.get(0);
        for(int i=1; i<data.size(); i++){
            if(data.get(i)<bestGuessSoFar){
                bestGuessSoFar=data.get(i);
            } //if
        } //for
        return bestGuessSoFar;
    } //smallestInteger
    
    public static int posOfSmallest(List<Integer> data){
        int bestGuessSoFar=0;
        for(int i=1; i<data.size(); i++){
            if(data.get(i)<data.get(bestGuessSoFar)){
                bestGuessSoFar=i;
            } //if
        } //for
        return bestGuessSoFar;
    } //posOfSmallest
    
    public static int posOfSmallest(List<Integer> data, int start){
        int bestGuessSoFar=start;
        for(int i=start+1; i<data.size(); i++){
            if(data.get(i)<data.get(bestGuessSoFar)){
                bestGuessSoFar=i;
            } //if
        } //for
        return bestGuessSoFar;
    } //posOfSmallest
    
    public static void exchange(List<Integer> data, int i, int j){
        int temp=data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    } //exchange
    
    public static void selectionSort(List<Integer> data){
        for(int i=0; i<data.size(); i++){
            int j=posOfSmallest(data, i);
            exchange(data, i, j);
        } //for
    } //selectionSort
    
    public static void sortOne(int m, List<Integer> data){
        int index=m-1;
        while(data.get(index+1)<data.get(index) && index>=0){
            exchange(data, index, index+1);
            index--;
        } //while
    } //sortOneNew
    
    public static List<Integer> combineSort(List<Integer> m, List<Integer> n){
        List<Integer> merged=new ArrayList(m);
        merged.addAll(n);
        for(int i=0; i<n.size(); i++){
            sortOne(m.size()+i, merged);
        } //for
        return merged;
    } //combineSort
    
    public static void main(String[] args) {
        Random rng=new Random();
        List<Integer> samples=makeList(10, rng);
        selectionSort(samples);
        List<Integer> samples2=makeList(10, rng);
        selectionSort(samples2);
        printList(samples);
        printList(samples2);
        System.out.println();
        printList(combineSort(samples, samples2));
    } //main
    
} //Week0Homework
