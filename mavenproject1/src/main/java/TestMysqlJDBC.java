
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMysqlJDBC {

    public static void main(String[] args) {
        //System.out.println("Hola JDBC");
        String url = "jdbc:mysql://localhost:3306/udemy?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        String user = "root";
        String password = "root";
        
        String consultaSelect = "SELECT nombre, apellido FROM udemy.persona";
        String update = "UPDATE udemy.persona SET nombre = 'Maria' WHERE id = 1";
        
        /*
        Connection: para establecer conexion con BD
        Statement: para poder ejecutar sentencias o instrucciones en la BD
        ResultSet: para almacenar el resultado de la consulta a BD, puede arrojar mas de un resultado, se puede iterar con while, se debe llamar cada columna
        executeQuery: ejecucion de query
        executeUpdate: actualizacion en BD
        */
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//linea no usada pero podría necesitarse para conectar con aplicaciones web
            Connection conexion = DriverManager.getConnection(url, user, password);
            Statement instruccion = conexion.createStatement();
            ResultSet resultado = instruccion.executeQuery(consultaSelect);
            while(resultado.next()){
                System.out.print("Nombre = " + resultado.getString("nombre"));
                System.out.print(", Apellido: " + resultado.getString("apellido"));
                System.out.println("");
            }
            
            //Modificar un campo de la BD
            int modificar = instruccion.executeUpdate(update);
            System.out.println("Total campos modificados = " + modificar);
            
            //se deben cerrar las conexiones en orden inverso
            resultado.close();
            instruccion.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace(System.out);
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
}
