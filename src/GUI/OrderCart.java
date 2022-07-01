package GUI;

import Classes.Product;
import Helper.Cart;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class OrderCart extends javax.swing.JFrame{
    
    public OrderCart() throws IOException {


        BufferedImage buffered = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("paper.jpg"));
        BufferedImage buffered2 = ImageIO.read(Login.class.getClassLoader().getResourceAsStream("smooth.jpg"));

        final ImageIcon icon = new ImageIcon(buffered);
        final ImageIcon icon2 = new ImageIcon(buffered2);

        // Define background image panels
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
            final Image img = icon.getImage();
            // instance initializer
            {setOpaque(false);}
            public void paintComponent(Graphics graphics)
            {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };

        //region variable declaration
        ArrayList<JLabel> itemName = new ArrayList<>();
        ArrayList<JLabel> itemPrice = new ArrayList<>(); 
        ArrayList<JLabel> itemIsbn = new ArrayList<>();
        ArrayList<JLabel> itemAuthor = new ArrayList<>();
        ArrayList<JLabel> itemGenre = new ArrayList<>();
        ArrayList<JLabel> itemQuantity = new ArrayList<>();        
        ArrayList<JButton> removeProduct = new ArrayList<>();
        JLabel itemSection = new JLabel("Cart");
        JLabel productTitle = new JLabel("Title");
        JLabel productPrice = new JLabel("Price");
        JLabel productIsbn = new JLabel("ISBN");
        JLabel productAuthor = new JLabel("Author");
        JLabel productGenre = new JLabel("Genre");
        JLabel productQuantity = new JLabel("Quantity");
        JLabel cartTotalPriceText = new JLabel("Total Price");
        JTextField cartTotalPrice = new JTextField();
        JButton mainPage = new JButton("Mainpage");
        JButton cart = new JButton("Order");
        itemSection.setFont(new java.awt.Font("Tahoma", 1, 18));
        mainPage.setFont(new java.awt.Font("Tahoma", 1, 14));
        cartTotalPriceText.setFont(new java.awt.Font("Tahoma", 1, 14));
        cart.setFont(new java.awt.Font("Tahoma", 1, 14));

        jPanel1.setLocation(0,0);
        jPanel1.setSize(600,60);
        //jPanel1.add(Box.createVerticalStrut(70));
        add(jPanel1);

        jPanel2.setLocation(0,70);
        jPanel2.setSize(600,300);
        add(jPanel2);

        jPanel3.setLocation(0,320);
        jPanel3.setSize(600,50);
        add(jPanel3);

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
        cart.addActionListener(actionEvent -> {
            if(Cart.totalPrice == 0){
                JOptionPane.showMessageDialog(null, "You don't have any products in your cart");
            }else {
                dispose();
                ShippingAddress shippingAddress = null;
                try {
                    shippingAddress = new ShippingAddress();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                shippingAddress.setVisible(true);
                shippingAddress.setLocationRelativeTo(null);
            }
        });
        cartTotalPrice.setEditable(false);
        cartTotalPrice.setText(Cart.totalPrice + "$");
        if(Cart.cartProducts!=null) {
            for (Product test :
                    Cart.cartProducts) {
                removeProduct.add(new JButton("x"));
                itemName.add(new JLabel(test.getName()));
                itemPrice.add(new JLabel(test.getPriceFormatted()));
                itemIsbn.add(new JLabel(test.getIsbnFormatted()));
                itemAuthor.add(new JLabel(test.getAuthor()));
                itemGenre.add(new JLabel(test.getGenre()));
            }
            for (int quantityInt :
                    Cart.cartProductQuantity) {
                JLabel quantity = new JLabel();
                quantity.setText(String.valueOf(quantityInt));
                itemQuantity.add(quantity);
            }
        }

        for (int i = 0; i < removeProduct.size(); i++) {
            int finalI = i;
            removeProduct.get(i).addActionListener(actionEvent -> {
                Cart.removeProductFromCart(finalI);
                dispose();
                try {
                    new OrderCart();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        GroupLayout groupLayouttop = new GroupLayout(jPanel1);
        GroupLayout groupLayoutmid = new GroupLayout(jPanel2);

        groupLayoutmid.setAutoCreateGaps(true);
        groupLayoutmid.setAutoCreateContainerGaps(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GroupLayout.ParallelGroup itemCollection = groupLayoutmid.createParallelGroup();
        itemCollection.addComponent(productTitle);
        for (JLabel test :
                itemName) {
            itemCollection.addComponent(test);
        }

        GroupLayout.ParallelGroup priceCollection = groupLayoutmid.createParallelGroup();
        priceCollection.addComponent(productPrice);
        for (JLabel test :
                itemPrice) {
            priceCollection.addComponent(test);
        }
        
        GroupLayout.ParallelGroup isbnCollection = groupLayoutmid.createParallelGroup();
        isbnCollection.addComponent(productIsbn);
        for (JLabel test :
                itemIsbn) {
            isbnCollection.addComponent(test);
        }
        
        GroupLayout.ParallelGroup authorCollection = groupLayoutmid.createParallelGroup();
        authorCollection.addComponent(productAuthor);
        for (JLabel test :
                itemAuthor) {
            authorCollection.addComponent(test);
        }
        
        GroupLayout.ParallelGroup genreCollection = groupLayoutmid.createParallelGroup();
        genreCollection.addComponent(productGenre);
        for (JLabel test :
                itemGenre) {
            genreCollection.addComponent(test);
        }
        
        GroupLayout.ParallelGroup quantityCollection = groupLayoutmid.createParallelGroup();
        quantityCollection.addComponent(productQuantity);
        for (JLabel test :
                itemQuantity) {
            quantityCollection.addComponent(test);
        }

        GroupLayout.ParallelGroup verticalGrouptop = groupLayouttop.createParallelGroup(GroupLayout.Alignment.CENTER);
        verticalGrouptop.addGap(80);
        verticalGrouptop.addComponent(itemSection);

        GroupLayout.ParallelGroup removeButtonCollection = groupLayoutmid.createParallelGroup();
        for (JButton test :
                removeProduct) {
            removeButtonCollection.addComponent(test);
        }

        GroupLayout.SequentialGroup verticalGroup = groupLayoutmid.createSequentialGroup();

        verticalGroup.addGroup(groupLayoutmid.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(productTitle)
                .addComponent(productPrice)
                .addComponent(productIsbn)
                .addComponent(productAuthor)
                .addComponent(productGenre)
                .addComponent(productQuantity));

        for (int i = 0; i < itemPrice.size(); i++) {
            verticalGroup.addGroup(groupLayoutmid.createParallelGroup()
                    .addComponent(itemName.get(i))
                    .addComponent(itemPrice.get(i))
                    .addComponent(itemIsbn.get(i))
                    .addComponent(itemAuthor.get(i))
                    .addComponent(itemGenre.get(i))
                    .addComponent(itemQuantity.get(i))
                    .addComponent(removeProduct.get(i)));
        }
        verticalGroup.addGroup(groupLayoutmid.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(cartTotalPriceText)
                .addComponent(cartTotalPrice));
        verticalGroup.addGroup(groupLayoutmid.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(mainPage)
                .addComponent(cart));

        jPanel1.setLayout(groupLayouttop);
        jPanel2.setLayout(groupLayoutmid);

        groupLayouttop.setHorizontalGroup(
                groupLayouttop.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGap(570)
                        .addComponent(itemSection)
        );

        groupLayoutmid.setHorizontalGroup(
                groupLayoutmid.createSequentialGroup()
                        .addGroup(itemCollection.addComponent(mainPage))
                        .addGroup(priceCollection)
                        .addGroup(isbnCollection)
                        .addGroup(authorCollection)
                        .addGroup(genreCollection)
                        .addGroup(quantityCollection
                                .addComponent(cartTotalPriceText))
                        .addGroup(removeButtonCollection
                                .addComponent(cartTotalPrice)
                                .addComponent(cart))
        );
        groupLayoutmid.setVerticalGroup(
                verticalGroup
        );

        groupLayouttop.setVerticalGroup(verticalGrouptop);

        this.setSize(600, 500);
        this.getContentPane().setBackground(Color.black);

        //pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
