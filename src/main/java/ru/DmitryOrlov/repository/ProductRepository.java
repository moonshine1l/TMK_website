package ru.DmitryOrlov.repository;

import ru.DmitryOrlov.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Products, Long>{
    List<Products> findByTypeId(long type_id);
}
