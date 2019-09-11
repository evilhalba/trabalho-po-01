package clientes.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import clientes.modelo.Clientes;
import clientes.modelo.DAOClientes;


@WebServlet("/DetalhesClienteServlet")
public class DetalhesClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sId = request.getParameter("id");
		int id = Integer.parseInt(sId);
		
		DAOClientes daoClientes = new DAOClientes();
		
		Clientes c = daoClientes.buscarDetalhesCliente(id);
		
		request.setAttribute("cliente", c);
		
		request.getRequestDispatcher("/WEB-INF/DetalhesCliente.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
