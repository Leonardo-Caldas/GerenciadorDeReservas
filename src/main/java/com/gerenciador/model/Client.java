package com.gerenciador.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
public class Client {
    @Id
    private String uuid;
    private String name;
    private String contactNumber;
    private String email;


}
