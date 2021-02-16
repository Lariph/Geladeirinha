package com.example.backend;

//import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/")
public class FoodController {

    @Autowired
    private FoodRepository geladeira;

    //private List<Food> geladeira;
    //private List<Food> geladeira = new ArrayList<>();

    /*public FoodController() {
    geladeira = new ArrayList<>();
    geladeira.add(new Food(10, "batata"));
    geladeira.add(new Food(5, "cenoura"));
    geladeira.add(new Food(3, "caixa de leite"));
    geladeira.add(new Food(9, "chocolate"));

    }*/
    //listar tudo
    @GetMapping("/listar")
    public List<Food> list() {
        return this.geladeira.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    @PostMapping("/adicionar")
    public Food add(@RequestBody Food food){
        return this.geladeira.save(food);
    }

    @GetMapping("/deletar/{id}")
    public Map<String, Boolean> delete(@PathVariable("id") Long id){
        Food food = geladeira.findById(id).orElse(null);
        this.geladeira.delete(food);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

    @GetMapping("/atualizar/{id}/{newname}/{newquant}")
    public ResponseEntity<Food> update(@PathVariable("id") Long id, 
                            @PathVariable("newname") String newname, 
                            @PathVariable("newquant") int newquant) {
        Food food = geladeira.findById(id).orElse(null);
        food.setName(newname);
        food.setQuant(newquant);
        return ResponseEntity.ok(this.geladeira.save(food));
    }     
    
    //buscar
   /* @GetMapping("/{name}")
    public Food get(@PathVariable String name) {
        return geladeira.stream().filter(f -> name.equals(f.getName())).findAny().orElse(null);
    }
    
    //adicionar no array
    @PostMapping("/adicionar")
    public List<Food> add(@RequestBody Food food) {
        geladeira.add(food);
        return geladeira;
    }
    */

/*
    //deletar
    @GetMapping("/deletar/{id}")
    public List<Food> delete(@PathVariable int id) {
        geladeira.remove(id);
        return geladeira;
    }

    //atualizar
    @GetMapping("/atualizar/{id}/{newname}/{newquant}")
    public List<Food> update(@PathVariable("id") int id, @PathVariable("newname") String newname, @PathVariable("newquant") int newquant) {
        geladeira.get(id).setName(newname);
        geladeira.get(id).setQuant(newquant);
        return geladeira;
    } */

}