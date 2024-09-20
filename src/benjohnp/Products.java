package Benjohnp;

import java.util.Scanner;

public class Products {
    
    private int pid;
    private String pname;
    private int stocks;
    private double price;
    private int sold;

    public void addProduct(int id, String name, int st, double pr, int sold) {
        this.pid = id;
        this.pname = name;
        this.stocks = st;
        this.price = pr;
        this.sold = sold;
    }


    public void viewProduct() {
        double totalExpectedProfit = this.price * (this.stocks - this.sold);
        double totalProfit = this.sold * this.price;
        String status = (this.stocks > 0) ? "Available" : "Out-of-stock";

        System.out.printf("%-10d %-20s %-20d %-20.2f %-20d %-20.2f %-20.2f %-20s\n",
                          this.pid, this.pname, this.stocks, this.price, this.sold, totalExpectedProfit, totalProfit, status);
    }
}