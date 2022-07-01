package Classes;
public class Product {
    private String name="Null", isbn="Null",  author="Null", genre="Null";
    private double price;
    private int id, stock=0,type=0;

    public Product(int id, String name, double price, int stock, int type,String isbn, String author, String genre){
        this.id = id;
        this.name = name;
        this.price = price;
        this.isbn = isbn;
        this.author = author;
        this.genre = genre;
        this.stock = stock;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceFormatted() {
        return price + "$";
    }
    
    public String getName() {
        return name;
    }
  
    public String getAuthor() {
        return author;
    }
    
    public String getGenre() {
        return genre;
    }
        
    public String getIsbn() {
        return isbn;
    }
    
    public String getIsbnFormatted() {
        return isbn + "";
    }

    public int getStock() {
        return stock;
    }

    public int getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setType(int type) {
        this.type = type;
    }
}
