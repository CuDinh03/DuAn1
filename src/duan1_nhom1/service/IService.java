package duan1_nhom1.service;

import java.util.List;
import java.util.UUID;

public interface IService<T> {
   void add (T t);
   void update(T t, String  id);
   void delete(String  id);
   List<T> getAll();
   T findById( String  id);

}
