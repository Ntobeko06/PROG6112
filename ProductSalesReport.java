/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Scanner;

/**
 *
 * @author ntobe
 */
public class ProductSalesReport {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Product names (1D array)
        String[] products = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        // Sales for 3 products over 3 months (2D array)
        int[][] sales = new int[3][3];

        // Total sales for each product (1D array)
        int[] productTotals = new int[3];

        int totalSales = 0;

        // Input sales information
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print("Enter number of sales for month "
                        + (j + 1) + " for " + products[i] + ": ");

                sales[i][j] = input.nextInt();

                // Calculate product total
                productTotals[i] += sales[i][j];

                // Calculate overall total
                totalSales += sales[i][j];
            }

            System.out.println();
        }

        // Calculate average sales
        int averageSales = totalSales / 9;

        // Find the most popular product
        int highestSales = productTotals[0];
        int popularProduct = 0;

        for (int i = 1; i < 3; i++) {

            if (productTotals[i] > highestSales) {

                highestSales = productTotals[i];
                popularProduct = i;
            }
        }

        // Display sales report
        System.out.println();
        System.out.println("PRODUCT SALES REPORT - 2026");

        System.out.println("****************************************");

        System.out.println("TOTAL PRODUCT SALES: " + totalSales);

        System.out.println("AVERAGE PRODUCT SALES: " + averageSales);

        System.out.println("MOST POPULAR PRODUCT: "
                + products[popularProduct]
                + " (" + highestSales + ")");

        System.out.println("****************************************");

        input.close();
    }
}

