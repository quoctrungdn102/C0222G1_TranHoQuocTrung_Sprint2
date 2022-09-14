package com.example.demo.model.product;

import com.example.demo.model.category.Category;
import com.example.demo.model.coupon.Coupon;
import com.example.demo.model.order.Cart;
import com.example.demo.model.promotion.Promotion;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "is_deleted")
    private int isDelete;
    @Column(name = "name")
    private String name;
    @Column(name = "cpu")
    private String cpu;
    @Column(name = "ram")
    private String ram;
    @Column(name = "screen_resolution")
    private String screenResolution;
    @Column(name = "release_time")
    private String releaseTime;
    @Column(name = "graphic_card")
    private String graphicCard;
    @Column(name = "price")
    private double price;
    @Column(name = "description", columnDefinition = "varchar(1000)")
    private String description;
    @Column(name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "promotion_id", referencedColumnName = "id")
    private Promotion promotion;

    @OneToMany(mappedBy = "product")
    @JsonBackReference("product")
    private Set<Coupon> couponSet;

    @OneToMany(mappedBy = "product")
    @JsonBackReference("product1")
    private Set<Cart> cartSet;





    public Product() {
    }

    public Product(Integer id, int isDelete, String name, String cpu, String ram, String screenResolution, String releaseTime, String graphicCard, double price, String description, String image, Category category, Promotion promotion, Set<Coupon> couponSet, Set<Cart> cartSet) {
        this.id = id;
        this.isDelete = isDelete;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.screenResolution = screenResolution;
        this.releaseTime = releaseTime;
        this.graphicCard = graphicCard;
        this.price = price;
        this.description = description;
        this.image = image;
        this.category = category;
        this.promotion = promotion;
        this.couponSet = couponSet;
        this.cartSet = cartSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Set<Coupon> getCouponSet() {
        return couponSet;
    }

    public void setCouponSet(Set<Coupon> couponSet) {
        this.couponSet = couponSet;
    }

    public Set<Cart> getCartSet() {
        return cartSet;
    }

    public void setCartSet(Set<Cart> cartSet) {
        this.cartSet = cartSet;
    }
}
