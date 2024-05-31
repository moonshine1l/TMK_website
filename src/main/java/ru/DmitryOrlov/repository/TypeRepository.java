package ru.DmitryOrlov.repository;

import ru.DmitryOrlov.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
