package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "ClienteRol")
@Entity(name = "ClienteRol")
@NamedQueries({
    @NamedQuery(name = "ClienteRol.findAll", query = "SELECT c FROM ClienteRol c"),
    @NamedQuery(name = "ClienteRol.findByIdCliente", query = "SELECT c FROM ClienteRol c WHERE c.cliente = :cliente_id"),
    @NamedQuery(name = "ClienteRol.findByIdRoles", query = "SELECT c FROM ClienteRol c WHERE c.roles = :roles_id")
})
@Getter
@Setter
public class ClienteRol {
    @Id
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Id
    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Roles roles;
}
