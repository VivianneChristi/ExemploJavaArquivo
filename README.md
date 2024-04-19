# Sistema de Gerenciamento de Usuários e Produtos
- Este é um sistema simples de gerenciamento de usuários e produtos desenvolvido em Java. Ele permite realizar operações básicas como criar, editar, deletar, listar e buscar usuários e produtos.

# Estrutura do Projeto
- O projeto está organizado em três pacotes principais:

- models: Contém as classes de modelo para representar usuários e produtos.
- sistema: Contém a classe principal do sistema.
- utils: Contém as classes utilitárias para manipulação de arquivos e gerenciamento de usuários e produtos.

# Funcionalidades
### Gerenciamento de Usuários
- Criar um novo usuário com nome e senha.
- Editar os dados de um usuário existente.
- Deletar um usuário.
- Listar todos os usuários cadastrados.
- Buscar um usuário pelo seu ID.
- Trocar a senha de um usuário.
### Gerenciamento de Produtos
- Criar um novo produto com nome, preço e quantidade.
- Editar os dados de um produto existente.
- Deletar um produto.
- Listar todos os produtos cadastrados.
- Buscar um produto pelo seu ID.
- Somar o valor total dos produtos em estoque.
- Contar a quantidade total de produtos em estoque.
# Utilização
- Para utilizar o sistema, execute a classe Sistema presente no pacote sistema. O sistema apresentará um menu com opções para operações de usuários e produtos. Basta seguir as instruções apresentadas no console.

# Armazenamento de Dados
- Os dados de usuários são armazenados no arquivo usuarios.txt, enquanto os dados de produtos são armazenados no arquivo produtos.txt. Os arquivos são criados automaticamente caso não existam.
