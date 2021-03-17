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
import modelo.Gasto;

/**
 *
 * @author User
 */
public class ControladorGastos extends Controlador<Gasto> {

    public BigDecimal calcularTotalPorAnio(int anio) {
        var lista = findByAnio(anio);

        double total = 0;

        total = lista.stream().map(gas -> Double.valueOf(gas.getDineroGastado().toString())).reduce(total, (accumulator, _item) -> accumulator + _item);

        return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP);

    }

    public List<Gasto> findByAnio(int anio) {

        var lista = findAll();

        List<Gasto> listaResultado = new ArrayList<>();

        lista.forEach(gas -> {
            if ((gas.getFecha().getYear() + 1900) == anio) {
                listaResultado.add(gas);
            }
        });

        return listaResultado;
    }

    public BigDecimal calcularTotalPorMes(int mes) {
        var lista = findByMes(mes);

        double total = 0;

        for (Gasto gas : lista) {
            total += Double.valueOf(gas.getDineroGastado().toString());
        }

        return BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP);

    }

    public List<Gasto> findByMes(int mes) {
        Date fecha = new Date();

        List<Gasto> listaResultado = new ArrayList<>();
        var listaGastos = findAll();

        listaGastos.forEach(gas -> {
            if ((gas.getFecha().getMonth()) == mes) {
                listaResultado.add(gas);
            }
        });

        return listaResultado;

    }

    public BigDecimal calcularTotal() {
        var gastos = findAll();

        double total = 0;

        total = findAll().stream().map(ah -> Double.valueOf(ah.getDineroGastado().toString())).reduce(total, (accumulator, _item) -> accumulator + _item);

        BigDecimal totalFinal = BigDecimal.valueOf(total).setScale(2, RoundingMode.HALF_UP);

        return totalFinal;

    }

    public ArrayList<Gasto> findByCategoria(String nombreCategoria) {

        var gastosCategoria = new ArrayList<Gasto>();

        findAll().stream().filter(gas -> (gas.getCategoriaFk().getNombre().equalsIgnoreCase(nombreCategoria))).forEachOrdered(gas -> {
            gastosCategoria.add(gas);
        });

        return gastosCategoria;

    }

    public ArrayList<Gasto> findByFecha(Date fechaInicio, Date fechaFin) {

        var gastosFecha = new ArrayList<Gasto>();

        findAll().stream().filter(gas -> (fechaInicio.before(gas.getFecha()) && fechaFin.after(gas.getFecha()))).forEachOrdered(gas -> {
            gastosFecha.add(gas);
        });

        return gastosFecha;

    }

    public ArrayList<Gasto> findByFechaCategoria(Date fechaInicio, Date fechaFin, ArrayList<Gasto> gastosCategoria) {

        var gastosResultado = new ArrayList<Gasto>();

        gastosCategoria.stream().filter(gas -> (fechaInicio.before(gas.getFecha()) && fechaFin.after(gas.getFecha()))).forEachOrdered(gas -> {
            gastosResultado.add(gas);
        });

        return gastosResultado;
    }

    @Override
    public List<Gasto> findAll() {
        Query consulta = getEm().createNamedQuery("Gasto.findAll");
        var lista = consulta.getResultList();
        if (lista.size() > 0) {
            Collections.sort(lista, (Gasto s1, Gasto s2) -> s1.getId().compareTo(s2.getId()));
        }
        return lista;
    }

    @Override
    public int codigo() {
        var gastos = findAll();
        if (gastos.size() > 0) {
            return gastos.get(gastos.size() - 1).getId() + 1;
        } else {
            return 1;
        }
    }

}
