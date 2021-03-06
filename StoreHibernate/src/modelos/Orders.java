package modelos;
// Generated Dec 2, 2018 9:45:08 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Orders generated by hbm2java
 */
public class Orders  implements java.io.Serializable {


     private Integer orderId;
     private Integer customers;
     private Integer employees;
     private String orderDate;
     private String requiredDate;
     private String shippedDate;
     private Integer shipVia;
     private Double freight;
     private String shipName;
     private String shipAddress;
     private String shipCity;
     private String shipRegion;
     private String shipPostalCode;
     private String shipCountry;

    public Orders() {
    }

    public Orders(Integer customers, Integer employees, String orderDate, String requiredDate, String shippedDate, Integer shipVia, Double freight, String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
       this.customers = customers;
       this.employees = employees;
       this.orderDate = orderDate;
       this.requiredDate = requiredDate;
       this.shippedDate = shippedDate;
       this.shipVia = shipVia;
       this.freight = freight;
       this.shipName = shipName;
       this.shipAddress = shipAddress;
       this.shipCity = shipCity;
       this.shipRegion = shipRegion;
       this.shipPostalCode = shipPostalCode;
       this.shipCountry = shipCountry;
    }
   
    public Integer getOrderId() {
        return this.orderId;
    }
    
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getCustomers() {
        return this.customers;
    }
    
    public void setCustomers(Integer customers) {
        this.customers = customers;
    }
    public Integer getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Integer employees) {
        this.employees = employees;
    }
    public String getOrderDate() {
        return this.orderDate;
    }
    
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    public String getRequiredDate() {
        return this.requiredDate;
    }
    
    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }
    public String getShippedDate() {
        return this.shippedDate;
    }
    
    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }
    public Integer getShipVia() {
        return this.shipVia;
    }
    
    public void setShipVia(Integer shipVia) {
        this.shipVia = shipVia;
    }
    public Double getFreight() {
        return this.freight;
    }
    
    public void setFreight(Double freight) {
        this.freight = freight;
    }
    public String getShipName() {
        return this.shipName;
    }
    
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public String getShipAddress() {
        return this.shipAddress;
    }
    
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
    public String getShipCity() {
        return this.shipCity;
    }
    
    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }
    public String getShipRegion() {
        return this.shipRegion;
    }
    
    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }
    public String getShipPostalCode() {
        return this.shipPostalCode;
    }
    
    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }
    public String getShipCountry() {
        return this.shipCountry;
    }
    
    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String toString(){
        return this.orderId+";"+this.customers+";"+this.employees+";"+this.orderDate+";"+this.requiredDate+";"+this.shippedDate+";"+this.shipVia+";"+this.freight+";"+this.shipName+";"+this.shipAddress+";"+this.shipCity+";"+this.shipRegion+";"+this.shipPostalCode+";"+this.shipCountry;
    }


}


