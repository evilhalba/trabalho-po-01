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


@WebServlet("/EditarClienteServlet")
public class EditarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId = request.getParameter("id");
		
		int id = Integer.parseInt(sId);
		
		DAOClientes daoClientes = new DAOClientes();
		
		Clientes c = daoClientes.buscarDetalhesCliente(id);
		
		request.setAttribute("cliente", c);
		
		
		request.getRequestDispatcher("/WEB-INF/EditarCliente.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid = request.getParameter("id");
		String Nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String cnh = request.getParameter("cnh");
		String tel = request.getParameter("tel");
		String end = request.getParameter("end");
		
		int id = Integer.parseInt(sid);
		
		Clientes c = new Clientes();
		c.setId(id);
		c.setNome(Nome);
		c.setCPF(cpf);
		c.setCNH(cnh);
		c.setTel(tel);
		c.setEnd(end);
		
		
		DAOClientes daoClientes = new DAOClientes();
		
		daoClientes.editarCliente(c);
		
		HttpSession sessao = request.getSession();
		
		sessao.setAttribute("mensagem", "Cliente " + c.getNome()+" editado com sucesso!");
		response.sendRedirect("ListarClientesServlet");
		
		
	}

}
