import java.util.Scanner;

class Main {
     
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter any Number");
        int num = input.nextInt();
        
        //Question One IF Statement
        if ((num >= 1) && (num <= 100)) {
            System.out.println("Number is between 1 and 100");
        }else {
            System.out.println("Number is NOT between 1 and 100");
        }
        //Question Two IF Statement
        if ((num <= 1 || num >= 100)) {
            System.out.println("Enter any number");
        }
        else {
            System.out.println("Number is NOT less than 1 or greater than 100");

        }
    }
}
    