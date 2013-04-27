/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilities;

/**
 *
 * @author ebarros
 */

import Dao.Usuario;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Dao.UsuarioDAO;
        
public class Login {
     
    @SuppressWarnings("static-access")
    public static String execute(HttpServletRequest request) {        
        System.out.println("LOGIN!");
        String erro="";        
        String jsp="";        
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        
        Usuario usr = new Usuario();
        UsuarioDAO usrDAO = new UsuarioDAO();        
        try {
            usr = usrDAO.getUserLogin(usuario, senha);
            if(usr == null){
                erro="Usuário não encontrado!";
                request.setAttribute("erro", erro);
                jsp = "/erro.jsp";
            }               
            else{
                request.getSession().setAttribute("codUsuario", usr.getIdUsuario());                
                jsp = "/menu.jsp";
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;        
     }
    
    public static void validarSessao(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        Integer codUsuario = (Integer) request.getSession().getAttribute("codUsuario");
        String jsp="";
        if(codUsuario == null ){
            jsp = "/index.jsp";
             //Redirecionando pagina
            RequestDispatcher rd = request.getRequestDispatcher(jsp);
            rd.forward(request, response);
        }        
    }
}
