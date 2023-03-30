import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        //System.out.println(factorial(7));
        //System.out.println(fibonacci(1000));


        int[] arr = {2,3,4,5,1,2,3,4,76,45,32,12,89,34,43,56};
        Arrays.sort(arr);

        System.out.println(binarySearchRecursion(arr, 1, 0, arr.length-1));
        
    }

    private static int binarySearchRecursion(int[] arr, int find, int min, int max) {
        int mid = (min+max)/2;

        if(min> max)
            return -1;

        if(arr[mid] == find)
            return mid;
        else if(find < arr[mid])
           return binarySearchRecursion(arr, find, min, mid-1);
        else
            return binarySearchRecursion(arr, find, min, mid+1);
        

    }

    private static int binarySearch(int[] arr, int i) {
       int min = 0;
       int max = arr.length - 1;
       int mid;

       while(min <= max){
        mid = (min+max)/2;
        if(arr[mid] == i)
            return mid;
        else if(i < arr[mid])
            max = mid-1;
        else
            min = mid+1;
        }

        return -1;

    }

    static long[] results = new long[1001];

    private static long fibonacci(int i) {
        if(results[i] != 0)
            return results[i];

        if(i == 1 || i == 2)
            return 1;
        
        results[i] = fibonacci(i-1) + fibonacci(i-2);

            return results[i];
    }

    private static int factorial(int i) {
        if(i == 1)
            return 1;
        
        return i * factorial(i-1);
    }
}
