package modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Ahorro;
import modelo.Gasto;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-03-16T19:19:57", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> tipo;
    public static volatile SingularAttribute<Categoria, Integer> id;
    public static volatile CollectionAttribute<Categoria, Ahorro> ahorroCollection;
    public static volatile SingularAttribute<Categoria, String> nombre;
    public static volatile CollectionAttribute<Categoria, Gasto> gastoCollection;

}