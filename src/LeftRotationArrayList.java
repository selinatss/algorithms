import java.util.ArrayList;
import java.util.List;

public class LeftRotationArrayList {
    public static void main(String[] args)
    {
        LeftRotationArrayList rotate = new LeftRotationArrayList();
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        rotate.rotLeft(a, 2);
        ///rotate.printArray(arr, 7);
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // create temp array of size d
        List<Integer> tmp = new ArrayList<>();
        int n = a.size();

        // copy first d element in array temp
        for (int i = 0; i < d; i++)
            tmp.add(a.get(i));

        // move the rest element to index
        // zero to N-d
        for (int i = d; i < a.size(); i++) {
            int value = a.get(i);
            a.set(i-d, value);
        }

        // copy the temp array element
        // in origninal array
        for (int i = 0; i < d; i++) {
            a.set(i+n-d, tmp.get(i));
        }
        System.out.println(a);
        return a;
    }


}
