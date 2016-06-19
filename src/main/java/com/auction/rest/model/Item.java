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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "item")
@ApiModel(description = "Item")
public class Item   {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(name = "name")
    @NotNull
    private String name = null;
    @Column(name = "description")
    @NotNull
    private String description = null;
    @Column(name = "startingPrice")
    @NotNull
    private Double startingPrice = null;


    public Item id(Long id) {
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

    public Item name(String name) {
        this.name = name;
        return this;
    }


    @ApiModelProperty(value = "name of the item", required = true)
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Item description(String description) {
        this.description = description;
        return this;
    }


    @ApiModelProperty(value = "description about the item", required = true)
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Item startingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
        return this;
    }


    @ApiModelProperty(value = "starting price ofthe article", required = true)
    @JsonProperty("startingPrice")
    public Double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
    }

}

