package com.selvamani.recyclerviewmvp.Remote.Datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChildModel implements Serializable
{

    @SerializedName("_id")
    @Expose
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ChildModel withId(Integer id) {
        this.id = id;
        return this;
    }

}