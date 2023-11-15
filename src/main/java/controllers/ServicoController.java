package com.gastsix.apigastsix;

import models.ServicoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repositories.ServicoRepository;
import repositories.UsuarioRepository;

@RestController
@RequestMapping(value = "/servicos", produces = {"application/json"})
public class ServicoController {

    @Autowired
    ServicoRepository servicoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<ServicoModel> {
        return ResponseEntity.status(HttpStatus.OK).body(servicoRepository.findAll());
    }


}
