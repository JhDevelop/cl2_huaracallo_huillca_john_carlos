package models;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Movimiento")
@Table(name = "tbl_Movimiento")
@NamedQueries({
	@NamedQuery(name = "Movimiento.findAll", query = "SELECT m FROM Movimiento m "),
	@NamedQuery(name = "Movimiento.findById", query = "SELECT m FROM Movimiento m WHERE m.id = :id")
})
@Getter
@Setter
public class Movimiento {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "descripcion", nullable = false, length = 255)
    private String descripcion;
    @Basic
    @Column(name = "fecha", nullable = false)
    private Date fecha;
    @Basic
    @Column(name = "monto", nullable = false, precision = 0)
    private double monto;
    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuentaId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movimiento that = (Movimiento) o;
        return id == that.id && Double.compare(monto, that.monto) == 0 && cuentaId == that.cuentaId && Objects.equals(descripcion, that.descripcion) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descripcion, fecha, monto, cuentaId);
    }
}
