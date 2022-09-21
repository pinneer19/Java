import java.lang.reflect.Array;
import java.util.*;
import java.util.Collections;

public class Sort {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Integer> ai = new ArrayList<>(n);
        ArrayList<Integer> bi = new ArrayList<>(n);

        while (n != 0) {
            ai.add(sc.nextInt());
            bi.add(sc.nextInt());
            n--;
        }

    }
    static int counter = 0;


    public static ArrayList<Integer> MergeSort(ArrayList<Integer> array, int l, int r) {
        int mid = l + (r - l) / 2;
        if (l + 1 == r)
            return Merge(new ArrayList<>(Arrays.asList(array.get(l))), new ArrayList<>(Arrays.asList(array.get(r))));
        if (l == r) return new ArrayList<>(Arrays.asList(array.get(l)));
        return Merge(MergeSort(array, l, mid), MergeSort(array, mid + 1, r));

    }

    public static ArrayList<Integer> Merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int ind1 = 0, ind2 = 0;
        ArrayList<Integer> new_arr = new ArrayList<>(list1.size() + list2.size());
        while (ind1 != list1.size() && ind2 != list2.size()) {
            if (list1.get(ind1) > list2.get(ind2)) {
                new_arr.add(list2.get(ind2));
                ind2++;
                counter += list1.size() - ind1;
            } else {
                new_arr.add(list1.get(ind1));
                ind1++;
            }
        }
        if (ind1 == list1.size() && ind2 == list2.size()) return new_arr;
        if (ind1 < list1.size()) while (ind1 != list1.size()) new_arr.add(list1.get(ind1++));
        else while (ind2 != list2.size()) new_arr.add(list2.get(ind2++));

        return new_arr;
    }


    public static void QuickSort(ArrayList<Integer> array, int first, int last) {
        int l = first ,r = last;
        int pivot = array.get(l + (r-l)/2);

        while(l <= r) {

            while (array.get(l) < pivot) {l++;}
            while (array.get(r) > pivot) {r--;}

            if(l <= r) Collections.swap(array,l,r);
            l++;
            r--;
        }
        if(first < r) QuickSort(array,first,r);
        if(l < last) QuickSort(array,l,last);
    }
}
