package BenjohnP;

import java.util.Scanner;

public class Product {
    
    public static void main(String[] args) {
        Products[] pr = new Products[100];  

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int nump = sc.nextInt();

     
        for (int i = 0; i < nump; i++) {
            System.out.println("Enter details of product " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Price: ");
            double pri = sc.nextDouble();

            System.out.print("Stock: ");
            int st = sc.nextInt();

            System.out.print("Sold: ");
            int sold = sc.nextInt();

            Products prod = new Products(); 
            prod.addProduct(id, name, st, pri, sold);

            pr[i] = prod;  
        }

    
        System.out.println("----------------------");
        System.out.println("\nProduct Details:\n");
        System.out.println("----------------------");

        System.out.printf("%-10s %-20s %-10s %-20s %-20s %-20s %-20s %-20s\n",
                          "ID", "Name", "Stocks", "Price", "Items Sold", "Total Expected Profit", "Total Profit", "Status");

        for (int i = 0; i < nump; i++) {
            pr[i].viewProduct();
        }

        sc.close();
    }
}