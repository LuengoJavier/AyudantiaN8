package com.tiendaelectronica.model.data;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import java.sql.Connection;
import static org.jooq.impl.DSL.*;
import static org.jooq.impl.SQLDataType.*;
public class DBGenerator {
    //Metodo inicial para crear una base de datos y sus respectivas tablas en caso de que no exista
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create, nombreBD);
        create = actualizarConexion(connection, nombreBD);
        crearTablaCliente(create);
        crearTablaArticulo(create);
        DBConnector.closeConnection();
    }
    //Metodo para conectarse a una base de datos ya creada
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        return DSL.using(connection);
    }
    //Crea una base de datos en caso de que no exista
    private static void crearBaseDato(DSLContext create, String nombreBD){
        create.createDatabaseIfNotExists(nombreBD).execute();
    }
    //Actualiza la conexion inicial para conectar a la base de datos
    private static DSLContext actualizarConexion(Connection connection,String nombreBD){
        DBConnector.closeConnection();
        connection= DBConnector.connection(nombreBD,"root","");
        DSLContext create =DSL.using(connection);
        return create;
    }
    private static void crearTablaCliente(DSLContext create) {
        create.createTableIfNotExists( "Cliente")
                .column("rut", VARCHAR(12)).constraint(primaryKey("rut"))
                .column("nombre", VARCHAR(100))
                .column("correo", VARCHAR(70)).execute();
    }
    public static void crearTablaArticulo(DSLContext create){
        create.createTableIfNotExists("Articulo")
                .column("id", INTEGER.identity(true)).constraint(primaryKey("id"))
                .column("nombre",VARCHAR(20))
                .column("peso",DOUBLE)
                .column("precio",INTEGER)
                .column("categoria",VARCHAR(25)).execute();
    }
}