import java.util.Scanner;
public class selectionsort{
    public static void selection(int[] arr){
        int n = arr.length;
        for(int i =0;i<n-1;i++){
            int minIndex = i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
        }
    }
public static void main(String[] args){
    int[] sizes={100,500,1000,2000,5000};
    for(int n:sizes){
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=n-i;
        }
long start=System.nanoTime();
selection(arr);
long end=System.nanoTime();
double elapse=(end-start)/1e9;
System.out.println("size:"+n+ "end t" +"="+elapse+"ns");
    }
}
}