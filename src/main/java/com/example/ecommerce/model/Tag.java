package com.example.ecommerce.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tag")
public class Tag implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tag_name;

    public Tag(){

    }

    public Tag(Integer id, String tag_name){
        this.id = id;
        this.tag_name = tag_name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}
