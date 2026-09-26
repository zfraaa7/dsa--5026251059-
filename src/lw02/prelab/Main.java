import java.util.Scanner;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Scanner inputz = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        LinkedList<String[]> transaksiz = new LinkedList<String[]>();
        LinkedList<String[]> customerz = new LinkedList<String[]>();
        Queue<String[]> queuez = new LinkedList<String[]>();
        Stack<String[]> stackz = new Stack<String[]>();

       
        while (inputz.hasNext()) {
            String namaz = inputz.next();
            String jenisz = inputz.next();
            int jumlahz = inputz.nextInt();

            String[] datatz = {namaz, jenisz, String.valueOf(jumlahz)};
            transaksiz.add(datatz);

            boolean adaz = false;
            for (int i = 0; i < customerz.size(); i++) {
                if (customerz.get(i)[0].equalsIgnoreCase(namaz)) {
                    adaz = true;
                    break;
                }
            }

            if (!adaz) {
                String[] datacz = {namaz, "0"};
                customerz.add(datacz);
            }
        }

        
        for (int i = 0; i < transaksiz.size(); i++) {
            queuez.add(transaksiz.get(i));
        }

        
        while (!queuez.isEmpty()) {
            String[] sekarangz = queuez.poll();
            String namaTransz = sekarangz[0];
            String jenisTransz = sekarangz[1];
            int jumlahTransz = Integer.parseInt(sekarangz[2]);

            for (int j = 0; j < customerz.size(); j++) {
                if (customerz.get(j)[0].equalsIgnoreCase(namaTransz)) {
                    int saldoz = Integer.parseInt(customerz.get(j)[1]);

                    if (jenisTransz.equalsIgnoreCase("DEPOSIT")) {
                        saldoz += jumlahTransz;
                        customerz.get(j)[1] = String.valueOf(saldoz);
                    } else if (jenisTransz.equalsIgnoreCase("WITHDRAW")) {
                        if (saldoz >= jumlahTransz) {
                            saldoz -= jumlahTransz;
                            customerz.get(j)[1] = String.valueOf(saldoz);
                        } else {
                            stackz.push(sekarangz);
                        }
                    }
                    break;
                }
            }
        }

        
        System.out.println("=== Final Balances ===");
        for (int b = 0; b < customerz.size(); b++) {
            System.out.println(customerz.get(b)[0] + " : " + customerz.get(b)[1]);
        }

        
        System.out.println();

        
        System.out.println("=== Failed Transactions ===");
        while (!stackz.isEmpty()) {
            String[] gagalz = stackz.pop();
            System.out.println(gagalz[0] + " " + gagalz[1] + " " + gagalz[2]);
        }
    }
}