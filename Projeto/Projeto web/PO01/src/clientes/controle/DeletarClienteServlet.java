package clientes.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clientes.modelo.DAOClientes;


@WebServlet("/DeletarClienteServlet")
public class DeletarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		DAOClientes daoClientes = new DAOClientes();
		
		daoClientes.deletarCliente(id);
		
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("mensagem", "Cliente deletado com sucesso!");
		response.sendRedirect("ListarClientesServlet");
	}

	
	

}
