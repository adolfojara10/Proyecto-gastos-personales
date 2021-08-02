/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Collections;
import java.util.List;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import modelo.Categoria;

/**
 *
 * @author User
 */
public class ControladorCategoria extends Controlador<Categoria> {

    public List<Categoria> findByTipo(String tipo) {
        Query consulta = getEm().createNamedQuery("Categoria.findByTipo");
        consulta.setParameter("tipo", tipo);
        return consulta.getResultList();
    }

    public Categoria findByNombre(String nombre) {
        try {
            Query consulta = getEm().createNamedQuery("Categoria.findByNombre");
            consulta.setParameter("nombre", nombre);
            return (Categoria) consulta.getSingleResult();
        } catch (NonUniqueResultException e) {
            Query consulta = getEm().createNamedQuery("Categoria.findByNombre");
            consulta.setParameter("nombre", nombre);
            System.out.println(consulta.getResultList());
            return (Categoria) consulta.getResultList().get(0);
        }
    }

    @Override
    public List<Categoria> findAll() {
        Query consulta = getEm().createNamedQuery("Categoria.findAll");
        var lista = consulta.getResultList();
        Collections.sort(lista, (Categoria s1, Categoria s2) -> s1.getId().compareTo(s2.getId()));
        return lista;

    }

    @Override
    public int codigo() {
        var cats = findAll();

        return cats.get(cats.size() - 1).getId() + 1;
    }

}
