package modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Categoria;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-03-09T19:27:14", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Gasto.class)
public class Gasto_ { 

    public static volatile SingularAttribute<Gasto, String> descripcion;
    public static volatile SingularAttribute<Gasto, Date> fecha;
    public static volatile SingularAttribute<Gasto, BigDecimal> dineroGastado;
    public static volatile SingularAttribute<Gasto, Categoria> categoriaFk;
    public static volatile SingularAttribute<Gasto, Integer> id;

}