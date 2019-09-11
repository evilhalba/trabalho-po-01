package clientes.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientes.modelo.Clientes;
import clientes.modelo.DAOClientes;


@WebServlet("/ListarClientesServlet")
public class ListarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOClientes daoClientes = new DAOClientes();
		
		List<Clientes> lista = daoClientes.listarClientes();
		
		request.setAttribute("clientes", lista);

		
		
		request.getRequestDispatcher("/WEB-INF/ListarClientes.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

}
