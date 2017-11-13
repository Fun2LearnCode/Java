import java.util.Arrays;

public class Sorts{
    public static void main(String args[]){
        int[] list = new int[10];
        randomizeArray(list);
        bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }
    public static void bubbleSort(int [] list){ // improve on this bubble sort
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for(int x = 0; x < list.length-1; x++){
                if(list[x] > list[x +1]){
                    swap(list, x);
                    isSorted = false;
                }
            }
        }
    }
    public static void insertionSort(int [] list){
        // insertion sort code here
    }
    public static void selectionSort(int [] list){
        // selection sort code here
    }
    public static void randomizeArray(int[]list){
        for(int x = 0; x < list.length; x++){
            list[x] = (int)(Math.random() * 10);
        }
    }
    public static void swap(int[] list, int index){
        int x = list[index];
        list[index] = list[index+1];
        list[index+1] = x;
    }
}
