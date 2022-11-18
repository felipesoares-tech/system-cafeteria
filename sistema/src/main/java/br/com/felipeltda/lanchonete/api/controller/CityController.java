package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.City;
import br.com.felipeltda.lanchonete.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityRepository cityRepository;
    @CrossOrigin
    @GetMapping
    public List<City> findAll(){
        return cityRepository.findAll();
    }

//    @CrossOrigin
//    @GetMapping("/{cityId}")
//    public City findById(@PathVariable Long cityId){
//        return cityRepository.findById(cityId).orElseThrow(() -> new RuntimeException("city not found!"));
//    }

    @CrossOrigin
    @GetMapping("/{uf}")
    public List<City> findByUf(@PathVariable Integer uf){
        return cityRepository.findByUf(uf);
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City save (@RequestBody City city){
        return cityRepository.save(city);
    }
}
