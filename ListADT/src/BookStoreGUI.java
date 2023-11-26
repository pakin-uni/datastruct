import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class BookStoreGUI extends JFrame {
    Book temp;
    String Author, bookName, Genera;
    double price;

    private DefaultTableModel model;
    private JTable booksTable;
    private JTextField titleField, authorField, priceField, quantityField;

    String choice;
    int ch = 0;
    Book e,tmp;
    ListTest test = new ListTest();
    Object obj,j;
    ArrayList list = new ArrayList();
    public BookStoreGUI() {


        setTitle("241 Book Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        model = new DefaultTableModel();
        booksTable = new JTable(model);
        model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Price");
        model.addColumn("Genera");

        JPanel welcomePanel = new JPanel(new GridBagLayout());
        JLabel welcomeLabel = new JLabel("Welcome To Store");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomePanel.add(welcomeLabel);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JButton b1 = new JButton("Title:");
        b1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    list.sortBookName();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Yay you clicked me");
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inputPanel.add(b1);
        titleField = new JTextField();
        inputPanel.add(titleField);


        JButton b2 = new JButton("Author:");
        authorField = new JTextField();
        b2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int i = Integer.parseInt(JOptionPane.showInputDialog("Input 1 for sort Name ::: 2 for search Name"));
                    switch(i){
                        case 1:
                            list.sortAuthorName();
                            break;
                        case 2:
                            String name = JOptionPane.showInputDialog("Author Name");
                            if (list.SearchName(name)){
                                JOptionPane.showMessageDialog(null,"Correct.");
                            } else{
                                JOptionPane.showMessageDialog(null,"Incorrect.");
                            }
                            break;

                    }

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Yay you clicked me");
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
        inputPanel.add(b2);
        inputPanel.add(authorField);


        JButton b3 = new JButton("Price:");
        b3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    list.sortPrice();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Yay you clicked me");
            }
            @Override
            public void mousePressed(MouseEvent e) {}
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        inputPanel.add(b3);
        priceField = new JTextField();
        inputPanel.add(priceField);


        inputPanel.add(new JLabel("Genera:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    addBook();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        inputPanel.add(addButton);


        JButton deleteButton = new JButton("Delete Selected");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    deleteBook();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        inputPanel.add(deleteButton);


        setLayout(new BorderLayout());
        add(welcomePanel, BorderLayout.NORTH);
        add(new JScrollPane(booksTable), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    private void addBook() throws Exception {
        String title = titleField.getText();
        String author = authorField.getText();
        String price = priceField.getText();
        String quantity = quantityField.getText();
        double priceBook;
        if (!title.isEmpty() && !author.isEmpty() && !price.isEmpty() && !quantity.isEmpty()) {
            model.addRow(new Object[]{title, author, price, quantity});
            titleField.setText("");
            authorField.setText("");
            priceField.setText("");
            quantityField.setText("");
            priceBook = Double.parseDouble(price);

            temp = new Book(author, title, priceBook, quantity);
            temp.setStudent(author, title, priceBook, quantity);

            list.insert(temp);
        } else {
            JOptionPane.showMessageDialog(this, "Please fill in all fields");
        }
    }

    private void deleteBook() throws Exception {
        int selectedRow = booksTable.getSelectedRow();
        if (selectedRow >= 0) {
            model.removeRow(selectedRow);
            list.deleteBook(selectedRow);
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
