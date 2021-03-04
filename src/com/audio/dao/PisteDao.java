/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.audio.dao;
import com.audio.entity.Piste;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.audio.utils.Connexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author LENOVO
 */
public class PisteDao implements Idao<Piste> {
    private static PisteDao instance;
    private Statement statement;
    private ResultSet resultSet;
    
    public PisteDao(){
    Connexion cs=Connexion.getInstance();
        try {
            statement = cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(PisteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static PisteDao getInstance(){
        if(instance==null) 
            instance=new PisteDao();
        return instance;
    }

    @Override
    public Piste displayById(int id) {
         String req="select * from personne where id ="+id;
           Piste p=new Piste();
        try {
            resultSet=statement.executeQuery(req);
            while(resultSet.next()){

                p.setId(resultSet.getInt("id"));
                p.setName(resultSet.getString("nom"));
                p.setAuthor(resultSet.getString("author"));
                p.setDateOfCreation(resultSet.getDate("datec"));
                p.setDateOfLastMod(resultSet.getDate("datem"));
                p.setLink(resultSet.getString("link"));
                
            }  
        } catch (SQLException ex) {
            Logger.getLogger(PisteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }
    @Override
    public boolean delete(Piste o) {
    String req="delete from personne where id="+o.getLink();
         Piste p = displayById(o.getId());
        
          if(p!=null)
              try {
           
            statement.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PisteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }else System.out.println("n'existe pas");
          return true;
    }

    @Override
    public List<Piste> displayAll() {
        String req="select * from piste";
        ObservableList<Piste> list=FXCollections.observableArrayList();       
        
        try {

            resultSet=statement.executeQuery(req);
            while(resultSet.next()){
                Piste p=new Piste();
                p.setId(resultSet.getInt(1));
                p.setName(resultSet.getString("nom"));
                p.setAuthor(resultSet.getString("author"));
                p.setDateOfCreation(resultSet.getDate("datec"));
                p.setDateOfLastMod(resultSet.getDate("datem"));
                p.setLink(resultSet.getString("link"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PisteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Piste displayByLink(String link) {
                 String req="select * from personne where link ="+link;
           Piste p=new Piste();
        try {
            resultSet=statement.executeQuery(req);
            while(resultSet.next()){
                resultSet.next();
                p.setId(resultSet.getInt("id"));
                p.setName(resultSet.getString("nom"));
                p.setAuthor(resultSet.getString("author"));
                p.setDateOfCreation(resultSet.getDate("datec"));
                p.setDateOfLastMod(resultSet.getDate("datem"));
                p.setLink(resultSet.getString("link"));
            }  
        } catch (SQLException ex) {
            Logger.getLogger(PisteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
   }

    @Override
    public boolean insert(Piste o) {
        String req="insert into personne (name,link) values ('"+o.getName()+"','"+o.getLink()+"')";
        try {
            statement.executeUpdate(req);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PisteDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean update(Piste p) {
        String qry = "UPDATE piste SET nom = '"+p.getName()+"', author = '"+p.getAuthor()+"'datec ='"+
                p.getDateOfCreation()+"'datem ='"+p.getDateOfLastMod()+"'link ='"+p.getLink()+"' WHERE id = "+p.getId();
        
        try {
            if (statement.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PisteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;    }

    @Override
    public boolean mod(Piste o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
