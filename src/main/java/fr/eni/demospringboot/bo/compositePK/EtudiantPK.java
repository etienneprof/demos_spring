package fr.eni.demospringboot.bo.compositePK;

import lombok.Data;

import java.io.Serializable;

@Data
public class EtudiantPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String immatriculation;
}
