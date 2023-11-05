package models;

import java.util.Objects;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Roles")
@Table(name = "tbl_Roles")
@NamedQueries({
	@NamedQuery(name = "Roles.findAll", query = "SELECT r FROM Roles r "),
	@NamedQuery(name = "Roles.findById", query = "SELECT r FROM Roles r WHERE r.id = :id")
})
@Getter
@Setter
public class Roles {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roles tblRoles = (Roles) o;
        return id == tblRoles.id && activo == tblRoles.activo && Objects.equals(descripcion, tblRoles.descripcion);
    }

    @Override
    public String toString(){
        return this.descripcion;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, activo, descripcion);
    }
}