/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.alura.loja.resource;

import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import java.util.Date;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("xunda")
public class ItemRS {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Item> getItens(){
        System.out.println(new Date());
        List<Item> lista = new ItemDao().todosItens();
        return  lista;
    }
    
}
