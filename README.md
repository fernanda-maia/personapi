# Person API

&nbsp;
Projeto criado junto com os experts da [Digital Innovation One](https://web.digitalinnovation.one)


&nbsp;
## Tecnologias
* [Java 16](https://docs.oracle.com/en/java/)
* [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [H2 Database](https://www.h2database.com/html/main.html)
* [Apache Maven](https://maven.apache.org/guides/)


&nbsp;
## Como rodar o prjeto
1. Na pasta principal do projeto, execute:

```shell script
mvn spring-boot:run 
```

2. No navegador, acesse:

```
http://localhost:8080/
```


&nbsp;
## Model
### PhoneDTO Model
```json
{
  "id": 1,
  "type": "MOBILE",
  "number": "(99)999999999"
}
```

#### Tipos de dados PhoneDTO
* **id**: Long
* **type**: Enum ("HOME" ,"MOBILE", "COMMERCIAL")
* **number**: String (length: { min: 13, max: 14 })

&nbsp;
### PersonDTO Model

```json
{
  "id": 1,
  "firstName": "John John",
  "lastName": "Florence",
  "cpf": "03274887005",
  "birthDate": "31-10-1990",
  "phones": [
    {
      "id":  1,
      "type": "MOBILE",
      "number": "(99)999999999"
    }
  ]
}
```

#### Tipos de dados PersonDTO
* **id**: Long
* **firstName**: String (length: { min: 3, max: 100 })
* **lastName**: String (length: { min: 3, max: 100 })
* **cpf**: String  (validator: CPF)
* **birthDate**: String (pattern: "dd-MM-yyyy")
* **phones**: List<PhoneDTO>


&nbsp;
### MessageDTO Model
```json
{
  "message": "Created Person with ID 1"
}
```

#### Tipos de dados PhoneDTO
* **message**: String


&nbsp;
## Endpoints 
Método | Rota | Status |Descrição
-------|------ | -------  | -------
GET | api/v1/people | 200 | Retorna um JSON com todos os usuários registrados |
GET | api/v1/people/{id} | 200, 404 | Retorna um JSON com todos os dados do usuário com o id especificado na rota
POST | api/v1/people | 201 | Retorna um MessageDTO no formato JSON
PUT | api/v1/people/{id} | 200, 404 | Retorna um MessageDTO no formato JSON
DELETE | api/v1/people/{id} | 204 , 404 | Nada é retornado