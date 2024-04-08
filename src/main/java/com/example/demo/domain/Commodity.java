package com.example.demo.domain;


import jakarta.persistence.*;

@Table(name= "Commodity")
@Entity
public class Commodity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Commodity_id;

    String Commodity_name;

    String Commodity_price;

    String Commodity_description;


    Long Commodity_number;




    public Long getCommodity_id() {
        return Commodity_id;
    }

    public void setCommodity_id(Long commodity_id) {
        Commodity_id = commodity_id;
    }

    public String getCommodity_name() {
        return Commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        Commodity_name = commodity_name;
    }

    public String getCommodity_price() {
        return Commodity_price;
    }

    public void setCommodity_price(String commodity_price) {
        Commodity_price = commodity_price;
    }

    public String getCommodity_description() {
        return Commodity_description;
    }

    public void setCommodity_description(String commodity_description) {
        Commodity_description = commodity_description;
    }

}
