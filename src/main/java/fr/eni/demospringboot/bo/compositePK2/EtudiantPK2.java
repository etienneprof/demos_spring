package fr.eni.demospringboot.bo.compositePK2;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class EtudiantPK2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email;
    private String immatriculation;
}
