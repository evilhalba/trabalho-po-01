<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src='http://code.jquery.com/jquery-2.1.3.min.js'></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="https://use.fontawesome.com/2e0b062519.js"></script>

<title>Detalhes de ${ cliente.nome }</title>
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
      <a class="navbar-brand" href="#">Sistema de Loca��o</a>
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li ><a href="HomeServlet">In�cio <span class="sr-only"></span></a></li>
        <li class="active" class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cliente <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li class="active"><a href="<c:url value="/ListarClientesServlet"/>">Listar</a></li>
            <li><a href="<c:url value="/AdicionarClienteServlet"/>">Adicionar</a></li>
          </ul>
        </li> 
         <li  class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Loca��o <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li ><a href="<c:url value="/ListarLocacaoServlet"/>">Listar</a></li>
            <li ><a href="<c:url value="/AdicionarLocacaoServlet"/>">Adicionar Loca��o</a></li>
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
</br>


<a href="<c:url value="/ListarClientesServlet"/>">Voltar</a>





<h1>Detalhes de ${ cliente.nome }</h1>


<div class="row">
  	  <div class="form-group col-md-4">
  	  	<label for="nome">Nome:</label>
  	  	<input type="text" class="form-control" id="nome" name="nome" placeholder="Nome"  value="${ cliente.nome }" readonly>
  	  </div>
	  <div class="form-group col-md-4">
  	  	<label for="CPF">CPF:</label>
  	  	<input type="text" class="form-control" id="CPF"  name="CPF" placeholder="CPF" value="${ cliente.CPF }" readonly>
  	  </div>
	  <div class="form-group col-md-4">
  	  	<label for="CNH">CNH:</label>
  	  	<input type="text" class="form-control" id="CNH" name="CNH" placeholder="CNH" value="${ cliente.CNH }" readonly>
  	  </div>
	</div>
	
	<div class="row">
  	  <div class="form-group col-md-3">
  	  	<label for="telefone">Telefone:</label>
  	  	<input type="text" class="form-control" id="telefone" name="telefone" placeholder="Telefone" value="${ cliente.tel }" readonly>
  	  </div>
  	  
  	  <div class="row">
  	  <div class="form-group col-md-3">
  	  	<label for="Endereco">Endere�o:</label>
  	  	<input type="text" class="form-control" id="Endereco" name="Endereco" placeholder="Endereco" value="${ cliente.end }" readonly>
  	  </div>
	 
	 </div>
	<div class="col-md-12">
	  	<a href="<c:url value="EditarClienteServlet?id=${cliente.id }" />"><button type="button" class="btn btn-primary"><i class="fa fa-pencil" aria-hidden="true"></i> Editar</button></a>
					<a href="<c:url value="DeletarClienteServlet?id=${cliente.id }"  />" onclick="return confirm('Deseja realmente deletar?')"><button type="button" class="btn btn-danger"><i class="fa fa-trash" aria-hidden="true"></i> Deletar</button></a>
	  </div>
	  <br>
	  <br>
	<hr />
<br>
<br>



