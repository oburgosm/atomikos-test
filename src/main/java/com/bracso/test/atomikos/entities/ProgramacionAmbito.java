package com.bracso.test.atomikos.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "PROGRAMACION_AMBITO")
@Data
public class ProgramacionAmbito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROGRAMACION_AMBITO")
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_PROGRAMACION", nullable = false)
    private Programacion programacion;

    @NotBlank
    @Column(name = "ID_ORGANIZATION", length = 48, nullable = false)
    private String idOrgenization;

}
