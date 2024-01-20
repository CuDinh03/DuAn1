<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
=======
>>>>>>> ec9267bf7e7e17fbe46ce1ec122c1cd5d17263ba
package duan1_nhom1.service;

import java.util.List;
import java.util.UUID;

<<<<<<< HEAD
/**
 *
 * @author maccuacu
 */
=======
>>>>>>> ec9267bf7e7e17fbe46ce1ec122c1cd5d17263ba
public interface IService<T> {
   void add (T t);
   void update(T t, UUID id);
   void delete(UUID id);
   List<T> getAll();
   T findById( UUID id);
}
