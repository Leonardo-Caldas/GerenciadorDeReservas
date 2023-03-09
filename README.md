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

 ![image](https://user-images.githubusercontent.com/26657986/223898783-88ab1722-bdf5-4b76-ab7c-caaa3c52a5d7.png)
 *HomePage*

![image](https://user-images.githubusercontent.com/26657986/223898992-7a792f99-4e73-4ad3-9d82-716e738ac7e0.png)
*Cadastro de Cliente*

![image](https://user-images.githubusercontent.com/26657986/223899066-b7fe35a6-1d2e-4d46-b7af-1954d3767c6b.png)
*Add Cliente*

![image](https://user-images.githubusercontent.com/26657986/223899125-8cf7e548-d2dd-4aaa-90c9-41d7a22e7640.png)
*Atualizar Cliente*

![image](https://user-images.githubusercontent.com/26657986/223899173-588098ed-2816-416b-834c-fecd4eba5c18.png)
*Excluir Cliente*
