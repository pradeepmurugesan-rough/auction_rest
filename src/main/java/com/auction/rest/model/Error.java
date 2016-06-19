package com.auction.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "Error Object")
public class Error   {

    private Integer code = null;
    private String message = null;
    private String fields = null;
    private List<ErrorListItem> details = new ArrayList<ErrorListItem>() ;

    public Error code(Integer code) {
        this.code = code;
        return this;
    }


    @ApiModelProperty(value = "")
    @JsonProperty("code")
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public Error message(String message) {
        this.message = message;
        return this;
    }


    @ApiModelProperty(value = "")
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Error fields(String fields) {
        this.fields = fields;
        return this;
    }


    @ApiModelProperty(value = "")
    @JsonProperty("fields")
    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    @ApiModelProperty(value = "")
    @JsonProperty("details")
    public List<ErrorListItem> getDetails() {
        return details;
    }

    public void setDetails(List<ErrorListItem> details) {
        this.details = details;
    }
}

