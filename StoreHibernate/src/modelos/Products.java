package modelos;
// Generated Dec 2, 2018 9:45:08 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Products generated by hbm2java
 */
public class Products  implements java.io.Serializable {


     private Integer productId;
     private Integer categories;
     private Integer suppliers;
     private String productName;
     private String quantityPerUnity;
     private Double unitPrice;
     private Integer unitInStock;
     private Integer unitsOnOrder;
     private Integer reorderLevel;
     private Integer discontinued;

    public Products() {
    }

    public Products(Integer categories, Integer suppliers, String productName, String quantityPerUnity, Double unitPrice, Integer unitInStock, Integer unitsOnOrder, Integer reorderLevel, Integer discontinued) {
       this.categories = categories;
       this.suppliers = suppliers;
       this.productName = productName;
       this.quantityPerUnity = quantityPerUnity;
       this.unitPrice = unitPrice;
       this.unitInStock = unitInStock;
       this.unitsOnOrder = unitsOnOrder;
       this.reorderLevel = reorderLevel;
       this.discontinued = discontinued;
    }
   
    public Integer getProductId() {
        return this.productId;
    }
    
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getCategories() {
        return this.categories;
    }
    
    public void setCategories(Integer categories) {
        this.categories = categories;
    }
    public Integer getSuppliers() {
        return this.suppliers;
    }
    
    public void setSuppliers(Integer suppliers) {
        this.suppliers = suppliers;
    }
    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getQuantityPerUnity() {
        return this.quantityPerUnity;
    }
    
    public void setQuantityPerUnity(String quantityPerUnity) {
        this.quantityPerUnity = quantityPerUnity;
    }
    public Double getUnitPrice() {
        return this.unitPrice;
    }
    
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public Integer getUnitInStock() {
        return this.unitInStock;
    }
    
    public void setUnitInStock(Integer unitInStock) {
        this.unitInStock = unitInStock;
    }
    public Integer getUnitsOnOrder() {
        return this.unitsOnOrder;
    }
    
    public void setUnitsOnOrder(Integer unitsOnOrder) {
        this.unitsOnOrder = unitsOnOrder;
    }
    public Integer getReorderLevel() {
        return this.reorderLevel;
    }
    
    public void setReorderLevel(Integer reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
    public Integer getDiscontinued() {
        return this.discontinued;
    }
    
    public void setDiscontinued(Integer discontinued) {
        this.discontinued = discontinued;
    }


}


