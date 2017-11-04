package br.com.clienteejb.entidade;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries(
    @NamedQuery(name = "Cliente.consultarTodos", query = "SELECT e FROM Cliente e")
)

@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    private Contato contato;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL)
    private CartaoCredito cartaoCredito;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    public Cliente() {

    }

    public Cliente(String cpf, String nome, Contato contato, Endereco endereco,
            CartaoCredito cartaoCredito, Usuario usuario) {
        this.cpf = cpf;
        this.nome = nome;
        this.contato = contato;
        this.endereco = endereco;
        this.cartaoCredito = cartaoCredito;
        this.usuario = usuario;
    }
}
