/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import modelo.Ahorro;
import modelo.Balance;
import modelo.Gasto;

/**
 *
 * @author User
 */
public class ControladorBalance extends Controlador<Balance> {

    
    
    public boolean gasto(BigDecimal gasto) {
        var balances = findAll();
        var balance = balances.get(balances.size() - 1);

        balance.setDinero(balance.getDinero().subtract(gasto).setScale(2, RoundingMode.HALF_UP));
        return update(balance);

    }

    public boolean ahorro(BigDecimal ahorro) {
        var balances = findAll();
        var balance = balances.get(balances.size() - 1);

        balance.setDinero(balance.getDinero().add(ahorro).setScale(2, RoundingMode.HALF_UP));

        return update(balance);
    }

    @Override
    public List<Balance> findAll() {
        Query consulta = getEm().createNamedQuery("Balance.findAll");
        return consulta.getResultList();
    }

    @Override
    public int codigo() {
        return 1;
    }

}
