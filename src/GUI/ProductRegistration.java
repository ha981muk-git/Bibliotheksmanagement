package GUI;
import Classes.Product;
import Database.ProductService;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.JPanel;

import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import static Database.ProductService.deleteEntryByBookID;
import static Database.ProductService.deleteEntryByBookISBN;

public class ProductRegistration extends JFrame {

    private JPanel contentPane = new JPanel();
    private final Panel panelNewBookEntry = new Panel();
    private final JButton btnSave = new JButton("Save");
    private final JLabel productRegistration = new JLabel("New Book Entry");
    private final Panel panelGenre = new Panel();
    private final JLabel lblBookGenreID = new JLabel("Book Genre ID");
    private final JTextField textFieldGenreID = new JTextField();
    private final Panel panelAuthor = new Panel();
    private final JLabel lblBookAuthor = new JLabel("Book Author");
    private final JTextField textFieldAuthorName = new JTextField();
    private final Panel panelPrice = new Panel();
    private final JLabel lblBookPrice = new JLabel("Book Price");
    private final JTextField textFieldPrice = new JTextField();
    private final Panel panelForms = new Panel();
    private final Panel panelQuantity = new Panel();
    private final JLabel lblBookQuantity = new JLabel(" Book Quantity");
    private final JTextField textFieldQuantity = new JTextField();
    private final Panel panelISBN = new Panel();
    private final JLabel lblBookISBN = new JLabel(" Book ISBN");
    private final JTextField textFieldISBN = new JTextField();
    private final Panel panelBookName = new Panel();
    private final JLabel lblBookName = new JLabel("Book Name");
    private final JTextField textFieldBookName = new JTextField();
    private final Panel panelProductID = new Panel();
    private final JLabel lblProductID = new JLabel("Product ID");
    private final JTextField textFieldProductID = new JTextField();
    private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    private final Panel panelDeleteAvailableBooks = new Panel();
    private final JButton btnDelete = new JButton("Delete ");
    private final Panel panelDeleteProductByID = new Panel();
    private final JLabel lblByProductId = new JLabel("By Product ID");
    private final JTextField textField = new JTextField();
    private final Panel panelDeleteProductBookISBN = new Panel();
    private final JLabel lblByBookIsbn = new JLabel("By Book ISBN");
    private final JTextField textFieldDeleteProductByISBN = new JTextField();
    private final JLabel lblBookDelete = new JLabel("Delete Book Entry");
    private final JButton btnMainPageDelete = new JButton("Mainpage");
    private final JButton btnBookEntryMainPage = new JButton("Mainpage");

    private final Panel panelBookGenre = new Panel();
    private final JLabel lblBookGenre = new JLabel("Book Genre");
    private final JTextField textFieldBookGenre = new JTextField();



    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductRegistration frame = new ProductRegistration();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ProductRegistration() throws IOException {
        initGUI();

    }
    private void initGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 559, 554);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        tabbedPane.setBounds(6, 6, 547, 500);

        contentPane.add(tabbedPane);
        btnSave.setBounds(311, 377, 117, 29);
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Product registrationRegistration;

                String s_genre_id   = textFieldGenreID.getText();
                String s_name       = textFieldBookName.getText();
                String s_price      = textFieldPrice.getText();
                String s_id         = textFieldProductID.getText();
                String s_stock      = textFieldQuantity.getText();
                String s_isbn       = textFieldISBN.getText();
                String s_author     = textFieldAuthorName.getText();
                String s_genre     = textFieldBookGenre.getText();
