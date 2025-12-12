# <div align="center"> Desafio Criptografia por [Backend Brasil](https://github.com/backend-br/desafios/blob/master/cryptography/PROBLEM.md) </div>

Desafio: Implementar a criptografia num serviço de forma transparente para a API e para as camadas de serviço da sua aplicação. O objetivo é garantir que os campos sensíveis dos objetos de entidade não sejam visíveis diretamente, realizando a criptografia em tempo de execução durante a conversão da entidade para a coluna correspondente no banco de dados, e vice-versa.

Exemplo de tabela considerando os atributos `userDocument` e `creditCardToken` como campos sensíveis, que devem ser criptografados:
<table>
    <tr><td>id</td> <td>userDocument</td> <td>creditCardToken</td> <td>value</td></tr>
    <tr><td>1</td> <td>MzYxNDA3ODE4MzM=</td> <td>YWJjMTIz</td> <td>5999</td> </tr>
    <tr><td>2</td> <td>MzI5NDU0MTA1ODM=</td> <td>eHl6NDU2</td> <td>1000</td> </tr>
    <tr><td>3</td> <td>NzYwNzc0NTIzODY=</td> <td>Nzg5eHB0bw==</td> <td>1500</td> </tr>
</table>

Tipo dos atributos:
<table>
    <tr><td>Atributo</td> <td>Tipo</td> </tr>
    <tr><td>id</td> <td>Long</td> </tr>
    <tr><td>userDocument</td> <td>String</td> </tr>
    <tr><td>creditCardToken</td> <td>String</td> </tr>
    <tr><td>value</td> <td>Long</td> </tr>
</table>