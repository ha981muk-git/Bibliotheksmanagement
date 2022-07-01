import GUI.*;

import javax.swing.*;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        Login app = new Login("Bookstore application");
        //ImageTest app = new ImageTest();
        app.setVisible(true);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
