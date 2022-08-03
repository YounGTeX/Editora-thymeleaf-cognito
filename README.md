# Editora-thymeleaf-cognito
Repositório para o desenvolvimento do Trabalho 2 - Segurança da disciplina de Desenvolvimento Web do Curso de Engenharia de Computação da Universidade Estadual de Ponta Grossa


## Grupo

[Marcos Renan Krul](https://github.com/MarcosKrul)

[Renato Cristiano Ruppel](https://github.com/HERuppel)

[Thiago Pankievicz](https://github.com/YounGTeX)

# Documentação

Link inicial: http://localhost:8080/edauth/

Rota 1:
URL: http://localhost:8080/edauth/api/artigos

Método: GET

Descrição: retorna uma lista com livros.

Rota 2:  
URL: http://localhost:8080/edauth/api/artigos  
Método: POST  
Descrição: registra um artigo na lista.  
Body:  
{  
  "id": 74,  
  "titulo": "Eragon",  
  "resumo": "Um antigo Cavaleiro de Dragão que traiu seu povo e seus companheiros em busca de poder.",  
  "status": "true"  
}  
  
Rota 3:  
URL: http://localhost:8080/edauth/api/artigos/{id}  
Método: PUT  
Descrição: edita um artigo na lista de acordo com o ID fornecido.  
Body:  
{  
  "id": 74,  
  "titulo": "Eragon",  
  "resumo": "Um antigo Cavaleiro de Dragão que traiu seu povo e seus companheiros em busca de poder.",  
  "status": "true"  
}  

Rota 4:
URL: http://localhost:8080/edauth/api/artigos/publicados
Método: DELETE
Descrição: delete todos os artigos presentes na lista.

Rota 4:  
URL: http://localhost:8080/edauth/api/artigos/publicados/{id}  
Método: DELETE  
Descrição: Deleta da lista o livro correspondente ao ID fornecido.  
  
Rota 6:  
URL: http://localhost:8080/edauth/api/artigos/{id}  
Método: GET  
Descrição: retorna o livro com ID correspondente.  
  
Rota 6:  
URL: http://localhost:8080/edauth/api/artigos/publicados  
Método: GET  
Descrição: retorna todos os livros cujo status seja true.  
