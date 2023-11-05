package models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "TipoCuenta")
@Table(name = "tbl_TipoCuenta")
@NamedQueries({
	@NamedQuery(name = "TipoCuenta.findAll", query = "SELECT t FROM TipoCuenta t "),
	@NamedQuery(name = "TipoCuenta.findById", query = "SELECT t FROM TipoCuenta t WHERE t.id = :id")
})
@Getter
@Setter
public class TipoCuenta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Basic
    @Column(name = "moneda", nullable = false, length = 255)
    private String moneda;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoCuenta that = (TipoCuenta) o;
        return id == that.id && Objects.equals(descripcion, that.descripcion) && Objects.equals(moneda, that.moneda);
    }

    @Override
    public String toString(){
        return this.descripcion;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, moneda);
    }
}