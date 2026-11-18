/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productapp;

import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

/**
 *
 * @author ntobe
 */
@SupportedSourceVersion(SourceVersion.RELEASE_25)
public class ProductApp {

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


public class ProductApp extends JFrame {
    // Form components
    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    // Menu components
    private JMenuBar menuBar;
    private JMenu menuFile, menuTools;
    private JMenuItem itemExit, itemProcess, itemClear;

    public ProductApp() {
        setTitle("Product App");
        setSize(420, 270);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initMenus();
        initComponents();
    }

    private void initMenus() {
        menuBar = new JMenuBar();

        // File Menu
        menuFile = new JMenu("File");
        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(e -> System.exit(0));
        menuFile.add(itemExit);

        // Tools Menu
        menuTools = new JMenu("Tools");
        itemProcess = new JMenuItem("Process");
        itemClear = new JMenuItem("Clear");

        itemProcess.addActionListener(e -> processSale());
        itemClear.addActionListener(e -> clearForm());

        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Customer Name
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.3;
        mainPanel.add(new JLabel("Customer Name:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.7;
        txtCustomerName = new JTextField(15);
        mainPanel.add(txtCustomerName, gbc);

        // Select Product
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.3;
        mainPanel.add(new JLabel("Select Product:"), gbc);

        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.7;
        String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        cmbProduct = new JComboBox<>(products);
        mainPanel.add(cmbProduct, gbc);

        // Enter Price
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.3;
        mainPanel.add(new JLabel("Enter Price:"), gbc);

        gbc.gridx = 1; gbc.gridy = 2; gbc.weightx = 0.7;
        txtPrice = new JTextField(15);
        mainPanel.add(txtPrice, gbc);

        // Process Button
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSale());
        mainPanel.add(btnProcess, gbc);

        add(mainPanel);
    }

    private void processSale() {
        String customerName = txtCustomerName.getText().trim();
        String product = (String) cmbProduct.getSelectedItem();
        String priceText = txtPrice.getText().trim();

        if (customerName.isEmpty() || priceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double price = Double.parseDouble(priceText);
            ProductCalculations calc = new ProductCalculations(price);

            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String output = "Customer Name: " + customerName + "\n"
                          + "Product: " + product + "\n"
                          + "VAT: R " + vat + "\n"
                          + "COMMISSION: R " + commission + "\n"
                          + "TOTAL: R " + total;

            // Display dialog
            JOptionPane.showMessageDialog(this, output, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save to data.txt
            saveToFile(output);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveToFile(String content) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("************************************");
            writer.println(content);
            writer.println("************************************");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}