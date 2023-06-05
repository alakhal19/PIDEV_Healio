/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.healio.pharmacie.service;

/**
 *
 * @author AMINE
 */
import java.util.List;

/**
 *
 * @author wiemhjiri
 * @param <T>
 */
public interface Iservice<T> {
    void insert(T t);
    List<T> readAll();
    T readById(int id);
    void delete(int id);
    void update(T t);
    
}
