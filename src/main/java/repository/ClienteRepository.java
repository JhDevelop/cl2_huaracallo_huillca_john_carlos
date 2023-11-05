package repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import models.Cliente;

public class ClienteRepository {

	EntityManagerFactory persistence = Persistence.createEntityManagerFactory("default");
	EntityManager manager = persistence.createEntityManager();
	EntityTransaction transactional = manager.getTransaction();

	
	public List<Cliente> findAll() {
		 List<Cliente> list = null;
		try {
			list = manager.createNamedQuery("Cliente.findAll", Cliente.class).getResultList();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	    return list;
	}

	public Cliente findById() {
		Cliente cliente = null;
		try {
			cliente = manager.createNamedQuery("Cliente.findById", Cliente.class).getSingleResult();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}
	
	public Cliente create(Cliente cliente) {
		try {
			transactional.begin();
			manager.persist(cliente);
			transactional.commit();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}
	
}
