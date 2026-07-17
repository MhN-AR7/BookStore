package ir.maktabsharif.model;

public class Book extends BaseModel<Integer> {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException();
        else this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "[ID: %d | Title: %s | Author: %s | Price: $%.2f]",
                this.getId(),title, author, price
        );
    }
}
