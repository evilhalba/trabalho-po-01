<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://use.fontawesome.com/2e0b062519.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Veiculos</title>
</head>
<body>
<div class="container">
 <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Sistema de Locação</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li ><a href="HomeServlet">Início <span class="sr-only"></span></a></li>
        <li class="active" class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cliente <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li class="active"><a href="<c:url value="/ListarClientesServlet"/>">Listar</a></li>
            <li><a href="<c:url value="/AdicionarClienteServlet"/>">Adicionar</a></li>
          </ul>
        </li> 
         <li  class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Locação <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li ><a href="<c:url value="/ListarLocacaoServlet"/>">Listar</a></li>
            <li ><a href="<c:url value="/AdicionarLocacaoServlet"/>">Adicionar Locação</a></li>
          </ul>
        </li>
        <li  class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Veiculos <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li ><a href="<c:url value="/ListarVeiculosServlet"/>">Listar</a></li>
            <li ><a href="<c:url value="/AdicionarVeiculoServlet"/>">Adicionar Veiculo</a></li>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="LogoutServlet">Sair <i class="fa fa-sign-out" aria-hidden="true"></i></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<c:if test="${ not empty mensagem }" >
		<div class="alert alert-success" role="alert"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span> ${mensagem }</div>
		<c:remove var="mensagem"/>
	</c:if>


 <table class="table table-bordered">
<thead>
		<tr>
			<th>Placa</th>
			<th>Ano</th>
			<th>Vlr diaria</th>
			<th>tipo</th>
			<th>Opções</th>
			
		</tr>
			</thead>
		  <tbody>
		<c:forEach items="${ veiculos }" var="v"> 
			<tr>
				<td>${ v.placa_veiculos }</td>
				<td>${ v.ano_veiculos }</td>
				<td>${ v.vdiaria_veiculos }</td>
				<td>${ v.tipo_veiculos }</td>
				
				<td>
					<a href="<c:url value="/DetalhesClienteServlet?id=${v.idVeiculos }" />"><button type="button" class="btn btn-primary"><i class="fa fa-pencil" aria-hidden="true"></i> Detalhes</button></a>
					<a href="<c:url value="/DeletarClienteServlet?id=${v.idVeiculos }"  />" onclick="return confirm('Deseja realmente deletar?')"><button type="button" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Deletar</button></a>
					
				</td>
			</tr>
		</c:forEach>
	 </tbody>
	</table>


</div>

</body>
</html>