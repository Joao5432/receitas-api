package com.receitasapi.receitasapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.receitasapi.receitasapi.model.Receita;

@Service
public class ReceitaService {
    public List<Receita> receitas = new ArrayList<Receita>();

    public List<Receita> findAll(){
        return receitas;
    }

    public Receita find(Receita receita){
        return receitas.stream()
                     .filter(r -> r.equals(receita))
                     .findFirst().orElse(null);        
    }

    public Receita find(Long id){
        return find(new Receita(id));
    }

    public Receita create(Receita receita){
        Long newId = (long) (receitas.size() + 1);
        receita.setId(newId);
        receitas.add(receita);
        return receita;
    }

    public Boolean delete(Long id){
        Receita _receita = this.find(id);
        if(_receita != null){
            receitas.remove(_receita);
            return true;
        }
        return false;
    }

    public Boolean update(Receita receita){
        Receita _receita = find(receita);
        if(_receita != null){
            if (receita.getNome() != null)
            _receita.setNome(receita.getNome());
            if (!receita.getIngredientes().isEmpty())
            _receita.setIngredientes(receita.getIngredientes());
            if (receita.getInstrucoes() != null)
            _receita.setInstrucoes(receita.getInstrucoes());

            return true;
        }
        return false;
    }
}

