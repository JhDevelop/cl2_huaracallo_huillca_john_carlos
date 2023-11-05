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


@Entity(name = "Cliente")
@Table(name = "tbl_Cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id")
})
@Getter
@Setter
public class Cliente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "apellidoMaterno", nullable = false, length = 255)
    private String apellidoMaterno;
    @Basic
    @Column(name = "apellidoPaterno", nullable = false, length = 255)
    private String apellidoPaterno;
    @Basic
    @Column(name = "nombres", nullable = false, length = 255)
    private String nombres;

    public Cliente(String apellidoMaterno, String apellidoPaterno, String nombres) {
    	this.apellidoMaterno = apellidoMaterno;
    	this.apellidoPaterno = apellidoPaterno;
    	this.nombres = nombres;
    }

    public Cliente() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente that = (Cliente) o;
        return id == that.id && Objects.equals(apellidoMaterno, that.apellidoMaterno) && Objects.equals(apellidoPaterno, that.apellidoPaterno) && Objects.equals(nombres, that.nombres);
    }
    @Override
    public String toString(){
        return this.apellidoMaterno+ " "+ this.apellidoPaterno + " " + this.apellidoMaterno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellidoMaterno, apellidoPaterno, nombres);
    }
}
