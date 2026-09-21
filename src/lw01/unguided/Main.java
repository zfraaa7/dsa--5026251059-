package lw01.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner inputz = new Scanner(Main.class.getResourceAsStream("rentals.txt"));

        int T = inputz.nextInt();

        Rental[] rental = new Rental[T];

        for (int i = 0; i < T; i++) {
            String jenisz = inputz.next();
            String idz = inputz.next();
            int dayz = inputz.nextInt();
            int unitz = inputz.nextInt();

            if (jenisz.equalsIgnoreCase("LAPTOP")) {
                
                rental[i] = new LaptopRental(idz, dayz) {
                    @Override
                    public int calculateCharge() {
                        return super.calculateCharge(unitz);
                    }
                };

            } else if (jenisz.equalsIgnoreCase("PROJECTOR")) {
                
                rental[i] = new ProjectorRental(idz, dayz) {
                    @Override
                    public int calculateCharge() {
                        return super.calculateCharge(unitz);
                    }
                };
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(rental[i].summary());
        }

        inputz.close();
    }
}