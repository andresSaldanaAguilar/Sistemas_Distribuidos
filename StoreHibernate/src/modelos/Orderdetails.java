package modelos;
// Generated Dec 2, 2018 9:45:08 PM by Hibernate Tools 4.3.1



/**
 * Orderdetails generated by hbm2java
 */
public class Orderdetails  implements java.io.Serializable {


     private Integer orderDetailsId;
     private Integer orders;
     private Integer products;
     private Double unitPrice;
     private Integer quantity;
     private Double discount;

    public Orderdetails() {
    }

    public Orderdetails(Integer orders, Integer products, Double unitPrice, Integer quantity, Double discount) {
       this.orders = orders;
       this.products = products;
       this.unitPrice = unitPrice;
       this.quantity = quantity;
       this.discount = discount;
    }
   
    public Integer getOrderDetailsId() {
        return this.orderDetailsId;
    }
    
    public void setOrderDetailsId(Integer orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }
    public Integer getOrders() {
        return this.orders;
    }
    
    public void setOrders(Integer orders) {
        this.orders = orders;
    }
    public Integer getProducts() {
        return this.products;
    }
    
    public void setProducts(Integer products) {
        this.products = products;
    }
    public Double getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Integer getQuantity() {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getDiscount() {
        return this.discount;
    }
    
    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String toString(){
        return this.orderDetailsId+";"+this.orders+";"+this.products+";"+this.unitPrice+";"+this.quantity+";"+this.quantity+";"+this.discount;
    }


}


