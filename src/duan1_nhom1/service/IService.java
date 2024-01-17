/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package duan1_nhom1.service;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author maccuacu
 */
public interface IService<T> {
   void add (T t);
   void update(T t, UUID id);
   void delete(UUID id);
   List<T> getAll();
   T findById( UUID id);
}
