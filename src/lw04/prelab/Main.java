import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int N = input.nextInt();
        int[] list = new int[N];
        

        for(int i = 0; i < N; i++){
            int angka = input.nextInt();

            list[i] = angka;
        }

        int passes = 3;

        for(int i = 1; i <= passes; i++){
            int key = list[i];
            int j = i -1;

            while(j >= 0 && list[j]<key){
                list[j+1] = list[j];
                j--;
            }

            list[j+1] = key;
        }

        for(int i = 0; i < N; i++){
            System.out.print(list[i] + " ");
        }

        System.out.println();

        int T = input.nextInt();
        int[] target = new int[T];

        for(int i = 0; i < T; i++){
            int nilai = input.nextInt();
            target[i] = nilai;
        }

        for(int i = 0; i < T; i++){
            int nilai = target[i];
            boolean found = false;
            int idx = -1;

            for(int j = 0; j < list.length; j++){
                if(list[j] == nilai){
                    found = true;
                    idx = j;
                    break;
                }
            }

            if(found){
                System.out.println(nilai + ": FOUND at index " + idx);
            } else {
                System.out.println(nilai + ": NOT FOUND");
            }
        }
    }
}