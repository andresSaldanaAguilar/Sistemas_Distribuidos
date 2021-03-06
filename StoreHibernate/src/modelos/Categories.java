package modelos;
// Generated Dec 2, 2018 9:45:08 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Categories generated by hbm2java
 */
public class Categories  implements java.io.Serializable {


     private Integer categoryId;
     private String categoryName;
     private String description;
     private String picture;

    public Categories() {
    }

    public Categories(String categoryName, String description, String picture) {
       this.categoryName = categoryName;
       this.description = description;
       this.picture = picture;
    }
   
    public Integer getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPicture() {
        return this.picture;
    }
    
    public void setPicture(String picture) {
        this.picture = picture;
    }

     @Override
    public String toString(){
        return this.categoryName+";"+this.description+";"+this.picture;
    }

}


