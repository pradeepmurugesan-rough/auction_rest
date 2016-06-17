package com.auction.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auction")
@ApiModel(description = "Auction")
public class Auction   {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(name = "itemId")
    private Long itemId = null;
    @Column(name = "channel")
    private String channel = null;
    @Column(name = "isLive")
    private Boolean isLive = null;
    @Column(name = "highestBid")
    private Double highestBid = null;

    public Auction id(Long id) {
        this.id = id;
        return this;
    }


    @ApiModelProperty(value = "Unique identifier representing a specific auction")
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Auction itemId(Long itemId) {
        this.itemId = itemId;
        return this;
    }


    @ApiModelProperty(value = "Item reference")
    @JsonProperty("itemId")
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Auction channel(String channel) {
        this.channel = channel;
        return this;
    }


    @ApiModelProperty(value = "name of the channel")
    @JsonProperty("channel")
    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Auction isLive(Boolean isLive) {
        this.isLive = isLive;
        return this;
    }


    @ApiModelProperty(value = "whether the auction is live now")
    @JsonProperty("isLive")
    public Boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(Boolean isLive) {
        this.isLive = isLive;
    }


    public Auction highestBid(Double highestBid) {
        this.highestBid = highestBid;
        return this;
    }


    @ApiModelProperty(value = "highest bid of the auction")
    @JsonProperty("highestBid")
    public Double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Double highestBid) {
        this.highestBid = highestBid;
    }
}

