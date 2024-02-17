
package udemy.mysql.jdbc;

import domain.Persona;
import java.util.List;

public class MostrarConsulta {
    
    public static void imprimir(List<Persona> lista){
        for(Persona persona: lista){
            System.out.println(persona);
        }        
    }
}
