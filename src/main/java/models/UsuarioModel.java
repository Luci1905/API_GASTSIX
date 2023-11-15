package com.gastsix.apigastsix;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "tb_usuarios")
public class UsuarioModel implements Serializable, UserDetails {

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

    @Override
    public Collection<? estends GrantedAuthority> getAuthorities() {
        if (this.tipo_usuario == tipoModel.ADMIN){}

    }
}
