package com.selvamani.recyclerviewmvp.Remote.Datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ParentModel implements Serializable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("childarray")
    @Expose
    private List<ChildModel> childarray = null;
    private final static long serialVersionUID = 6001245795059844981L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ParentModel withId(Integer id) {
        this.id = id;
        return this;
    }

    public List<ChildModel> getChildarray() {
        return childarray;
    }

    public void setChildarray(List<ChildModel> childarray) {
        this.childarray = childarray;
    }

    public ParentModel withChildarray(List<ChildModel> childarray) {
        this.childarray = childarray;
        return this;
    }

}