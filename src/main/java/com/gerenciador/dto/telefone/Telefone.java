package com.gerenciador.dto.telefone;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.security.InvalidParameterException;

@Data
public class Telefone {

    public Telefone(Integer ddd, Integer primeirosCincoDigitos, Integer ultimosQuatroDigitos) {
        this.ddd = ddd;
        this.primeirosCincoDigitos = primeirosCincoDigitos;
        this.ultimosQuatroDigitos = ultimosQuatroDigitos;
    };
    public Telefone(Integer numeroDeTelefone) {
        build(numeroDeTelefone);
    }
    public Telefone(String numerodeTelefone) {
        build(Integer.parseInt(numerodeTelefone));
    }

    private void build(Integer numeroDeTelefone) {
        try {
            ddd = numeroDeTelefone/1000000000;
            if (ddd == 0) {
                throw new InvalidParameterException("O número de telefone informado não contém DDD!");
            }
        } catch (Exception InvalidParameterException) {
            ddd = null;
        }
        primeirosCincoDigitos = (numeroDeTelefone%1000000000)/10000;
        ultimosQuatroDigitos = numeroDeTelefone%10000;
    }

    private Integer ddd = null;
    private Integer primeirosCincoDigitos = null;
    private Integer ultimosQuatroDigitos = null;

    @Override
    public String toString() {
        return "(" +
                ddd +
                ")" +
                primeirosCincoDigitos +
                "-" +
                ultimosQuatroDigitos;
    }
}
