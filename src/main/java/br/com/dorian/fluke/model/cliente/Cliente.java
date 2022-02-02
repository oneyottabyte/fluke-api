package br.com.dorian.fluke.model.cliente;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "tb_cliente")
public class Cliente {
    @Id
    private String id;
    @NotNull
    private String nomeCompleto;
    @NotNull
    private String cpf;// tem que validar e  tornar unico
    @NotNull
    private String cidade;
    @NotNull
    private String uf;
}