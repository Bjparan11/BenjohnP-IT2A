package BenjohnP;

import java.util.Scanner;

class BenjohnPGrades {
    
    public void getGrade() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String name = sc.nextLine();

        System.out.print("Enter student's grade: ");
        int grade = sc.nextInt();

        if (grade >= 90) {
            System.out.println(name + " received an A.");
        } else if (grade >= 80) {
            System.out.println(name + " received a B.");
        } else if (grade >= 70) {
            System.out.println(name + " received a C.");
        } else if (grade >= 60) {
            System.out.println(name + " received a D.");
        } else {
            System.out.println(name + " received an F.");
        }
    }
}

class BenjohnPProduct {
    int id;
    String name;
    double price;
    int stock;
    int sold;

    public void addProduct(int id, String name, int stock, double price, int sold) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.sold = sold;
    }

    public void viewProduct() {
        double totalProfit = price * sold;
        double expectedProfit = price * stock;

        String status = stock > sold ? "In Stock" : "Out of Stock";

        System.out.printf("%-10d %-20s %-10d %-20.2f %-20d %-20.2f %-20.2f %-20s\n",
                          id, name, stock, price, sold, expectedProfit, totalProfit, status);
    }
}

class BenjohnPAccount {
    private static int lastId = 0;
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public BenjohnPAccount(String firstName, String lastName, String email, String username, String password) {
        this.id = ++lastId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | First Name: " + firstName + " | Last Name: " + lastName +
               " | Email: " + email + " | Username: " + username;
    }
}

class BenjohnPAccounts {
    private BenjohnPAccount[] accountList;
    private int currentIndex;

    public BenjohnPAccounts(int size) {
        accountList = new BenjohnPAccount[size];
        currentIndex = 0;
    }

    public boolean addAccount(BenjohnPAccount account) {
        for (int i = 0; i < currentIndex; i++) {
            if (accountList[i].getEmail().equalsIgnoreCase(account.getEmail()) ||
                accountList[i].getUsername().equalsIgnoreCase(account.getUsername())) {
                System.out.println("Error: Duplicate email or username not allowed.");
                return false;
            }
        }
        if (currentIndex < accountList.length) {
            accountList[currentIndex++] = account;
            return true;
        } else {
            System.out.println("Error: Account list is full.");
            return false;
        }
    }

    public void viewAccounts() {
        if (currentIndex == 0) {
            System.out.println("No accounts registered.");
        } else {
            for (int i = 0; i < currentIndex; i++) {
                System.out.println(accountList[i]);
            }
        }
    }

    public boolean isPasswordValid(String password) {
        if (password.length() < 8) {
            System.out.println("Password must be at least 8 characters long.");
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        String specialCharacters = "!@#$%^&*(),.?\":{}|<>";

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpperCase = true;
            if (Character.isLowerCase(ch)) hasLowerCase = true;
            if (Character.isDigit(ch)) hasNumber = true;
            if (specialCharacters.indexOf(ch) >= 0) hasSpecialChar = true;
        }

        if (!hasUpperCase) {
            System.out.println("Password must contain at least one uppercase letter.");
            return false;
        }
        if (!hasLowerCase) {
            System.out.println("Password must contain at least one lowercase letter.");
            return false;
        }
        if (!hasSpecialChar) {
            System.out.println("Password must contain at least one special character.");
            return false;
        }
        if (!hasNumber) {
            System.out.println("Password must contain at least one number.");
            return false;
        }
        if (password.toLowerCase().contains("admin") ||
            password.toLowerCase().contains("password") ||
            password.contains("1234")) {
            System.out.println("Password must not contain common words like 'admin', 'password', or '1234'.");
            return false;
        }
        return true;
    }
}

public class BenjohnP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("=== Grades Section ===");
        BenjohnPGrades grd = new BenjohnPGrades();
        grd.getGrade();

    
        System.out.println("\n=== Products Section ===");
        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();

        BenjohnPProduct[] products = new BenjohnPProduct[numProducts];

        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter details of product " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = scanner.nextInt();

            System.out.print("Name: ");
            scanner.nextLine();  // Consume newline
            String name = scanner.nextLine();

            System.out.print("Price: ");
            double price = scanner.nextDouble();

            System.out.print("Stock: ");
            int stock = scanner.nextInt();

            System.out.print("Sold: ");
            int sold = scanner.nextInt();

            BenjohnPProduct product = new BenjohnPProduct();
            product.addProduct(id, name, stock, price, sold);

            products[i] = product;
        }

        System.out.println("\n=== Product Details ===");
        System.out.printf("%-10s %-20s %-10s %-20s %-20s %-20s %-20s %-20s\n",
                          "ID", "Name", "Stock", "Price", "Items Sold", "Expected Profit", "Total Profit", "Status");

        for (BenjohnPProduct product : products) {
            product.viewProduct();
        }

       
        System.out.println("\n=== Accounts Section ===");
        System.out.print("Enter number of accounts to register: ");
        int numberOfAccounts = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        BenjohnPAccounts accounts = new BenjohnPAccounts(numberOfAccounts);

        for (int i = 0; i < numberOfAccounts; i++) {
            System.out.println("Enter details for account " + (i + 1) + ":");

            System.out.print("First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            System.out.print("Username: ");
            String username = scanner.nextLine();

            String password;
            do {
                System.out.print("Password: ");
                password = scanner.nextLine();
                if (!accounts.isPasswordValid(password)) {
                    System.out.println("Invalid password. Please try again.");
                }
            } while (!accounts.isPasswordValid(password));

            BenjohnPAccount newAccount = new BenjohnPAccount(firstName, lastName, email, username, password);
            if (accounts.addAccount(newAccount)) {
                System.out.println("Account added successfully.");
            } else {
                System.out.println("Failed to add account due to duplicate information.");
            }
        }

        System.out.println("\nAll registered accounts:");
        accounts.viewAccounts();

        scanner.close();
    }
}
