
<p align="center">
  <img src="https://user-images.githubusercontent.com/59287246/154776706-a039c8a2-1e92-4f15-aed8-850657042dfa.png"/>
</p>
<h1 align="center">
 API REST - fluke-api (Projeto Backend) 
</h1>

<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

<h1 id="objetivo">
	<img src="https://img.icons8.com/external-tal-revivo-color-tal-revivo/24/000000/external-readme-is-a-easy-to-build-a-developer-hub-that-adapts-to-the-user-logo-color-tal-revivo.png"/>
  Descrição
</h1>
Projeto em desenvolvimento, visando adquirir boas práticas de programação com a criação de uma API REST para uma seguradora de veículos.

## Funcionalidades

### CRUD de clientes:
- Dados: Nome Completo, CPF, Cidade e UF;
- Todos os dados são obrigatórios;
- CPF deve ser válido e deve ser único na base.

### CRUD de apólices:
- Dados: Número da apólice, Início de vigência, Fim de vigência, Placa do veículo e Valor da apólice;
- Todos os dados são obrigatórios;
- O número da apólice deve ser gerado aleatoriamente e ser único.

### Consultar uma apólice por número:
- Tela ou endpoint separado dos CRUDs;
- Informar se a apólice venceu ou não;
- Informar quantos dias para vencer, ou há quantos dias venceu;
- Informar placa do veículo e valor da apólice.


<h1 id="documentacao">
<img height="30" src="https://img.icons8.com/color/48/000000/documents.png"/>
  Documentação
</h1>

<p text-align="justify">Foi utilizado o swagger para criação da documentação automática da API. A documentação oficial pode ser encontrada abaixo:
</p>

<a href="">Documentação Oficial</a>

A collection do postman atualizada pode ser importada clicando no botão abaixo:

[![Run in Postman](https://run.pstmn.io/button.svg)]()

<h1 id="tecnologias-dependencias">
<img height="30" src="https://img.icons8.com/fluency/50/000000/administrative-tools.png"/>
	Tecnologias e Dependências
</h1>

<a name = "tech_stack"></a>

- Java 17 - Versão do Java utilizada
- Spring boot 2.6.2 - Framework de desenvolvimento
- Maven - Gerenciador de dependencias
- H2 Database - Database para o ambiente de testes
- Postgres - Database para o ambiente de Produção
- Spring Data Jpa - Abstração orm do spring pra integração com o banco de dados
- Swagger (Open API) - Documentação oficial da API
- Postman - Ferramenta para testes nas requisições
- Lombok - Framework para abstração e melhora na legibilidade do código
- ModelMapper - Facilitar o mapeamento de objetos e diminuir código boilerplate



<h1 id="desenvolvedor">
<img height="30" src="https://img.icons8.com/color/48/000000/devpost.png"/>
  Desenvolvedor
</h1>

<table align="center">
  <tr>
    <td align="center"><a href="https://github.com/oneyottabyte"><img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/oneyottabyte" width="100px;" alt=""/><br /><sub><b>Dorian Vieira</b></sub></a><br /><a href="https://github.com/oneyottabyte" title="Dorian Vieira"></a></td>
  </tr>
</table>
