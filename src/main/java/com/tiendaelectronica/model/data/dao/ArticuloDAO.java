package com.tiendaelectronica.model.data.dao;

import com.tiendaelectronica.model.Articulo;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class ArticuloDAO {
    public static void registarArticulo(DSLContext query, Articulo articulo){
        Table tablaArticulo= table(name("Articulo"));
        Field[] columnas = tablaArticulo.fields("id","nombre","peso","precio","categoria");
        query.insertInto(tablaArticulo, columnas[0], columnas[1],columnas[2], columnas[3], columnas[4])
                .values(articulo.getId(),articulo.getNombre(),articulo.getPeso(),
                        articulo.getPrecio(),articulo.getCategoria()).execute();
    }

    public static List obtenerArticulo(DSLContext query, String columnaTabla, Object dato){
        Result resultados = query.select().from(DSL.table("Articulo")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaArticulos(resultados);
    }
    private static List obtenerListaArticulos(Result resultados){
        List<Articulo> articulos= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            int id = (Integer) resultados.getValue(fila,"id");
            String nombre = (String) resultados.getValue(fila,"nombre");
            double peso = (Double) resultados.getValue(fila, "peso");
            int precio = (Integer) resultados.getValue(fila, "precio");
            String categoria = (String) resultados.getValue(fila,"categoria");
            articulos.add(new Articulo(id,nombre,peso,precio,categoria));
        }
        return articulos;
    }
    public static void modificarArticulo(DSLContext query, int id, String columnaTabla, Object dato){
        query.update(DSL.table("Articulo")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("id").eq(id)).execute();
    }

}