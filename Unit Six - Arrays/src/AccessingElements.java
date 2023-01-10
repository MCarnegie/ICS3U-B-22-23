public class AccessingElements {
    public static void main(String[] args) {
        declaringArrays();

        int[] arr = {5,7,1,3,4,6};
        accessingArrays(arr);
        System.out.println(arr[0]); //100
    }

    private static void accessingArrays(int[] arr) {
        System.out.println(arr[0]); //5
        System.out.println(arr[3]); //3
        System.out.println(arr[arr.length-1]); //6
        System.out.println(arr[arr.length/2]); //3

        arr[0] = 100;
        System.out.println(arr[0]); //100
    }


    private static void declaringArrays() {
        //declare int array called arr and initilize it with a series of ints
        int[] arr = {3,6,5,4,3,2,1,3,4};
        
        //declare double array called nums and initilize it to a double array of length 10
        double[] nums = new double[10];

        //having nums refer (point) to a different double array
        nums = new double[6];
    }
}
