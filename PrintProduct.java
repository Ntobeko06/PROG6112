/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author ntobe
 */



public class PrintProduct {

    private final Product product;

    public PrintProduct(Product product) {
        this.product = product;
    }

    public void printTotalProductSales() {
        System.out.println("Total Products Sold: " + product.GetTotalProductsSold());
    }

    public void printAverageProductSales() {
        System.out.printf("Average Products Sold: %.2f%n", product.GetAverageProductSold());
    }

    public void printMostPopularProduct() {
        System.out.println("Most Popular Product: " + product.GetMostPopularProduct());
    }

    public void printReport() {
        System.out.println("PRODUCT SALES REPORT");
        System.out.println("------------------------------------");
        printTotalProductSales();
        printAverageProductSales();
        printMostPopularProduct();
    }
}