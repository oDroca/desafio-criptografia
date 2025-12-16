# <div align="center"> Desafio Criptografia por [Backend Brasil](https://github.com/backend-br/desafios/blob/master/cryptography/PROBLEM.md) </div>

<picture>
  <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/oDroca/icones-para-readme/main/assets/stack-white.svg" height="40">
  <img alt="Icone java" src="https://raw.githubusercontent.com/oDroca/icones-para-readme/main/assets/stack-black.svg" height="40">
</picture>

<br>

<table>
  <tr align="center">
    <td>
    <picture>
      <source media="(prefers-color-scheme: dark)" srcset="https://raw.githubusercontent.com/oDroca/icones-para-readme/main/icons/java-white.svg" width="50">
      <img alt="Icone java" src="https://raw.githubusercontent.com/oDroca/icones-para-readme/main/icons/java-black.svg" width="50">
    </picture>
    </td>
    <td>
      <picture>
        <source media="(prefers-color-scheme: dark)" srcset="https://cdn.simpleicons.org/spring/white" width="50">
        <img alt="Icone java" src="https://cdn.simpleicons.org/spring/black" width="50">
      </picture>
    </td>
    <td>
      <picture>
        <source media="(prefers-color-scheme: dark)" srcset="https://cdn.simpleicons.org/apachemaven/white" width="50">
        <img alt="Icone java" src="https://cdn.simpleicons.org/apachemaven/black" width="50">
      </picture>
    </td>

  </tr>
  <tr>
    <td> <strong>Java 17</strong> </td>
    <td> <strong>Spring 3.5.8</strong> </td>
    <td> <strong>Maven</strong> </td>
    </tr>
</table>

---

<div id="user-content-toc">
    <ul style="list-style: none;">
        <summary ">
            <h2>Desafio</h2>
        </summary>
    </ul>
</div>

Implementar criptografia de forma transparente. O objetivo é garantir que os campos sensíveis dos objetos de entidade não sejam visíveis diretamente, realizando a criptografia em tempo de execução durante a conversão da entidade para a coluna correspondente no banco de dados, e vice-versa.

Exemplo de tabela no banco de dados considerando que os atributos `userDocument` e `creditCardToken` como campos sensíveis, que devem ser criptografados:
<table>
    <tr><td>id</td> <td>userDocument</td> <td>creditCardToken</td> <td>value</td></tr>
    <tr><td>1</td> <td>MzYxNDA3ODE4MzM=</td> <td>YWJjMTIz</td> <td>5999</td> </tr>
    <tr><td>2</td> <td>MzI5NDU0MTA1ODM=</td> <td>eHl6NDU2</td> <td>1000</td> </tr>
    <tr><td>3</td> <td>NzYwNzc0NTIzODY=</td> <td>Nzg5eHB0bw==</td> <td>1500</td> </tr>
</table>

---

<div id="user-content-toc">
    <ul style="list-style: none;">
        <summary ">
            <h2>Solução</h2>
        </summary>
    </ul>
</div>

Para concluir o desafio eu tive que implementar principalmente o **Attribute Converter** do JPA, essa interface é chamada quando se vai persistir ou recuperar dados. Ela tem dois métodos, onde `convertToDatabaseColumn` é chamado quando for persistir, esse método irá criptografar os dados e enviá-los para o JPA persistir. Já o `convertToEntityAttribute` é chamado durante a leitura, ele irá recuperar os dados criptografados, descriptografá-los e retornar para a API.

A criptografia foi feita utilizando RSA (criptografia assimétrica), sendo necessário ter duas chaves, chave privada e chave pública. A chave pública é usada para criptografar os atributos, já a chave privada para descriptografar os mesmos.

Além disso, tratei globalmente das exceções utilizando **Controller Advice**.