/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1_nhom1.service;

import java.util.List;


/**
 *
 * @author anhtuanle
 */
public interface IService<T> {
   void add (T t);
   void update(T t, String id);
   void delete(String id);
   List<T> getAll();
   T findById( String id);
}
