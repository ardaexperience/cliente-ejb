package br.com.clienteejb.bean;

import br.com.clienteejb.entidade.Cliente;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ClienteRemote {
    
    public Cliente registrar(Cliente cliente) throws Exception;
    
    public Cliente atualizar(Cliente cliente) throws Exception;
    
    public Cliente consultarPorId(Long id);
    
    public List<Cliente> consultarTodos();

}
