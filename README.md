# API REST de Cadastro de Usuários e Veículos

### O desafio proposto é desenvolver uma API REST que precisará controlar veículos de usuários. <br>

- [x] O **primeiro passo** deve ser a construção de um cadastro de usuários, sendo obrigatórios: nome, e-mail, CPF e data de nascimento, sendo que e-mail e CPF devem ser únicos. <br>
- [x] O **segundo passo** é criar um cadastro de veículos, sendo obrigatórios: Marca, Modelo do Veículo e Ano. E o serviço deve consumir a API da FIPE (https://deividfortuna.github.io/fipe/) para obter os dados do valor do veículo baseado nas informações inseridas. <br>
- [x] O **terceiro passo** é criar um endpoint que retornará um usuário com a lista de todos seus veículos cadastrados.<br>
No endpoint que listará seus veículos, devemos considerar algumas configurações a serem exibidas para o usuário final. Vamos criar dois novos atributos no objeto do carro, sendo eles:<br>

- [x] **1) Dia do rodízio deste carro, baseado no último número do ano do veículo, considerando as condicionais:**<br>
Final 0-1: segunda-feira<br>
Final 2-3: terça-feira<br>
Final 4-5: quarta-feira<br>
Final 6-7: quinta-feira<br>
Final 8-9: sexta-feira<br>

- [x] **2) Também devemos criar um atributo de rodízio ativo, que compara a data atual do sistema com as condicionais anteriores e, quando for o dia ativo do rodizio, retorna true; caso contrario, false.**

# Collection para testes

Eu disponibilizei uma [collection](https://github.com/analugmrs/desafio-orange/blob/main/Cadastro%20de%20Usuários%20e%20Ve%C3%ADculos.postman_collection.json) para facilitar a realização dos testes no Postman. 

# Considerações

Post mais detalhado sobre no [medium](https://analugmrs.medium.com/api-rest-o-que-são-pra-que-servem-como-são-desenvolvidas-b7d2f040c6f8).
