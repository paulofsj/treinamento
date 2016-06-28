package br.com.caelum.estoque.modelo.item;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ItemDao {

    private static Map<String, Item> ITENS = new LinkedHashMap<>();
    private  EntityManagerFactory emf = Persistence.createEntityManagerFactory("estoque");

    public ItemDao() {
        popularItensNoMapa();
    }

    public void cadastrar(Item item) {
        ITENS.put(item.getCodigo(), item);
    }

    public ArrayList<Item> todosItens(List<Filtro> filtros) {
        return null;
    }

    //este método existe apenas para facilitar o primeiro exercicio que não usa o filtro
    public ArrayList<Item> todosItens() {
        EntityManager manager = emf.createEntityManager();
        Query query = manager.createQuery("from Item");
//        Query query = manager.createQuery("select i from Item i");
        return (ArrayList<Item>) query.getResultList();
        
    }

    private boolean itemPossuiNome(Item item, String nome) {
        return item.getNome().contains(nome);
    }

    private boolean itemPossuiTipo(Item item, String tipo) {
        return item.getTipo().equals(tipo);
    }

    public Item quantidadeDo(String codigo) {
        return ITENS.get(codigo);
    }

    private void popularItensNoMapa() {

        ITENS.put("MEA", new Item.Builder().comCodigo("MEA").comNome("MEAN").comTipo("Livro").comQuantidade(5).build());
        ITENS.put("MEA", new Item.Builder().comCodigo("SEO").comNome("SEO na Prática").comTipo("Livro").comQuantidade(4).build());
        ITENS.put("RUB", new Item.Builder().comCodigo("RUB").comNome("Jogos com Ruby").comTipo("Livro").comQuantidade(8).build());
        ITENS.put("GAL", new Item.Builder().comCodigo("GAL").comNome("Galaxy Tab").comTipo("Tablet").comQuantidade(3).build());
        ITENS.put("IP4", new Item.Builder().comCodigo("IP4").comNome("IPhone 4 C").comTipo("Celular").comQuantidade(7).build());
        ITENS.put("IP5", new Item.Builder().comCodigo("IP5").comNome("IPhone 5").comTipo("Celular").comQuantidade(3).build());
        ITENS.put("IP6", new Item.Builder().comCodigo("IP6").comNome("IPhone 6 S").comTipo("Celular").comQuantidade(10).build());
        ITENS.put("MOX", new Item.Builder().comCodigo("MOX").comNome("Moto X").comTipo("Celular").comQuantidade(6).build());
        ITENS.put("MOG", new Item.Builder().comCodigo("MOG").comNome("Moto G").comTipo("Celular").comQuantidade(8).build());
        ITENS.put("MXX", new Item.Builder().comCodigo("MXX").comNome("Moto MAXX").comTipo("Celular").comQuantidade(2).build());

       
        EntityManager manager = emf.createEntityManager();
        
        manager.getTransaction().begin();
        
        for (Item item : ITENS.values()) {
            manager.persist(item);
        }
        
        manager.getTransaction().commit();
        manager.close();
    }

}
