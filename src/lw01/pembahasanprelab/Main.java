import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
         List<PrintJob> jobsz = new ArrayList<>();
 
        Scanner inputz = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
            while (inputz.hasNext()) {
                
                String jenisz = inputz.next();
                String idz = inputz.next();
                int pagez = inputz.nextInt();
                
                PrintJob job;
                if (jenisz.equalsIgnoreCase("MONO")) {
                    job = new MonoPrint(idz, pagez);
                    jobsz.add(job);
                } else if (jenisz.equalsIgnoreCase("COLOUR")) {
                    job = new ColourPrint(idz, pagez);
                    jobsz.add(job);
                } 
            }

            
            for (PrintJob job : jobsz) {
            System.out.println(job.summary());
        }

    
         
        
}
}


