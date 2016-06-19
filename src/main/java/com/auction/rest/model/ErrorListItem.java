package com.auction.rest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(description = "")
public class ErrorListItem {

    private String message = null;
    private String path = null;
    private String invalidValue = null;

    @ApiModelProperty(required = true, value = "")
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @ApiModelProperty(required = true, value = "Description about individual errors occored")
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public String getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(String invalidValue) {
        this.invalidValue = invalidValue;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
