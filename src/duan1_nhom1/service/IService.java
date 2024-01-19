package duan1_nhom1.service;

import java.util.List;
import java.util.UUID;

public interface IService<T> {
   void add (T t);
   void update(T t, UUID id);
   void delete(UUID id);
   List<T> getAll();
   T findById( UUID id);
}
