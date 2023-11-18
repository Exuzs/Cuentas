package com.example.cuentas.repositories;

import com.example.cuentas.entities.TipoOperacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoOperacionRepository extends JpaRepository<TipoOperacion, Long> {
}
