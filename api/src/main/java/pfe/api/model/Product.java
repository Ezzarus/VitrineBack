package pfe.api.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    private int id;
    private String name;
    private String description;
    private String EN_Description;
    private float maxPrice;
    private float price;
    private float USDPrice;
    private int stock;
    private String event;

    public Product() {
    }

    public Product(int id, String name, String description, String EN_Description, float maxPrice, float price, int stock, String event) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.EN_Description = EN_Description;
        this.maxPrice = maxPrice;
        this.price = price;
        this.stock = stock;
        this.event = event;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEN_Description() {
        return EN_Description;
    }

    public void setEN_Description(String EN_Description) {
        this.EN_Description = EN_Description;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public float getPrice() {
        return price;
    }

    public float getUSDPrice() {
        return USDPrice;
    }

    public void setUSDPrice(float USDPrice) {
        this.USDPrice = USDPrice;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

}