/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.audio.entity;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author LENOVO
 */
public class Piste {
    
    private int id;
    private String name;
    private String author;
    private Date dateOfCreation;
    private Date dateOfLastMod;
    private String link;
    public Piste(){
        
    }
    public Piste(int id, String name,  String link){
        this(id, name,null,null,link);
    }
    public Piste( int id, String name, Date dateOfCreation, Date dateOfLastMod, String link){
        this(id, name, null, dateOfCreation, dateOfLastMod,link);
    }
    public Piste( int id, String name, String author, Date dateOfCreation, Date dateOfLastMod, String link) {
        this.name = name;
        this.author= author;
        this.dateOfCreation = dateOfCreation;
        this.dateOfLastMod = dateOfLastMod;
        this.link = link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Piste && ((Piste)obj).getLink().equals(this.link) ;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfLastMod(Date dateOfLastMod) {
        this.dateOfLastMod = dateOfLastMod;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfLastMod() {
        return dateOfLastMod;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.link);
        return hash; 
    }

    @Override
    public String toString() {
        return "name: " + name + "\nauthor: " + author + "\ndateOfCreation" + dateOfCreation + "\ndateOfLastMod: " + dateOfLastMod +"\nlink: "+ link; //To change body of generated methods, choose Tools | Templates.
    }
    
}
