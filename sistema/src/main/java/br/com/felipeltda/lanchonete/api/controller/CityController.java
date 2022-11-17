package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.City;
import br.com.felipeltda.lanchonete.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CityController {
    @Autowired
    private CityRepository cityRepository;
    @CrossOrigin
    @GetMapping
    public List<City> findAll(){
        return cityRepository.findAll();
    }

    @GetMapping("/{cidadeId}")
    public City findById(@PathVariable Long cidadeId){
        return cityRepository.findById(cidadeId).orElseThrow(() -> new RuntimeException("CIDADE NÃO ENCONTRADO!"));
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City save (@RequestBody City city){
        return cityRepository.save(city);
    }
}
