package main.java;

import static java.lang.String.format;
import static main.java.User.orderNotifications.getOrderNotificationsBySellerID;
import static main.java.User.productsList.getProductsListBySellerID;
import static main.java.User.transactionsHistory.getTransactionsHistoryBySellerID;

public class User {



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
       StoredDB[] products = getProductsListBySellerID(3);  //passed
       for (StoredDB i : getProductsListBySellerID(3))
       System.out.println(i);
     
 //NOT PASSED LINE 157  StoredDB[] transactionshistory = getTransactionsHistoryBySellerID(1);
  //    for (StoredDB i : getTransactionsHistoryBySellerID(1))
   //     System.out.println(i);
      
  //NOT PASSED LINE 238 PROBLEM   StoredDB[] orderNotifications = getOrderNotificationsBySellerID(2);  
    //   for (StoredDB i : getOrderNotificationsBySellerID(2))
   //    System.out.println(i);
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

class transactionsHistory extends StoredDB {
    private int sellerID,userID,orderID;
    private double profit;
    
    public transactionsHistory() {
        sellerID = 0;
        userID = 0;
        orderID = 0;
        profit = 0.0;
    }

        public int getSellerID() {
            return sellerID;
        }

        public int getUserID() {
            return userID;
        }

        public int getOrderID() {
            return orderID;
        }

        public double getProfit() {
            return profit;
        }
    
     @Override
        public String toString() {
            String details = "Seller ID : " + sellerID;
            details = details + "\nUser ID : " + userID;
            details = details + "\nOrder ID :  " + orderID;
            details = details + "\nProfit : " + profit;
        return details;
             
        }
        
        public static StoredDB[] getTransactionsHistoryBySellerID(int sellerID) {
           String query = String.format("SELECT * FROM TransactionsHistory " +
                        "WHERE sellerID = '%d'",
                         sellerID);
           
            return Database.getDBObjects(query, transactionsHistory.class, -1); //transactionsHistory.class problem
        }
        
        
        public static String getPrimaryKey() {
        return "sellerID";
    }

        @Override
        public String insertQuery() {
            return String.format("INSERT INTO " + "TransactionsHistory (sellerID, userID, orderID, profit)" + 
                                 "VALUES ('%d', '%d','%d','%f)", sellerID, userID, orderID, profit);
        }

        @Override
        public String updateQuery() {
            return String.format("UPDATE Product " + "SET orderID ='%d', userID='%d', profit = '%f'" +
                                "WHERE sellerID = %d", orderID, userID, profit, sellerID);
        }

        @Override
        public String deleteQuery() {
            return "DELETE FROM TransactionsHistory " + "WHERE sellerID = "+ sellerID;
        }
        


}

class orderNotifications extends StoredDB {
    private int orderID,productID,userID,sellerID,orderQuantity;
    private String shippingAddress;
    
    public orderNotifications() {
        orderID = 0;
        productID = 0;
        userID = 0;
        sellerID = 0;
        orderQuantity = 0;
        shippingAddress = "";
    }

        public int getOrderID() {
            return orderID;
        }

        public int getProductID() {
            return productID;
        }

        public int getUserID() {
            return userID;
        }

        public int getSellerID() {
            return sellerID;
        }

        public int getOrderQuantity() {
            return orderQuantity;
        }

        public String getShippingAddress() {
            return shippingAddress;
        }
        @Override
        public String toString() {
            String details = "\nOrder Notifications~\nOrder ID : " + orderID;
            details = details + "\nUser ID : " + userID;
            details = details + "\nProduct ID :  " + productID;
            details = details + "\nOrder Quantity : " + orderQuantity;
            details = details + "\nShipping Address : " + shippingAddress;
        return details;
             
        }
        
        public static StoredDB[] getOrderNotificationsBySellerID(int sellerID) {
           String query = String.format("SELECT * FROM Orderr " +
                        "WHERE sellerID = '%d'",
                         sellerID);
           
            return Database.getDBObjects(query, orderNotifications.class, -1); //orderNotifications.class problem
        }
        
        public static String getPrimaryKey() {
        return "sellerID";
    }

        @Override
        public String insertQuery() {
            return String.format("INSERT INTO " + " Orderr (orderID, orderID, productID, orderQuantity, shippingAddress)" + 
                                 "VALUES ('%d', '%d','%d','%d', '%s)", orderID, userID, productID, orderQuantity, shippingAddress);
        }

        @Override
        public String updateQuery() {
            return String.format("UPDATE Orderr " + "SET orderID ='%d', orderID='%d', productID = '%d', orderQuantity = '%d', shippingAddress = '%s'" +
                                "WHERE sellerID = %d", orderID, orderID, productID, orderQuantity, shippingAddress);
        }

        @Override
        public String deleteQuery() {
            return "DELETE FROM Orderr " + "WHERE sellerID = "+ sellerID;
        }
        
        
    
    
}
}
