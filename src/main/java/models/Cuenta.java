package models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Cuenta")
@Table(name = "tbl_Cuenta")
@NamedQueries({
        @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c "),
        @NamedQuery(name = "Cuenta.findById", query = "SELECT c FROM Cuenta c WHERE c.id = :id ")
})
@Getter
@Setter
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "activa", nullable = false)
    private boolean activa;

    @Column(name = "numeroCuenta", nullable = false, length = 255)
    private String numeroCuenta;

    @Column(name = "saldo", nullable = false)
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tipoCuenta", referencedColumnName = "id")  // Asegúrate de que esto coincida con la columna de referencia en la base de datos
    private TipoCuenta tipoCuenta;

    @Override
    public String toString() {
        return this.numeroCuenta + " - " + cliente.toString();
    }
}
