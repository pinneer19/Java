import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Objects;

public class Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Priority_queue queue = new Priority_queue();
        int n = sc.nextInt();
        while (n != 0) {

            String s = sc.next();
            if(s.equals("Insert")) {
                int num = sc.nextInt();
                queue.add(num);
            }
            else {
                System.out.println(queue.poll());
            }
            //queue.print();
            //System.out.println();
            n--;
        }
    }

}

class Priority_queue {

    private ArrayList<Integer> arr = new ArrayList<>();
    private int size_;

    private void SiftUp() {
        int ind = size_;
        while(ind > 1 && arr.get(ind - 1) > arr.get(ind / 2 - 1)) {
            Collections.swap(arr, ind - 1, ind / 2 - 1);
            ind /= 2;
        }
    }

    private void SiftDown() {
        int ind = 1;

        while (ind * 2 <= size_) {

            if(ind * 2 != size_ && arr.get(ind * 2 - 1) > arr.get(ind - 1) && arr.get(ind * 2) > arr.get(ind - 1)) {
                if(arr.get(ind * 2 - 1) > arr.get(ind * 2)) {
                    Collections.swap(arr, ind - 1, ind * 2 - 1);
                    ind *= 2;
                }
                else {
                    Collections.swap(arr, ind - 1, ind * 2);
                    ind *= 2;
                    ind++;
                }
            }
            else if(arr.get(ind * 2 - 1) > arr.get(ind - 1)) {
                Collections.swap(arr, ind - 1, ind * 2 - 1);
                ind *= 2;
            }
            else if(ind * 2 != size_ && arr.get(ind * 2) > arr.get(ind - 1)) {
                Collections.swap(arr, ind - 1, ind * 2);
                ind *= 2;
                ind++;
            }
            else break;
        }

    }
    boolean empty() {
        return size_ == 0;
    }

    int size() {
        return size_;
    }

    void add(int value) {
        size_++;
        arr.add(value);
        SiftUp();

    }
    void print() {
        for (Integer a : arr) {
            System.out.print(a + " ");
        }
    }

    int poll() {
        size_--;
        Collections.swap(arr, 0, size_);
        int max = arr.get(size_);

        arr.remove(size_);

        SiftDown();

        return max;
    }

};