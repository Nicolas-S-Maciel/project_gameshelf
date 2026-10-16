package br.com.estudos.gameshelf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jogos")
@Getter
@Setter
@NoArgsConstructor
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Informe o título.")
    @Size(
        min = 2,
        max = 100,
        message = "O título deve ter entre 2 e 100 caracteres."
    )
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank(message = "Informe a desenvolvedora.")
    @Column(nullable = false)
    private String desenvolvedora;

    @NotBlank(message = "Informe a plataforma.")
    @Column(nullable = false)
    private String plataforma;

    @NotBlank(message = "Informe o gênero.")
    @Column(nullable = false)
    private String genero;

    @NotNull(message = "Informe o ano de lançamento.")
    @Min(value = 1950, message = "O ano deve ser igual ou maior que 1950.")
    @Max(value = 2100, message = "O ano não pode ser maior que 2100.")
    private Integer anoLancamento;

    @NotNull(message = "Informe uma nota.")
    @DecimalMin(value = "0.0", message = "A nota mínima é 0.")
    @DecimalMax(value = "10.0", message = "A nota máxima é 10.")
    private Double nota;

    @NotBlank(message = "Selecione o status.")
    private String status;
}