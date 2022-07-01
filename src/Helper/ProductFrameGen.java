package Helper;


import Database.ProductService;
import Database.UserService;
import GUI.Login;
import GUI.Mainpage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductFrameGen extends javax.swing.JFrame{
    
    public ProductFrameGen(String guiName) throws SQLException, IOException {


        BufferedImage buffered = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("paper.jpg"));
        BufferedImage buffered2 = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("smooth.jpg"));
        BufferedImage buffered3 = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("paper.jpg"));

        final ImageIcon icon = new ImageIcon(buffered);
        final ImageIcon icon2 = new ImageIcon(buffered2);
        final ImageIcon icon3 = new ImageIcon(buffered3);

        JPanel jPanel1 = new JPanel(){ // added background image
            final Image img = icon.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        JPanel jPanel2 = new JPanel(){ // added background image
            final Image img = icon2.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        JPanel jPanel3 = new JPanel(){ // added background image
            final Image img = icon3.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };


        final ProductService products = new ProductService(guiName);
        ArrayList<JLabel> itemName = new ArrayList<>();
        ArrayList<JLabel> itemPrice = new ArrayList<>();
        ArrayList<JLabel> itemIsbn = new ArrayList<>();
        ArrayList<JLabel> itemAuthor = new ArrayList<>();
        ArrayList<JLabel> itemGenre = new ArrayList<>();
        ArrayList<JComboBox> itemQuantity = new ArrayList<>();
        JLabel itemSection = new JLabel(guiName);
        JLabel cartTotalPriceText = new JLabel("Total Price");
        JButton mainPage = new JButton("Mainpage");
        JButton cart = new JButton("Add to Cart");
        JTextField cartTotalPrice = new JTextField();
        cart.addActionListener(actionEvent -> {
            if(Cart.currentPrice == 0){
                JOptionPane.showMessageDialog(null, "You didn't add any products to your cart");
            }else {
                for (int i = 0; i < itemName.size(); i++) {
                    if (itemQuantity.get(i).getSelectedIndex() != 0) {
                        Cart.addProductToCart(products.getProducts().get(i), itemQuantity.get(i).getSelectedIndex());
                    }
                }
                Cart.totalPrice += Cart.currentPrice;
                System.out.println("Your total price is: " + Cart.totalPrice);
                JOptionPane.showMessageDialog(null, "Your products got added to the cart");
            }
        });
        itemSection.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18));
        mainPage.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        cart.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        cartTotalPriceText.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
        cartTotalPrice.setEditable(false);
        cartTotalPrice.setText(Cart.currentPrice + "$");
        mainPage.addActionListener(actionEvent -> {
            dispose();
            Mainpage test = null;
            try {
                test = new Mainpage();
            } catch (IOException e) {
                e.printStackTrace();
            }
            test.setLocationRelativeTo(null);
        });

        for (int i = 0; i < products.getProducts().size(); i ++) {
            itemName.add(new JLabel());
            itemName.get(i).setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
            itemName.get(i).setText(products.getProducts().get(i).getName());
            itemPrice.add(new JLabel());
            itemPrice.get(i).setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
            itemPrice.get(i).setText(products.getProducts().get(i).getPriceFormatted());
            itemIsbn.add(new JLabel());
            itemIsbn.get(i).setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
            itemIsbn.get(i).setText(products.getProducts().get(i).getIsbnFormatted());
            itemAuthor.add(new JLabel());
            itemAuthor.get(i).setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
            itemAuthor.get(i).setText(products.getProducts().get(i).getAuthor());
            itemGenre.add(new JLabel());
            itemGenre.get(i).setFont(new java.awt.Font("Tahoma", Font.BOLD, 14));
            itemGenre.get(i).setText(products.getProducts().get(i).getGenre());
            itemQuantity.add(new JComboBox());
            itemQuantity.get(i).setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));
            int finalI = i;
            itemQuantity.get(i).addItemListener(itemEvent -> {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED){
                    try {
                        itemQuantity.get(finalI).setSelectedIndex(ProductService.checkQuantity(products.getProducts().get(finalI) ,itemQuantity.get(finalI).getSelectedIndex()));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    Cart.currentPrice = Cart.calculatePrice(itemQuantity, products.getProducts());
                    cartTotalPrice.setText(Cart.currentPrice + "$");
                    System.out.println("The current price is: " + Cart.currentPrice);
                }
            });

        }


        //JPanel frame = new JPanel();
        //getContentPane().setBackground(new java.awt.Color(231, 246, 255));
        GroupLayout groupLayout = new GroupLayout(jPanel2);
        jPanel1.setLocation(0,0);
        jPanel1.setSize(600,60);
        jPanel1.add(Box.createVerticalStrut(70));
        jPanel1.add(itemSection);
        add(jPanel1);

        jPanel2.setLocation(0,70);
        jPanel2.setSize(600,300);
        jPanel2.setLayout(groupLayout);
        add(jPanel2);

        jPanel3.setLocation(0,320);
        jPanel3.setSize(600,50);
        //jPanel3.setLayout(null);
        add(jPanel3);

        //getContentPane().setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupLayout.ParallelGroup itemCollection = groupLayout.createParallelGroup();
        for (JLabel test :
                itemName) {
            itemCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup priceCollection = groupLayout.createParallelGroup();
        for (JLabel test :
                itemPrice) {
            priceCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup isbnCollection = groupLayout.createParallelGroup();
        for (JLabel test :
                itemIsbn) {
            isbnCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup authorCollection = groupLayout.createParallelGroup();
        for (JLabel test :
                itemAuthor) {
            authorCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup genreCollection = groupLayout.createParallelGroup();
        for (JLabel test :
                itemGenre) {
            genreCollection.addComponent(test);

        }
        GroupLayout.ParallelGroup quantityCollection = groupLayout.createParallelGroup();
        for (JComboBox test :
                itemQuantity) {
            quantityCollection.addComponent(test);
            test.setPreferredSize(new Dimension());

        }


        GroupLayout.SequentialGroup verticalGroup = groupLayout.createSequentialGroup();
        //verticalGroup.addComponent(itemSection);
        for (int i = 0; i < itemPrice.size(); i++) {
            verticalGroup.addGroup(groupLayout.createParallelGroup()
                    .addComponent(itemName.get(i))
                    .addComponent(itemPrice.get(i))
                    .addComponent(itemIsbn.get(i))
                    .addComponent(itemAuthor.get(i))
                    .addComponent(itemGenre.get(i))
                    .addComponent(itemQuantity.get(i),
                            GroupLayout.DEFAULT_SIZE,
                            GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE));

        }
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cartTotalPriceText)
                .addComponent(cartTotalPrice));
        verticalGroup.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(mainPage)
                .addComponent(cart));

        groupLayout.setHorizontalGroup(
                groupLayout.createSequentialGroup()
                        .addGroup(itemCollection.addComponent(mainPage))
                        .addGroup(priceCollection
                                .addComponent(cartTotalPriceText))
                        .addGroup(isbnCollection)
                        .addGroup(authorCollection)
                        .addGroup(genreCollection)
                        .addGroup(quantityCollection
                                .addComponent(cartTotalPrice)
                                .addComponent(cart))
        );
        groupLayout.setVerticalGroup(
                verticalGroup
        );
        //pack();

        setSize(615, 500);
        this.getContentPane().setBackground(Color.black);
        setVisible(true);
        setLocationRelativeTo(null);
        setVisible(true);
        validate();
    }



    @Override
    public void dispose() {
        System.out.println("Your total price is: " + Cart.totalPrice);
        Cart.currentPrice = 0;
        super.dispose();
    }
}
