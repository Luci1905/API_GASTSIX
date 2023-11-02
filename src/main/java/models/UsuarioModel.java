package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;
@Getter
@Setter
@Table(name = "tb_usuarios")
public class UsuarioModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula", nullable = false)
    private UUID id;

    private String nome;
    private String CPF;
    private String matricula;
    private String email;
    private String funcao;
    private String dataAdm;
    private String senha;
    private String confirmarSenha;
}
