package com.example.gerenciamento_de_categorias.Controllers;

import com.example.gerenciamento_de_categorias.Models.CategoriaModels;
import com.example.gerenciamento_de_categorias.Services.CategoriaService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaModels>cadastrar(@RequestBody CategoriaModels categoriaModels){
        CategoriaModels categoria = categoriaService.adicionar(categoriaModels);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(uri).body(categoria);
    }

    //listar todos livros
    @GetMapping
    public ResponseEntity<List<CategoriaModels>>buscarTudo(){
        List<CategoriaModels> request = categoriaService.buscaTudo();
        return ResponseEntity.ok(request);
    }

    //listar por id
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaModels> buscarPorID(@PathVariable Long id){
        CategoriaModels categoria = categoriaService.buscarPorID(id);
    return ResponseEntity.ok(categoria);
    }

    //deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<CategoriaModels> deletarCategoria(@PathVariable Long id){
        categoriaService.deletar(id);
    return ResponseEntity.noContent().build();
    }

    //atualizar
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaModels> atualizar(@PathVariable Long id, @RequestBody CategoriaModels categoriaModels){
        CategoriaModels categoriaAtualizada = categoriaService.atualizar(id,categoriaModels);
    return ResponseEntity.ok(categoriaAtualizada);
    }
}
