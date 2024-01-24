/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package giao_dien.service;

/**
 *
 * @author acer
 */
public interface IService<T> {
    void add (T t);
   void update(T t, String id);
   void delete(String  id);
   
   T findById( String  id);
}
