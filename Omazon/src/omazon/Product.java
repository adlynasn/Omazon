/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package omazon;


public class Product {

    private String productName = "faster do project";
    private String category;
    private String description;
    private double price;
    private int stockCount;
    private String productRatings;
    private int salesCount;
    private String[] reviews;
    private boolean bestSelling;
    
    public Product() {
        productName = "";
        category = "";
        description = "";
        price = 0.0;
        stockCount = 0;
        productRatings = "";
        salesCount = 0;
        reviews = new String[10];
    }
    public Product (String productName, String category, String description, double price, int stockCount, int salesCount, String[] reviews) {
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.price = price;
        this.stockCount = stockCount;
        this.salesCount = salesCount;
        this.reviews = reviews;
    }
    // Accessor
    public String getProductName() {
        return productName;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public int getStockCount() {
        return stockCount;
    }
    public int getSalesCount() {
        return salesCount;
    }
    public String getProductRatings() {
        return productRatings;
    }
    public String[] getReviews() {
        return reviews;
    }
    public boolean isBestSelling() {
        return bestSelling;
    }
    // Mutator
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setDecsription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
    public void setSalesCount(int salesCount) {
        this.salesCount = salesCount;
    }
    public void setProductRatings(String productRatings) {
        this.productRatings = productRatings;
    }
    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }
    public void setBestSelling(boolean bestSelling) {
        this.bestSelling = bestSelling;
    }
    @Override
    public String toString() {
        String details = "Product name:" + productName;
        details = details + "\nPrice: " + price;
        details = details + "\nStock: " + stockCount;
        details = details + "\nSales: " + salesCount;
        details = details + "\nProduct ratings: " + productRatings;
        details = details + "\nDescription: " + description;
        details = details + "\nProduct reviews: " + reviews;
        return details;
    }
    public static void main(String[] args) {
        
    }
}
