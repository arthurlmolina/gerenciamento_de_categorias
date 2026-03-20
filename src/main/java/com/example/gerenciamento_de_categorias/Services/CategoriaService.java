package com.example.gerenciamento_de_categorias.Services;

import com.example.gerenciamento_de_categorias.Models.CategoriaModels;
import com.example.gerenciamento_de_categorias.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    //add
    public CategoriaModels adicionar(CategoriaModels categoriaModels){
        return categoriaRepository.save(categoriaModels);
    }

    //buscar tudo
    public List<CategoriaModels> buscaTudo(){
        return categoriaRepository.findAll();
    }

    //busca id
    public CategoriaModels buscarPorID(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }

    //deletar
    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }

    //atualizar
    public CategoriaModels atualizar(Long id, CategoriaModels categoriaModels){
        CategoriaModels novaCategoria = categoriaRepository.findById(id).orElse(null);
        novaCategoria.setNome(categoriaModels.getNome());
        novaCategoria.setDescricao(categoriaModels.getDescricao());
        return categoriaRepository.save(novaCategoria);
    }
}
