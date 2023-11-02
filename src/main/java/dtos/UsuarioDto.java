package dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public record UsuarioDto(
        @NotBlank String nome,
        @NotBlank String CPF,
        @NotBlank String matricula,

        @NotBlank @Email(message = "O email deve estar no formato válido") String email,
        @NotBlank String funcao,
        @NotBlank String dataAdm,
        @NotBlank String senha,
        @NotBlank String confirmarSenha
) {
}
