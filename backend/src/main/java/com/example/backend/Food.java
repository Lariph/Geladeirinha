package com.example.backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quant")
    private int quant; 


    public Food(){
        super();
    }
    public void setId(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public Food(int quant, String name) {
        super();
        this.name = name;
        this.quant = quant;
    }

    public String getName() {
        return name;
    }

    public int getQuant() {
        return quant;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    @Override
    public String toString() {
        return "Food [name=" + name + ", quant=" + quant + "]";
    }
    
}