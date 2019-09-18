CREATE DATABASE locadora;
USE locadora;


CREATE TABLE clientes(
idClientes int NOT NULL AUTO_INCREMENT PRIMARY KEY,
nome_clientes VARCHAR(255),
cpf_clientes VARCHAR(255),
cnh_clientes VARCHAR(255),
tel_clientes VARCHAR(255),
end_clientes VARCHAR(255)
);

CREATE TABLE veiculos(
idVeiculos INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
placa_veiculos VARCHAR(255),
ano_veiculos VARCHAR(255),
vdiaria_veiculos VARCHAR(255),
tipo_veiculos varchar(255)
);

CREATE TABLE carros(
idCarros INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
npassageiros_carros int,
nportas_carros int,
mkm_carros double,
ar_carros int
);


CREATE TABLE veiculos_has_carros(
veiculos_idVeiculos int,
carros_idCarros int,
FOREIGN KEY(veiculos_idVeiculos) REFERENCES veiculos(idVeiculos),
FOREIGN KEY (carros_idCarros) REFERENCES carros(idCarros) 
);

CREATE TABLE cat_onibus(
idCat_onibus int NOT NULL AUTO_INCREMENT PRIMARY KEY,
desc_cat_onibus VARCHAR(255)
);

CREATE TABLE onibus(
idOnibus int NOT NULL AUTO_INCREMENT PRIMARY KEY,
npassageiros_onibus int,
wifi_onibus int,
ar_onibus int,
cat_onibus int,
FOREIGN KEY(cat_onibus) REFERENCES cat_onibus(idCat_onibus)
);

CREATE TABLE veiculos_has_onibus(
veiculos_idVeiculos int,
onibus_idOnibus int,
FOREIGN KEY(veiculos_idVeiculos) REFERENCES veiculos(idVeiculos),
FOREIGN KEY (onibus_idOnibus) REFERENCES onibus(idOnibus) 

);

CREATE TABLE caminhao(
idCaminhao int NOT NULL AUTO_INCREMENT PRIMARY KEY,
neixos_caminhao int,
cmax_caminhao double
);

CREATE TABLE veiculos_has_caminhao(
veiculos_idVeiculos int,
caminhao_idCaminhao int,
FOREIGN KEY(veiculos_idVeiculos) REFERENCES veiculos(idVeiculos),
FOREIGN KEY (caminhao_idCaminhao) REFERENCES caminhao(idCaminhao) 

);

CREATE TABLE locacoes(
idLocacoes int NOT NULL AUTO_INCREMENT PRIMARY KEY,
cliente_locacoes int,
veiculo_locacoes int,
vdiaria_locacoes int,
seguro_locacoes int,
dt_ini_locacoes date,
dt_fim_locacoes date,
FOREIGN KEY(cliente_locacoes) REFERENCES clientes(idClientes), 
FOREIGN KEY(veiculo_locacoes) REFERENCES veiculos(idVeiculos)
);