// int id double price, int stock)
                int p_id = Integer.parseInt(s_id);
                double p_price = Double.parseDouble(s_price);
                int p_stock = Integer.parseInt(s_stock);
                int p_genre_id = Integer.parseInt(s_genre_id);
                //int productType = Integer.parseInt(p_author);



                if (Integer.toString(p_id).equals("")
                        ||s_name.equals("")
                        ||String.valueOf(p_price).equals("")
                        ||Integer.toString(p_stock).equals("")
                        ||s_isbn.equals("")
                        ||s_genre_id.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "One or more fields are empty.");
                }

                else{ //public Product(int id, String name, double price, int stock, int type,String isbn, String author, String genre){
                    registrationRegistration = new Product(p_id, s_name,p_price, p_stock, p_genre_id, s_isbn, s_author, s_genre); //sb.toString()
                    try {
                        ProductService.register(registrationRegistration);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Product successfully registered.");

                }


            }
        });
        tabbedPane.addTab("New Book Entry", null, panelNewBookEntry, null);
        panelNewBookEntry.setLayout(null);

        panelNewBookEntry.add(btnSave);
        productRegistration.setBounds(194, 6, 159, 26);
        productRegistration.setFont(new Font("Lucida Grande", Font.PLAIN, 18));

        panelNewBookEntry.add(productRegistration);
        panelForms.setBounds(58, 52, 424, 327);

        panelNewBookEntry.add(panelForms);
        panelForms.setLayout(null);
        panelGenre.setBounds(39, 253, 349, 29);

        panelForms.add(panelGenre);
        panelGenre.setLayout(null);
        lblBookGenreID.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblBookGenreID.setBounds(6, 6, 103, 16);

        panelGenre.add(lblBookGenreID);
        textFieldGenreID.setBounds(137, 1, 206, 26);
        panelGenre.add(textFieldGenreID);
        textFieldGenreID.setColumns(10);
        panelAuthor.setBounds(39, 113, 349, 29);
        panelForms.add(panelAuthor);
        panelAuthor.setLayout(null);
        lblBookAuthor.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblBookAuthor.setBounds(6, 6, 94, 16);

        panelAuthor.add(lblBookAuthor);
        textFieldAuthorName.setColumns(10);
        textFieldAuthorName.setBounds(137, 1, 206, 26);

        panelAuthor.add(textFieldAuthorName);
        panelPrice.setBounds(39, 148, 349, 29);
        panelForms.add(panelPrice);
        panelPrice.setLayout(null);
        lblBookPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblBookPrice.setBounds(6, 6, 97, 16);

        panelPrice.add(lblBookPrice);
        textFieldPrice.setColumns(10);
        textFieldPrice.setBounds(137, 1, 206, 26);

        panelPrice.add(textFieldPrice);
        panelQuantity.setBounds(39, 183, 349, 29);

        panelForms.add(panelQuantity);
        panelQuantity.setLayout(null);
        lblBookQuantity.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblBookQuantity.setBounds(0, 5, 115, 16);
        panelQuantity.add(lblBookQuantity);
        textFieldQuantity.setBounds(138, 0, 205, 26);
        textFieldQuantity.setColumns(10);
        panelQuantity.add(textFieldQuantity);
        panelISBN.setBounds(39, 218, 349, 29);

        panelForms.add(panelISBN);
        panelISBN.setLayout(null);
        lblBookISBN.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblBookISBN.setBounds(0, 5, 84, 16);
        panelISBN.add(lblBookISBN);
        textFieldISBN.setBounds(137, 0, 206, 26);
        textFieldISBN.setColumns(10);
        panelISBN.add(textFieldISBN);
        panelBookName.setLayout(null);
        panelBookName.setBounds(39, 80, 349, 29);

        panelForms.add(panelBookName);
        lblBookName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblBookName.setBounds(6, 6, 94, 16);

        panelBookName.add(lblBookName);
        textFieldBookName.setColumns(10);
        textFieldBookName.setBounds(137, 1, 206, 26);

        panelBookName.add(textFieldBookName);
        panelProductID.setLayout(null);
        panelProductID.setBounds(39, 45, 349, 29);

        panelForms.add(panelProductID);
        lblProductID.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblProductID.setBounds(6, 6, 94, 16);

        panelProductID.add(lblProductID);
        textFieldProductID.setColumns(10);
        textFieldProductID.setBounds(137, 1, 206, 26);

        panelProductID.add(textFieldProductID);
        panelBookGenre.setLayout(null);
        panelBookGenre.setBounds(39, 288, 349, 29);
        panelForms.add(panelBookGenre);
        lblBookGenre.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblBookGenre.setBounds(6, 6, 110, 17);
        panelBookGenre.add(lblBookGenre);
        textFieldBookGenre.setColumns(10);
        textFieldBookGenre.setBounds(137, 1, 206, 26);

        panelBookGenre.add(textFieldBookGenre);
        btnBookEntryMainPage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainpage test = null;
                try {
                    test = new Mainpage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                test.setLocationRelativeTo(null);
            }

        });
        btnBookEntryMainPage.setBounds(100, 376, 117, 29);
        btnBookEntryMainPage.setFont(new java.awt.Font("Tahoma", 1, 14));

        panelNewBookEntry.add(btnBookEntryMainPage);

        tabbedPane.addTab("Delete Entry", null, panelDeleteAvailableBooks, null);
        panelDeleteAvailableBooks.setLayout(null);
        btnDelete.setForeground(new Color(255, 0, 0));
        btnDelete.setBackground(new Color(255, 51, 51));
        btnDelete.setBounds(311, 377, 117, 29);

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s_id         = textField.getText();
                String s_isbn       = textField.getText();
// int id double price, int stock)

                int p_id = Integer.parseInt(s_id);

                if (p_id <= 0 || !s_isbn.equals("") )
                {
                    JOptionPane.showMessageDialog(null, "One or more fields are empty.");
                }

                else{

                    try {
                        deleteEntryByBookID(p_id);
                        deleteEntryByBookISBN(s_isbn);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null, "Book successfully Deleted.");

                }

            }
        });



        panelDeleteAvailableBooks.add(btnDelete);
        panelDeleteProductByID.setLayout(null);
        panelDeleteProductByID.setBounds(99, 90, 349, 29);

        panelDeleteAvailableBooks.add(panelDeleteProductByID);
        lblByProductId.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblByProductId.setBounds(6, 6, 119, 16);

        panelDeleteProductByID.add(lblByProductId);
        textField.setColumns(10);
        textField.setBounds(137, 1, 206, 26);

        panelDeleteProductByID.add(textField);
        panelDeleteProductBookISBN.setLayout(null);
        panelDeleteProductBookISBN.setBounds(99, 125, 349, 29);

        panelDeleteAvailableBooks.add(panelDeleteProductBookISBN);
        lblByBookIsbn.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblByBookIsbn.setBounds(6, 6, 107, 16);

        panelDeleteProductBookISBN.add(lblByBookIsbn);
        textFieldDeleteProductByISBN.setColumns(10);
        textFieldDeleteProductByISBN.setBounds(137, 1, 206, 26);

        panelDeleteProductBookISBN.add(textFieldDeleteProductByISBN);
        lblBookDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblBookDelete.setBounds(196, 6, 159, 26);



        panelDeleteAvailableBooks.add(lblBookDelete);
        btnMainPageDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Mainpage test = null;
                try {
                    test = new Mainpage();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                test.setLocationRelativeTo(null);
            }
        });
        btnMainPageDelete.setBounds(100, 376, 117, 29);
        btnMainPageDelete.setFont(new java.awt.Font("Tahoma", 1, 14));

        panelDeleteAvailableBooks.add(btnMainPageDelete);





        setLocationRelativeTo(null);
        setVisible(true);
    }
}



