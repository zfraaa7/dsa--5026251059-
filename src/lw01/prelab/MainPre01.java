import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class MainPre01 {
    public static void main(String[] args) throws FileNotFoundException {
         List<PrintJob> jobsz = new ArrayList<>();
 
        Scanner inputz = new Scanner(new File("jobs.txt"));
            while (inputz.hasNext()) {
                
                String jenisz = inputz.next();
                String idz = inputz.next();
                int pagez = inputz.nextInt();
 
                if (jenisz.equalsIgnoreCase("MONO")) {
                    jobsz.add(new MonoPrint(idz, pagez));
                } else if (jenisz.equalsIgnoreCase("COLOUR")) {
                    jobsz.add(new ColourPrint(idz, pagez));
                } else {
                    throw new IllegalArgumentException("Unknown job type: " + jenisz);
                }
            }
            
            for (int i = 0; i < jobsz.size(); i++) {
            System.out.println(jobsz.get(i).summary());
        }

    }
         
        
}

