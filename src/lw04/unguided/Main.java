import java.util.*;

public class Main {
    public static void selectionSort(int[] data, int pass) {
        for (int i = 0; i < pass; i++) {
            int minz = data[i];
            int idx = i;

            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < minz) {
                    minz = data[j];
                    idx = j;
                }
            }

            if (idx != i) {
                int temp = data[i];
                data[i] = data[idx];
                data[idx] = temp;
            }
        }
    }

    public static int linearSearch(int[] data, int jml) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == jml) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner inputz = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int jumlahKartu = inputz.nextInt();
        int[] data = new int[jumlahKartu];

        for (int i = 0; i < jumlahKartu; i++) {
            data[i] = inputz.nextInt();
        }

        selectionSort(data, 2);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();

        int N = inputz.nextInt();
        for (int i = 0; i < N; i++) {
            int target = inputz.nextInt();
            int result = linearSearch(data, target);

            if (result != -1) {
                System.out.println(target + ": FOUND at index " + result);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }
        
    }
}