package main.java;

import static java.lang.String.format;
import static main.java.User.productsList.getProductsListBySellerID;

public class User{

    private String username;
    private String email;
    private String password;

    // Customer aspect
    private double balance;
    private Product[] cartProduct;
    private String[] orderHistory;
    private String paymentPassword;

    // Seller
    private double profit;
    private Product[] productsList;
    private String[] transactionsHistory;
    private String[] orderNotifications;
    
    public static void main(String[] args) {
       StoredDB[] products = getProductsListBySellerID(1);
       for (StoredDB i : getProductsListBySellerID(1))
           System.out.println(i);
}
    
class productsList extends StoredDB {
    private int productID,stock, sellerID;
    private double price;
    private String productName;
    
    public productsList() {
        productID = 0;
        productName = "";
        price = 0.0;
        stock = 0;   
    }

        public int getProductID() {
            return productID;
        }

        public int getStock() {
            return stock;
        }

        public int getSellerID() {
            return sellerID;
        }

        public double getPrice() {
            return price;
        }

        public String getProductName() {
            return productName;
        }
        
        @Override
        public String toString() {
            String details = "Product Name : " + productName;
            details = details + "\nPrice : " + price;
            details = details + "\nStock :  " + stock;
            details = details + "\nProductID : " + productID;
        return details;
             
        }
        
        public static StoredDB[] getProductsListBySellerID(int sellerID) {
           String query = String.format("SELECT * FROM Product " +
                        "WHERE sellerID = '%d'",
                         sellerID);
           
            return Database.getDBObjects(query, Product.class, -1);
        }
        
        public static String getPrimaryKey() {
        return "sellerID";
    }
    

        @Override
        public String insertQuery() {
            return String.format("INSERT INTO " + "Product (productId, productName, stock, price)" + 
                                 "VALUES ('%d', '%s','%d','%f)", productID, productName,stock,price);
        }

        @Override
        public String updateQuery() {
            return String.format("UPDATE Product " + "SET productName ='%s', stock='%d', price = '%f'" +
                                "WHERE productID = %d", productName, stock,price, productID);
        }

        @Override
        public String deleteQuery() {
            return "DELETE FROM Product " + "WHERE ProductID = "+ productID;
        } 
}
}

