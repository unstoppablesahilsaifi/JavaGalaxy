package PracticeSet2;

public class SortTheArray {
    public static void main(String[] args) {
        int[] arr={3,2,4,5,1};
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println("i = " + arr[i]);
        }
    }
}
