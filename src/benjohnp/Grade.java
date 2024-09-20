package BenjohnP;

import java.util.Scanner;

 public class Grade {
    public static void main(String[] args) {
        Grades[] gradeRecords = new Grades[100];
        int recordCount = 0;
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Select an option:");
            System.out.println("1. Add Grades");
            System.out.println("2. View Grades");
            System.out.println("3. Edit Grades");
            System.out.println("4. Delete Grades");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    boolean addMore = true;
                    while (addMore) {
                        Grades newGrade = new Grades();
                        newGrade.getGrade();
                        gradeRecords[recordCount++] = newGrade;
                        System.out.print("Do you want to add another record? (yes/no): ");
                        String continueAdding = input.nextLine();
                        addMore = continueAdding.equalsIgnoreCase("yes");
                    }
                    break;

                case 2:
                    System.out.print("Enter student ID to view: ");
                    String viewId = input.nextLine();
                    boolean found = false;
                    for (int i = 0; i < recordCount; i++) {
                        if (gradeRecords[i] != null && gradeRecords[i].getId().equals(viewId)) {
                            gradeRecords[i].printGradeDetails();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Record with ID " + viewId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID to edit: ");
                    String editId = input.nextLine();
                    found = false;
                    for (int i = 0; i < recordCount; i++) {
                        if (gradeRecords[i] != null && gradeRecords[i].getId().equals(editId)) {
                            gradeRecords[i].editGrade();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Record with ID " + editId + " not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    String deleteId = input.nextLine();
                    found = false;
                    for (int i = 0; i < recordCount; i++) {
                        if (gradeRecords[i] != null && gradeRecords[i].getId().equals(deleteId)) {
                            gradeRecords[i].deleteGrade();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Record with ID " + deleteId + " not found.");
                    }
                    break;

                case 5:
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }

        input.close();
    }
}