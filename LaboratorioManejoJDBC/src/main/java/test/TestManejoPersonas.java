
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;
import udemy.mysql.jdbc.MostrarConsulta;


public class TestManejoPersonas {
    public static void main(String[] args){
        
           PersonaDAO personaDao = new PersonaDAO();
           
           //Consulta BD
           List<Persona> personas = personaDao.seleccionar();
           MostrarConsulta.imprimir(personas);
           
           //Insercion en BD
//           Persona nuevoUsuario = new Persona("Luis", "Perez", "luis@email.com", 4756812);
//           int filasAfectadas = personaDao.insertar(nuevoUsuario);
//           System.out.println("Cantidad Filas Afectadas: " + filasAfectadas);
//           MostrarConsulta.imprimir(personas);
           
           //Actualizacion campos en BD
//           Persona actualizarCampo = new Persona("Pedro", "Fernandez", "pedro@email.com", 778258);
//           int filasActualizadas = personaDao.actualizar(actualizarCampo, 0);
//           System.out.println("Cantidad Filas Actualizadas: " + filasActualizadas);

            //Eliminar campos en BD
            Persona eliminarPersona = new Persona(5);
            int filasEliminadas = personaDao.eliminar(eliminarPersona);
            System.out.println("filasEliminadas = " + filasEliminadas);
    }
    
    
}
