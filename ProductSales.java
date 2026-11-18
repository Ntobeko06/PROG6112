/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productsalesapplication;

/**
 *
 * @author ntobe
 */

//=======================


public class ProductSales implements IProductSales {

    // Sales data stored in memory
    private int[][] sales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    private final int SALES_LIMIT = 500;

    // Return the sales data
    @Override
    public int[][] GetProductSales() {
        return sales;
    }

    // Calculate total sales
    @Override
    public int GetTotalSales() {
        int total = 0;

        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                total += sales[row][col];
            }
        }

        return total;
    }

    // Count sales greater than 500
    @Override
    public int GetSalesOverLimit() {
        int count = 0;

        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                if (sales[row][col] > SALES_LIMIT) {
                    count++;
                }
            }
        }

        return count;
    }

    // Count sales less than 500
    @Override
    public int GetSalesUnderLimit() {
        int count = 0;

        for (int row = 0; row < sales.length; row++) {
            for (int col = 0; col < sales[row].length; col++) {
                if (sales[row][col] < SALES_LIMIT) {
                    count++;
                }
            }
        }

        return count;
    }

    // Number of years processed
    @Override
    public int GetProductsProcessed() {
        return sales.length;
    }

    // Calculate average sales
    @Override
    public double GetAverageSales() {
        int count = 0;

        for (int row = 0; row < sales.length; row++) {
            count += sales[row].length;
        }

        if (count == 0) {
            return 0;
        }

        return (double) GetTotalSales() / count;
    }
}

