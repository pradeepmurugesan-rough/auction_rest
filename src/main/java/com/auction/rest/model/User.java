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
@Table(name = "user")
@ApiModel(description = "User")
public class User   {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    @Column(name = "name")
    @NotNull
    private String name = null;
    @Column(name = "location")
    @NotNull
    private String location = null;

    public User id(Long id) {
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


    public User name(String name) {
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

    public User location(String location) {
        this.location = location;
        return this;
    }


    @ApiModelProperty(value = "location of the user", required = true)
    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

