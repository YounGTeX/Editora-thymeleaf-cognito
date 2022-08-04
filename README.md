# Editora-thymeleaf-cognito
Repositório para o desenvolvimento do Trabalho 2 - Segurança da disciplina de Desenvolvimento Web do Curso de Engenharia de Computação da Universidade Estadual de Ponta Grossa


## Grupo

[Marcos Renan Krul](https://github.com/MarcosKrul)

[Renato Cristiano Ruppel](https://github.com/HERuppel)

[Thiago Pankievicz](https://github.com/YounGTeX)

# Documentação

Antes de inicializar a aplicação, lembre de colocar o application.properties com suas credenciais do Amazon AWS nos seguintes diretórios:  
src/main/resources/application.properties  
target/classes/application.properties  

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
Método: GET  
Descrição: lista um artigo na lista de acordo com o ID fornecido.  

Rota 4:
URL: http://localhost:8080/edauth/api/editar{id}{titulo}{resumo}
Método: GET
Descrição: edita um artigo na lista de acordo com o ID, titulo e reusmo fornecido.

Rota 5:  
URL: http://localhost:8080/edauth/api/artigos  
Método: DELETE  
Descrição: lista todos os artigos cujo status=true.  
  
Rota 6:  
URL: http://localhost:8080/edauth/api/artigos/publicados
Método: GET  
Descrição: deleta todos os livros.  
  
Rota 7:  
URL: http://localhost:8080/edauth/api/artigos/publicados/{id}
Método: GET  
Descrição: deleta o livro com id correspondente.  
