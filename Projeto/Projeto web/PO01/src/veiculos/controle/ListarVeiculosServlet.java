package veiculos.controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import veiculos.modelo.DAOVeiculos;
import veiculos.modelo.Veiculo;


@WebServlet("/ListarVeiculosServlet")
public class ListarVeiculosServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOVeiculos daoVeiculos = new DAOVeiculos();
		
		
		List<Veiculo> listav = daoVeiculos.listarVeiculos();
		
		request.setAttribute("veiculos", listav);
		
		request.getRequestDispatcher("/WEB-INF/ListarVeiculos.jsp").forward(request, response);
	
	}
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
