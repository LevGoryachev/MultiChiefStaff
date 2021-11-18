package ru.goryachev.multichief.staff.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Position (used as DTO without converters).
 * @author Lev Goryachev
 * @version 3
 */

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long id;

    @Column(name = "pos_name")
    private String posName;

    @Column(name = "pos_code")
    private String posCode;

    @OneToMany(mappedBy = "position", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "position" ,"hibernateLazyInitializer", "handler" }, allowSetters = true)
    private List<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosName() {
        return posName;
    }

    public void setPosName(String posName) {
        this.posName = posName;
    }

    public String getPosCode() {
        return posCode;
    }

    public void setPosCode(String posCode) {
        this.posCode = posCode;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return Objects.equals(getId(), position.getId()) &&
                Objects.equals(getPosName(), position.getPosName()) &&
                Objects.equals(getPosCode(), position.getPosCode()) &&
                Objects.equals(getEmployees(), position.getEmployees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPosName(), getPosCode(), getEmployees());
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", posName='" + posName + '\'' +
                ", posCode='" + posCode + '\'' +
                ", employees=" + employees +
                '}';
    }
}
