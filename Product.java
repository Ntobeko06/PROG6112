/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author ntobe
 */


public class Product implements IProduct {

    private final String[] products;
    private final int[][] salesData;

    // Constructor accepting products and 2D sales data 
    public Product(String[] products, int[][] salesData) {
        this.products = products;
        this.salesData = salesData;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] row : salesData) {
            for (int sale : row) {
                total += sale;
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = 0;
        for (int[] row : salesData) {
            count += row.length;
        }
        return (count > 0) ? (double) total / count : 0.0;
    }

    @Override
    public String GetMostPopularProduct() {
        int highestTotal = -1;
        String mostPopular = "";

        for (int i = 0; i < products.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                productTotal += salesData[i][j];
            }
            if (productTotal > highestTotal) {
                highestTotal = productTotal;
                mostPopular = products[i];
            }
        }
        return mostPopular;
    }
}