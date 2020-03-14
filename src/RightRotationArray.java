public class RightRotationArray {
    public static void main(String[] args)
    {
        RightRotationArray rotate = new RightRotationArray();
        int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
        rotate.rightRotate(arr, 3, 7);
        rotate.printArray(arr, 7);
    }
    void rightRotate(int arr[], int d, int n)
    {
        for (int i = 0; i < d; i++)
            rightRotatebyOne(arr, n);
    }

    void rightRotatebyOne(int arr[], int n)
    {
        int i, temp;
        int length = arr.length;
        temp = arr[length-1];
        for(i = arr.length-1; i > 0; i--){
            //Shift element of array by one
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
    }

    void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
