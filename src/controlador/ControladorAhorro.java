/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import modelo.Ahorro;
import modelo.Gasto;

/**
 *
 * @author User
 */
public class ControladorAhorro extends Controlador<Ahorro> {

    public BigDecimal calcularTotalPorAnio(int anio) {

        var lista = findByAnio(anio);

        double total = 0;

        total = lista.stream().map(ah -> Double.valueOf(ah.getDineroEntrada().toString())).reduce(total, (accumulator, _item) -> accumulator + _item);

        return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP);

    }

    public List<Ahorro> findByAnio(int anio) {

        var lista = findAll();

        List<Ahorro> listaResultado = new ArrayList<>();

        lista.forEach(ah -> {
            if ((ah.getFecha().getYear() + 1900) == anio) {
                listaResultado.add(ah);
            }
        });

        return listaResultado;
    }

    public BigDecimal calcularTotalPorMes(int mes) {
        var lista = findByMes(mes);

        double total = 0;

        total = lista.stream().map(ah -> Double.valueOf(ah.getDineroEntrada().toString())).reduce(total, (accumulator, _item) -> accumulator + _item);

        return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP);

    }

    public List<Ahorro> findByMes(int mes) {
        Date fecha = new Date();

        List<Ahorro> listaResultado = new ArrayList<>();
        var listaAhorro = findAll();

        listaAhorro.forEach(ah -> {
            if ((ah.getFecha().getMonth()) == mes) {
                listaResultado.add(ah);
            }
        });

        return listaResultado;

    }

    public BigDecimal calcularTotal() {
        var ahorros = findAll();

        double total = 0;

        total = findAll().stream().map(ah -> Double.valueOf(ah.getDineroEntrada().toString())).reduce(total, (accumulator, _item) -> accumulator + _item);

        BigDecimal totalFinal = BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP);

        return totalFinal;
    }

    @Override
    public List<Ahorro> findAll() {
        Query consulta = getEm().createNamedQuery("Ahorro.findAll");
        var lista = consulta.getResultList();

        if (lista.size() > 0) {
            Collections.sort(lista, (Ahorro a1, Ahorro a2) -> a1.getId().compareTo(a2.getId()));
        }
        return consulta.getResultList();
        
    }

    @Override
    public int codigo() {
        var lista = findAll();

        if (lista.size() > 0) {
            Collections.sort(lista, (Ahorro a1, Ahorro a2) -> a1.getId().compareTo(a2.getId()));
            return lista.get(lista.size() - 1).getId() + 1;
        } else {
            return 1;
        }

    }

}
