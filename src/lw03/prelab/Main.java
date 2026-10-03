import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner inputMusik = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        Scanner inputMahasiswa = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Scanner inputMap = new Scanner(Main.class.getResourceAsStream("inventory.txt"));


        List<String> daftarMusik = new ArrayList<>();
        Set<String> mahasiswa = new LinkedHashSet<>();
        Map<String, Integer> inventory = new LinkedHashMap<String, Integer>();
        int duplikat = 0;
        int kurang = 0;

        //musik
        while(inputMusik.hasNext()) {
            String proses = inputMusik.next();
            int index;
            String musik;

            if(proses.equals("ADD")) {
                musik = inputMusik.nextLine();
                daftarMusik.add(musik);
            } else if(proses.equals("REMOVE")) {
                musik = inputMusik.nextLine();
                daftarMusik.remove(musik);
            }else if(proses.equals("INSERT")){
                index = inputMusik.nextInt();
                musik = inputMusik.nextLine();
                
                if(index >= 0 && index <= daftarMusik.size()){
                    daftarMusik.add(index, musik);
                }
            }


        }

        System.out.println("===== Problem 1 ===== ");
        System.out.println("Total Songs : " + daftarMusik.size());
        for(int i = 0; i < daftarMusik.size(); i++){
            System.out.println(i + " : " + daftarMusik.get(i));
        }

        //mahasiswa
        while(inputMahasiswa.hasNext()){
            String nama = inputMahasiswa.next();

            if(mahasiswa.contains(nama)){
                duplikat++;
            } else {
                mahasiswa.add(nama);
            }
        }

        int no = 1;
        System.out.println("===== Problem 2 ===== ");
        System.out.println("Unique Participants : " + mahasiswa.size());
        for(String nama : mahasiswa){
            System.out.println(no + ". "+ nama);
            no++;
        }
        System.out.println("Duplicate registrations : " + duplikat);

        //inventory
        while(inputMap.hasNext()){
            String proses = inputMap.next();
            String barang = inputMap.next();
            int jumlah = inputMap.nextInt();

            if(proses.equals("ADD")){
                if(inventory.containsKey(barang)){
                    int jumlahSekarang = inventory.get(barang);
                    inventory.put(barang, jumlahSekarang + jumlah);
                } else {
                    inventory.put(barang, jumlah);
                }
            }else if(proses.equals("SELL")){
                if(inventory.containsKey(barang)){
                    int jumlahSekarang = inventory.get(barang);
                    if(jumlahSekarang >= jumlah){
                        inventory.put(barang, jumlahSekarang - jumlah);
                    } else {
                        kurang++;
                    }
                }else{
                    kurang++;
                }
            }
        }
        System.out.println("===== Problem 3 ===== ");
        for(String barang : inventory.keySet()){
            System.out.println(barang + ": " + inventory.get(barang));
        }
        System.out.println("Failed sales : " + kurang);
    }
}
