# GerenciadorDeReservas

<p>O GerenciadorDeReservas é uma aplicação Java baseada no framework Spring Boot.</p>
<p>Seu objetivo é ser uma ferramenta capaz de realizar a gestão de reservas de um restaurante, incluindo o cadastro, exclusão, atualização e listagem de clientes e reservas.<p>
 
### Requisitos:
 * Java v11+
 * Spring Boot v2.7.9
 * Banco de Dados H2 v2.1.214

### Principais funcionalidades:

* Cliente:
  * Cliente tem Nome, Email, Telefone e Número de Acompanhantes;
  * Tela de cadastro (inclusão);
  * Tela de vizualização (listagem);
  * Tela de edição (edição e exclusão);

* Administrador:
  * Tela de vizualização das reservas;
  * Tela de edição da fila;

### Iniciando aplicação:

* Interface Web:
  * Após iniciar a aplicação Spring, acesse o endereço [Principal](http://localhost:8080/).
  
* Banco de Dados H2:
  * usuario: sa
  * senha: password
  * [GUI H2](http://localhost:8080/h2-console)

### Layout Interface Web:
