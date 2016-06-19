package com.auction.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bid")
@ApiModel(description = "Bid")
public class Bid   {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(name = "auctionId")
    @NotNull private Long auctionId = null;
    @Column(name = "userId")
    @NotNull private Long userId = null;
    @Column(name = "price")
    @NotNull private Double price = null;

    @Transient
    private User user;

    public Bid id(Long id) {
        this.id = id;
        return this;
    }


    @ApiModelProperty(value = "Unique identifier representing a specific item")
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Bid auctionId(Long auctionId) {
        this.auctionId = auctionId;
        return this;
    }


    @ApiModelProperty(required = true, value = "bid to which the auction belongs to")
    @JsonProperty("auctionId")
    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }


    public Bid userId(Long userId) {
        this.userId = userId;
        return this;
    }


    @ApiModelProperty(required = true, value = "user associated with the bid")
    @JsonProperty("userId")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    @ApiModelProperty(required = true, value = "price associated with the bid")
    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @ApiModelProperty(value = "user associated with the bid")
    @JsonProperty("user")

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

