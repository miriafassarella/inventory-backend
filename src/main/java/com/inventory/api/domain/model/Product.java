package com.inventory.api.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Product {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dpurchase = LocalDate.now();

    @Column(name = "serial_number", unique = true, nullable = false)
    private String serialNumber;

    @JoinColumn(name = "id_owner")
    @ManyToOne()
    private Owner owner;

    @JoinColumn(name = "id_model")
    @ManyToOne()
    private Model model;

    @JoinColumn(name = "id_usability")
    @ManyToOne()
    private Usability usability;

    @JoinColumn(name = "id_professional")
    @ManyToOne()
    private Professional professional;

    @JoinColumn(name = "id_establishment")
    @ManyToOne()
    private Establishment establishment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDpurchase() {
        return dpurchase;
    }

    public void setDpurchase(LocalDate dpurchase) {
        this.dpurchase = dpurchase;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Usability getUsability() {
        return usability;
    }

    public void setUsability(Usability usability) {
        this.usability = usability;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Establishment getEstablishment() {
        return establishment;
    }

    public void setEstablishment(Establishment establishment) {
        this.establishment = establishment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
