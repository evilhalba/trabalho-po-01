package clientes.controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import clientes.modelo.Clientes;
import clientes.modelo.DAOClientes;


@WebServlet("/AdicionarClienteServlet")
public class AdicionarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/AdicionarCliente.jsp").forward(request, response);
	
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String cnh = request.getParameter("cnh");
		String tel = request.getParameter("tel");
		String end = request.getParameter("end");
		
		
		Clientes c = new Clientes();
		
		c.setNome(Nome);
		c.setCPF(cpf);
		c.setCNH(cnh);
		c.setTel(tel);
		c.setEnd(end);
		
		
		DAOClientes daoClientes = new DAOClientes();
		
		daoClientes.adicionarCliente(c);
		
		HttpSession sessao = request.getSession();
		
		sessao.setAttribute("mensagem", "Cliente cadastrado com sucesso!");
		response.sendRedirect("ListarClientesServlet");
		
		
		
	}

}
