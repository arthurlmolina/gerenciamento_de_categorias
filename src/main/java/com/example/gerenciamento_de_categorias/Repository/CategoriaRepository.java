package com.example.gerenciamento_de_categorias.Repository;

import com.example.gerenciamento_de_categorias.Models.CategoriaModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaModels, Long> {
}
