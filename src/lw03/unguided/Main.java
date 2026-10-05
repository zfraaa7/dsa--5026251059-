import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        Map<String, Integer> dataKampus = new LinkedHashMap<String, Integer>();
        Map<String, String> checkData = new LinkedHashMap<String, String>();
        int tolak = 0;

        while(input.hasNext()){
            String proses = input.next();
            String matkul = input.next();
            int jumlah;

            if(proses.equals("REGISTER")){

                jumlah = input.nextInt();

                if(dataKampus.containsKey(matkul)){
                    int jumlahSekarang = dataKampus.get(matkul);
                    dataKampus.put(matkul, jumlah + jumlahSekarang);
                } else {
                    dataKampus.put(matkul, jumlah);
                }
            }else if(proses.equals("WITHDRAW")){
                jumlah = input.nextInt();

                if(dataKampus.containsKey(matkul)){
                    int jumlahSekarang = dataKampus.get(matkul);
                    if(jumlahSekarang >= jumlah){
                        dataKampus.put(matkul, jumlahSekarang - jumlah);
                    } else {
                        tolak++;
                    } 
                }else{
                    tolak++;
                }
            }else if(proses.equals("CHECK")){
                if(dataKampus.containsKey(matkul)){
                    checkData.put(matkul, String.valueOf(dataKampus.get(matkul) + " students"));
                }else{
                    checkData.put(matkul, "Not Found");
                    tolak++;
                }
            }else{
                tolak++;
            }
            
        }

        System.out.println("===== Enrollment Checks =====");
        for(String matkul : checkData.keySet()){
            System.out.println(matkul + ": " + checkData.get(matkul));
        }
        System.out.println();

        System.out.println("===== Final Enrollment =====");
        for(String matkul : dataKampus.keySet()){
            System.out.println(matkul + ": " + dataKampus.get(matkul) + " students");
        }

        System.out.println();

        System.out.println("Rejected operations: " + tolak);
    }
}