/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.audio.dao;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface Idao<T> {
    public boolean insert(T o);
    public boolean delete(T o);
    public boolean mod(T o);
    public List<T> displayAll();
    public T displayByLink(String link);
    public T displayById(int id);
    public boolean update(T os);
}
