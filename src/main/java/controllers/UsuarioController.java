package controllers;

import dtos.UsuarioDto;
import jakarta.validation.Valid;
import models.UsuarioModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repositories.UsuarioRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    FileUploadService fileUploadService;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarUsuarios(){
       return ResponseEntity.status(HttpStatus.OK).body((List<UsuarioModel>) usuarioRepository.findAll());
    }

    @GetMapping("/matricula")
    public ResponseEntity<Object> buscarUsuario(@PathVariable(value = "matricula")String id){
        List<UsuarioModel> usuarioBuscado = usuarioRepository.findAll();

        if (usuarioBuscado.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioBuscado.get());
    }

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Object> criarUsuario(@ModelAttribute @Valid UsuarioDto usuarioDto){
        if (usuarioRepository.findByEmail(usuarioDto.email()) != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email já cadastrado");
        }

        UsuarioModel novousuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioDto, novousuario);

       return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(novousuario));

}
