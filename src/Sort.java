import java.lang.reflect.Array;
import java.util.*;
import java.util.Collections;

public class Sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(n);
        while (n != 0) {
            arr.add(sc.nextInt());
            n--;
        }

        System.out.println(MergeSort(arr,0,arr.size() - 1).toString());
        System.out.println(counter);

    }
    static int counter = 0;
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> array, int l, int r) {
        int mid = l + (r - l) / 2;
        if(l + 1 == r) return Merge(new ArrayList<>(Arrays.asList(array.get(l))),new ArrayList<>(Arrays.asList(array.get(r))));
        if(l == r) return new ArrayList<>(Arrays.asList(array.get(l)));
        return Merge(MergeSort(array,l,mid),MergeSort(array,mid + 1,r));

    }

    public static ArrayList<Integer> Merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        int ind1 = 0, ind2 = 0;
        ArrayList<Integer> new_arr = new ArrayList<>(list1.size() + list2.size());
        while(ind1 != list1.size() && ind2 != list2.size()) {
            if(list1.get(ind1) > list2.get(ind2)) {
                new_arr.add(list2.get(ind2));
                ind2++;
                counter += list1.size() - ind1;
            }
            else {
                new_arr.add(list1.get(ind1));
                ind1++;
            }
        }
        if(ind1 == list1.size() && ind2 == list2.size()) return new_arr;
        if(ind1 < list1.size()) while(ind1 != list1.size()) new_arr.add(list1.get(ind1++));
        else while(ind2 != list2.size()) new_arr.add(list2.get(ind2++));

        return new_arr;
    }

}
