package br.com.ProjetoOasis.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UseForm {

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 6)
    private String password;

    private List<String> roles;
}
