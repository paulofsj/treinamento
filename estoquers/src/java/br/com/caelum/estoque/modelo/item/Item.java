package br.com.caelum.estoque.modelo.item;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@SequenceGenerator(name = "SEQ_ITEM", sequenceName = "SEQ_ITEM", initialValue = 1)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ITEM")
    private long id;
    private String codigo;
    private String nome;
    private String tipo;
    private int quantidade;

    
    Item() {
        super();
    }

    public Item(String codigo, String nome, String tipo, int quantidade) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    Item(String codigo) {
        this.codigo = codigo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    public String getCodigo() {
        return codigo;
    }

      
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        return this.codigo.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Item item = (Item) obj;
        return this.codigo.equals(item.codigo);
    }

    @Override
    public String toString() {
        return "Item [codigo=" + codigo + ", nome=" + nome + ", tipo=" + tipo + ", quantidade="
                + quantidade + "]";
    }

    public static class Builder {

        private String codigo;
        private String nome;
        private String tipo;
        private int quantidade;

        public Builder comNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder comTipo(String tipo) {
            this.tipo = tipo;
            return this;
        }

        public Builder comCodigo(String codigo) {
            this.codigo = codigo;
            return this;
        }

        public Builder comQuantidade(int quantidade) {
            this.quantidade = quantidade;
            return this;
        }

        public Item build() {
            return new Item(this.codigo, this.nome, this.tipo, this.quantidade);
        }

    }

}
