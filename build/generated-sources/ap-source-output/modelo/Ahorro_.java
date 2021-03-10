package modelo;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Categoria;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-03-09T19:27:14", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Ahorro.class)
public class Ahorro_ { 

    public static volatile SingularAttribute<Ahorro, String> descripcion;
    public static volatile SingularAttribute<Ahorro, Date> fecha;
    public static volatile SingularAttribute<Ahorro, Categoria> categoriaFk;
    public static volatile SingularAttribute<Ahorro, Integer> id;
    public static volatile SingularAttribute<Ahorro, BigDecimal> dineroEntrada;

}