package br.com.clienteejb.dao;

import br.com.clienteejb.entidade.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClienteDAO {

    EntityManager em;

    public ClienteDAO(EntityManager em) {
        this.em = em;
    }

    public Cliente registrar(Cliente cliente) throws Exception {
        if (cliente.getId() == null) {
            em.persist(cliente);
        } else {
            throw new Exception("Não foi possível registrar o Cliente!");
        }
        return cliente;
    }

    public Cliente atualizar(Cliente cliente) throws Exception {
        if (em.find(Cliente.class, cliente.getId()) == null) {
            throw new Exception("Não foi possível atualizar o Cliente!");
        } else {
            cliente = em.merge(cliente);
        }
        return cliente;
    }

    public Cliente consultarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

    public List<Cliente> consultarTodos() {
        
        Query query = em.createNamedQuery("Cliente.consultarTodos");
        List<Cliente> clientes = query.getResultList();

        return clientes;
    }

}
