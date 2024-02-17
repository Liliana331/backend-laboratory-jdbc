
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;
import udemy.mysql.jdbc.MostrarConsulta;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        //crea objeto para hacer las consultas
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
        //insertar usuarios
//        Usuario usuarioNuevo = new Usuario("miguel@email.com", "miguelito5");
//        Usuario usuarioNuevo = new Usuario("Margareth@email.com", "magola45");
//        int registrosInsertados = usuarioDao.insertar(usuarioNuevo);
//        System.out.println("registrosInsertados = " + registrosInsertados);


        //actualizar usuarios
//        Usuario actualizarUsuario = new Usuario(1, "manuel@email.com", "manu78");
//        int registrosActualizados = usuarioDao.actualizar(actualizarUsuario);
//        System.out.println("registrosActualizados = " + registrosActualizados);

        //eliminar usuarios
//        Usuario eliminarUsuario = new Usuario(4);
//        int usuariosEliminados = usuarioDao.eliminar(eliminarUsuario);
//        System.out.println("usuariosEliminados = " + usuariosEliminados);
        
        //retorna lista de la consulta y se imprime
        List<Usuario> listaUsuarios = usuarioDao.seleccionar();
        MostrarConsulta.imprimir(listaUsuarios);
        

    }
}
