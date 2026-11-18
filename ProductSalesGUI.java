/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ntobe
 */

//================================

package productsalesapplication;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductSalesGUI extends JFrame {

    private JButton btnLoad;
    private JButton btnSave;
    private JTextArea txtArea;
    private JLabel lblYears;

    private ProductSales sales = new ProductSales();

    public ProductSalesGUI() {

        setTitle("Product Sales Application");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);

        // Load button
        btnLoad = new JButton("Load Product Data");
        btnLoad.setBounds(40, 20, 350, 35);
        panel.add(btnLoad);

        // Save button
        btnSave = new JButton("Save Product Data");
        btnSave.setBounds(40, 65, 350, 35);
        panel.add(btnSave);

        // Text area
        txtArea = new JTextArea();
        txtArea.setEditable(false);
        txtArea.setFont(new Font("Arial", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(txtArea);
        scrollPane.setBounds(40, 115, 350, 150);
        panel.add(scrollPane);

        // Years processed label
        lblYears = new JLabel("Years Processed:");
        lblYears.setBounds(40, 280, 300, 30);
        panel.add(lblYears);

        // Create menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenu toolsMenu = new JMenu("Tools");

        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem loadItem = new JMenuItem("Load Product Data");
        JMenuItem saveItem = new JMenuItem("Save Product Data");
        JMenuItem clearItem = new JMenuItem("Clear");

        fileMenu.add(exitItem);

        toolsMenu.add(loadItem);
        toolsMenu.add(saveItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        // Button events
        btnLoad.addActionListener(e -> loadData());
        btnSave.addActionListener(e -> saveData());

        // Menu events
        loadItem.addActionListener(e -> loadData());
        saveItem.addActionListener(e -> saveData());
        clearItem.addActionListener(e -> clearData());
        exitItem.addActionListener(e -> System.exit(0));
    }

    // Load and calculate product sales
    private void loadData() {

        int total = sales.GetTotalSales();

        long average = Math.round(sales.GetAverageSales());

        int over = sales.GetSalesOverLimit();

        int under = sales.GetSalesUnderLimit();

        int years = sales.GetProductsProcessed();

        txtArea.setText(
            "Total Sales: " + total + "\n" +
            "Average Sales: " + average + "\n" +
            "Sales over limit: " + over + "\n" +
            "Sales under limit: " + under
        );

        lblYears.setText("Years Processed: " + years);
    }

    // Save results to data.txt
    private void saveData() {

        if (txtArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(
                this, "Please load product data first."
            );
            return;
        }

        try (PrintWriter writer =
                new PrintWriter(new FileWriter("data.txt"))) {

            writer.println("DATA LOG");
            writer.println("********************************");
            writer.println(txtArea.getText());
            writer.println("********************************");

            JOptionPane.showMessageDialog(
                this, "Data saved successfully!"
            );

        } catch (IOException e) {

            JOptionPane.showMessageDialog(
                this, "Error saving file: " + e.getMessage()
            );
        }
    }

    // Clear text area and years label
    private void clearData() {

        txtArea.setText("");
        lblYears.setText("Years Processed:");
    }

    // Main method
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new ProductSalesGUI().setVisible(true);
        });
    }
}

