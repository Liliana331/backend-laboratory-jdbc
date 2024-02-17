package datos;

import domain.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
Persona: es una clase dominio o entidad, ya que tiene representacion en BD
a la clase que hace las operaciones como: seleccionar, eliminar, insertar o actualizar sobre la clase de entidad se conoce como DAO.
DAO: Data Access Object, clase que realiza las operaciones sobre la clase de entidad, se crea una clase por cada clase entidad

executeUpdate: puede ejecutar sentencias insert, update o delete
 */
public class PersonaDAO {

    //sentencias de la BD
    public static final String SQL_SELECT = "SELECT id, nombre, apellido, email, telefono FROM udemy.persona";
    public static final String SQL_INSERT = "INSERT INTO udemy.persona (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    public static final String SQL_UPDATE = "UPDATE udemy.persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id = ?";
    public static final String SQL_DELETE = "DELETE FROM udemy.persona WHERE id = ?";

    //se define metodo que va a devolver una lista de tipo Persona
    public List<Persona> seleccionar() {
        List<Persona> personas = new ArrayList<>();
        Persona persona = null;
        Connection conexion = null;
        PreparedStatement registro = null;
        ResultSet resultado = null;
        try {
            conexion = Conexion.getConnection();
            registro = conexion.prepareStatement(SQL_SELECT);
            resultado = registro.executeQuery();
            while (resultado.next()) {
                persona = new Persona(
                        resultado.getInt("id"),
                        resultado.getString("nombre"),
                        resultado.getString("apellido"),
                        resultado.getString("email"),
                        resultado.getInt("telefono")
                );
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(resultado);
            Conexion.close(registro);
            Conexion.close(conexion);
        }
        return personas;
    }
    
    public int insertar(Persona persona){
        Connection conexion = null;
        PreparedStatement registro = null;
        int registrosAfectados = 0;  //devuelve cantidad de registros afectados
        
        try {
            //se establece conexion a la BD
            conexion = Conexion.getConnection();
            registro = conexion.prepareStatement(SQL_INSERT);
            
            //se extrae cada campo del dominio Persona, que será lo que se insertará en la BD y con setTipo(indexBD, datoAInsertar) se inserta
            registro.setString(1, persona.getNombre());
            registro.setString(2, persona.getApellido());
            registro.setString(3, persona.getEmail());
            registro.setInt(4, persona.getTelefono());
            
            //se obtiene cantidad de registros afectados
            registrosAfectados = registro.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(registro);
            Conexion.close(conexion);
        }
         return registrosAfectados;   
    }
    
    public int actualizar(Persona persona, int idPersona){
        Connection conexion = null;
        PreparedStatement registro = null;
        int registrosAfectados = 0;
                
        try {
            //se establece conexion
            conexion = Conexion.getConnection();
            registro = conexion.prepareStatement(SQL_UPDATE);
            
            //se extraen los datos de persona para prepararlos para enviarlos a la BD
            registro.setString(1, persona.getNombre());
            registro.setString(2, persona.getApellido());
            registro.setString(3, persona.getEmail());
            registro.setInt(4, persona.getTelefono());
            
            //para el argumento de idPersona
            registro.setInt(5, idPersona);
            
            //se ejecuta la consulta finalmente con todos los elementos ya definidos y listos
            registrosAfectados = registro.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(registro);
            Conexion.close(conexion);
        }
         return registrosAfectados;
    }

    public int eliminar(Persona persona){
        Connection conexion = null;
        PreparedStatement registro = null;
        int camposEliminados = 0;
                
        try {
            conexion = Conexion.getConnection();
            registro = conexion.prepareStatement(SQL_DELETE);
            
            registro.setInt(1, persona.getId());
            
            camposEliminados = registro.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(registro);
            Conexion.close(conexion);
        }
        
        return camposEliminados;
    }
    
}
