import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        // Write your main code here
        BinarySearchTree bstz = new BinarySearchTree();

        String[] barisz = read.nextLine().split(" ");
            for (String number : barisz) {
                int data = Integer.parseInt(number);
                bstz.insert(data);
            }

        int target = read.nextInt();

        System.out.print("Preorder : ");
        bstz.preOrder();

        System.out.print("Inorder : ");
        bstz.inOrder();

        System.out.print("Postorder : ");
        bstz.postOrder();

        System.out.print("Search " + target + " : ");
        System.out.println(bstz.search(target));

        System.out.print("Minimum : ");
        System.out.println(bstz.findMin());

        System.out.print("Maximum : ");
        System.out.println(bstz.findMax());
        
        read.close();
    }
}