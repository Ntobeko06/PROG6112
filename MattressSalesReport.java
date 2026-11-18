/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mattresssalesreport;

import javax.lang.model.SourceVersion;

/**
 *
 * @author ntobe
 */
public class MattressSalesReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }
    
}


public class MattressSalesReport {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Single-dimensional array for the three top-performing products
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };

        // Two-dimensional array for sales (3 products x 3 months)
        int[][] sales = new int[3][3];

        // Single-dimensional array to store total sales per product
        int[] productTotals = new int[3];

        int totalSales = 0;
        int totalEntries = 9; // 3 products * 3 months

        // Input sales data for each product over 3 months
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + " mattress: ");
                sales[i][j] = scanner.nextInt();

                // Accumulate total sales overall and per product
                totalSales += sales[i][j];
                productTotals[i] += sales[i][j];
            }
            System.out.println(); // Blank line for spacing between products
        }

        // Calculate average sales across all 9 entries (using integer division as shown in sample)
        int averageSales = totalSales / totalEntries;

        // Find the most popular product (highest total sales)
        int maxIndex = 0;
        for (int i = 1; i < productTotals.length; i++) {
            if (productTotals[i] > productTotals[maxIndex]) {
                maxIndex = i;
            }
        }

        // Display the final report
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("**************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + totalSales);
        System.out.println("AVERAGE PRODUCT SALES: " + averageSales);
        System.out.println("MOST POPULAR PRODUCT: " + products[maxIndex] + " (" + productTotals[maxIndex] + ")");

        scanner.close();
    }
}