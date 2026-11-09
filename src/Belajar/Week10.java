class Week10{

    public void bubbleSortAsc(int[] angka){
        for(int i = angka.length; i >= 1; i--){
            for(int j = 0; j < i-1; j++){
                if(angka[j] > angka[j+1]){
                    int temp = angka[j];
                    angka[j] = angka[j+1];
                    angka[j+1] = temp;
                }
            }
        }

        for(int i = 0; i < angka.length; i++){
            System.out.print(angka[i] + " ");
        }
    }

    public void bubbleSortDesc(int[] angka){
        for(int i = angka.length; i >= 1; i--){
            for(int j = 0; j < i-1; j++){
                if(angka[j] < angka[j+1]){
                    int temp = angka[j];
                    angka[j] = angka[j+1];
                    angka[j+1] = temp;
                }
            }
        }

        for(int i = 0; i < angka.length; i++){
            System.out.print(angka[i] + " ");
        }
    }

    public void selectionSort(int[] angka){
        for(int i = 0; i <= angka.length-2; i++){
            int min = angka[i];
            int idx = -1;
            int temp = angka[i];
            for(int j = i+1; j <= angka.length-1; j++){
                if(angka[j] < min){
                    min = angka[j];
                    idx = j;
                }
            }

            if(angka[i] > min){
                angka[i] = min;
                angka[idx] = temp;
            }
        }

        for(int i = 0; i < angka.length; i++){
            System.out.print(angka[i] + " ");
        }
    

        
    }

    public void insertionSort(int[] angka){
        for(int i = 1; i < angka.length; i++){
            int temp = angka[i];

            for(int j = i-1; j >= 0; j--){
                if(angka[j] > temp){
                    angka[j+1] = angka[j];
                    
                }else{
                    angka[j+1] = temp;
                    break;
                }

                if(j == 0){
                    angka[j] = temp;
                }
            }
        }

        for(int i = 0; i < angka.length; i++){
            System.out.print(angka[i] + " ");
            
        }
    }

    public static int linearSearch(int[] angka, int target){
        for(int i = 0; i < angka.length; i++){
            if(angka[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] angka, int target){
       int a = 0;
       int b = angka.length-1;

       while(a <= b){
        int m = (a + b) / 2;
        if(angka[m] == target){
            return m;
        }else if(angka[m] < target){
            a = m + 1;
        }else if(angka[m] > target){
            b = m - 1;
        }
       }
       return -1;
    }

    public static void main(String[] args) {
       
        int[] angka = {7, 3, 4, 2, 1, 5, 6};

        Week10 week10 = new Week10();
        System.out.println("Ascending Order:");
        week10.bubbleSortAsc(angka);
        System.out.println("\nDescending Order:");
        week10.bubbleSortDesc(angka);
        System.out.println("\nSelection Sort:");
        week10.selectionSort(angka);
        System.out.println("\nInsertion Sort:");
        week10.insertionSort(angka);
        System.out.println("\nBinary Search for 3:");
        int binary = Week10.binarySearch(angka, 3);
        System.out.println(binary);
    }
}