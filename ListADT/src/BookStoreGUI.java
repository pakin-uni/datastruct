import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookStoreGUI extends JFrame {
    private DefaultTableModel model;
    private JTable booksTable;
    private JTextField titleField, authorField, priceField, quantityField;

    public BookStoreGUI() {
        setTitle("241 Book Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        model = new DefaultTableModel();
        booksTable = new JTable(model);
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Price");
        model.addColumn("Quantity");

        JPanel welcomePanel = new JPanel(new GridBagLayout());
        JLabel welcomeLabel = new JLabel("Welcome To Store");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomePanel.add(welcomeLabel);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Author:"));
        authorField = new JTextField();
        inputPanel.add(authorField);

        inputPanel.add(new JLabel("Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addBook();
            }
        });
        inputPanel.add(addButton);

        JButton deleteButton = new JButton("Delete Selected");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteBook();
            }
        });
        inputPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(welcomePanel, BorderLayout.NORTH);
        add(new JScrollPane(booksTable), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addBook() {
        String title = titleField.getText();
        String author = authorField.getText();
        String price = priceField.getText();
        String quantity = quantityField.getText();

        if (!title.isEmpty() && !author.isEmpty() && !price.isEmpty() && !quantity.isEmpty()) {
            model.addRow(new Object[]{title, author, price, quantity});
            titleField.setText("");
            authorField.setText("");
            priceField.setText("");
            quantityField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields");
        }
    }

    private void deleteBook() {
        int selectedRow = booksTable.getSelectedRow();
        if (selectedRow >= 0) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a book to delete");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BookStoreGUI();
            }
        });
    }
}
