import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MainPre01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputz = new Scanner(new File("./jobs.txt"));

        PrintJob[] jobs = new PrintJob[100];
        int T = inputz.nextInt();

        for(int i = 0; i < T; i++){
            String jenisz = inputz.next();
            String idz = inputz.next();
            int pagesz = inputz.nextInt();

            if(jenisz.equals("MONO")){
                jobs[i] = new MonoPrint(idz, pagesz);
            }else if(jenisz.equals("COLOUR")){
                jobs[i] = new ColourPrint(idz, pagesz);
            }
        }

        for(int j = 0; j < T; j++){
            System.out.println(jobs[j].summary());
        }
    }
}
