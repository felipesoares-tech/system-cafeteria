package br.com.felipeltda.lanchonete.api.controller;
import br.com.felipeltda.lanchonete.domain.model.Cidade;
import br.com.felipeltda.lanchonete.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {
    @Autowired
    private CidadeRepository cidadeRepository;
    @CrossOrigin
    @GetMapping
    public List<Cidade> findAll(){
        return cidadeRepository.findAll();
    }

    @GetMapping("/{cidadeId}")
    public Cidade findById(@PathVariable Long cidadeId){
        return cidadeRepository.findById(cidadeId);
    }

    @CrossOrigin
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade save (@RequestBody Cidade cidade){
        return cidadeRepository.save(cidade);
    }
}
