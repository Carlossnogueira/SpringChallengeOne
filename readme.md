# 🚀 Desafio de API REST com Spring Boot

Este desafio simula um **cenário real de desenvolvimento backend**, parecido com testes técnicos de empresas e desafios de banco, mas pensado para **estudo progressivo**.

A ideia é você **rever Spring do zero**, praticar boas práticas e evoluir a API aos poucos, sem pular etapas.

---

## 🎯 Objetivo do Desafio

Construir uma **API RESTful** para gerenciamento de **Pessoas e Contatos**, aplicando:

* Arquitetura em camadas
* Validação de dados
* Exceções padronizadas
* Boas práticas REST
* Código limpo e evolutivo


---

## 🧠 Contexto (Simulação Real)

Uma empresa precisa de um sistema interno para **gerenciar pessoas cadastradas** e seus **contatos** (e-mail, telefone, etc).

Esse sistema será consumido futuramente por:

* um front-end web
* um aplicativo mobile

Por isso, a API precisa ser:

* previsível
* bem validada
* segura contra dados inválidos

---

## 🧱 Escopo Inicial (MVP)

### 📌 Entidade Pessoa

Uma pessoa deve possuir:

* `id` (UUID ou Long)
* `name` (obrigatório, mínimo 3 caracteres)
* `email` (obrigatório, único, válido)
* `birthDate` (opcional)
* `createdAt`
* `updatedAt`

---

## 🔌 Endpoints Esperados

### ➕ Criar pessoa

* `POST /persons`

Regras:

* Não permitir e-mail duplicado
* Nome inválido deve gerar erro de validação

---

### 📄 Listar pessoas

* `GET /persons`

Regras:

* Retornar lista paginada
* Ordenação por nome (opcional)

---

### 🔍 Buscar pessoa por ID

* `GET /persons/{id}`

Regras:

* Retornar erro 404 se não existir

---

### ✏️ Atualizar pessoa

* `PUT /persons/{id}`

Regras:

* Não permitir alterar e-mail para um já existente
* Atualizar `updatedAt`

---

### ❌ Remover pessoa

* `DELETE /persons/{id}`

Regras:

* Não permitir remover pessoa inexistente

---

## 🧩 Regras de Negócio Essenciais

* E-mail deve ser único
* Nome não pode ser vazio ou muito curto
* Regras de negócio **não ficam no controller**
* Service é responsável por validar fluxo

---

## ⚠️ Validação de Dados

Utilizar **Bean Validation**:

* `@NotBlank`
* `@Email`
* `@Size`
* Validações customizadas quando necessário

Validações devem ocorrer:

* No DTO de entrada
* Antes de executar regras de negócio

---

## 🚨 Tratamento de Erros (Obrigatório)

A API deve possuir:

### ✅ Exceções padronizadas

* Uma exceção base (`ApiException`)
* Exceções específicas (ex: `ResourceNotFoundException`)

### ✅ Handler global

* Uso de `@ControllerAdvice`
* Nunca retornar stacktrace

### 📦 Formato padrão de erro

Exemplo:

```json
{
  "timestamp": "2026-02-01T10:00:00",
  "status": 400,
  "error": "Bad Request",
  "message": "E-mail já cadastrado",
  "path": "/persons"
}
```

---

## 🏗️ Arquitetura Esperada

Separação clara de responsabilidades:

* controller
* service
* repository
* dto
* exception
* handler

Controllers:

* recebem request
* retornam response

Services:

* contêm regras de negócio
* lançam exceções

Repositories:

* apenas acesso a dados

---

## 🧪 Testes (Opcional, mas recomendado)

* Testes unitários de service
* Testes de validação
* Testes de exceção

Ferramentas sugeridas:

* JUnit
* Mockito

---

## 🌱 Evoluções Futuras (Opcional)

* Autenticação JWT
* Versionamento de API (`/api/v1`)
* Documentação com Swagger/OpenAPI
* Relacionamento Pessoa → Contatos

---

## 📌 Critérios de Qualidade

✔ Código legível
✔ Nomes claros
✔ Sem lógica no controller
✔ Erros bem tratados
✔ Commits pequenos e descritivos

---

## 🧭 Objetivo Final

Ao concluir este desafio, você deve ser capaz de:

* Criar APIs REST profissionais com Spring
* Estruturar exceções e validações corretamente
* Entender onde cada regra deve viver
* Evoluir um projeto sem quebrar tudo

---

## 💡 Dica Final


Esse desafio foi feito para **ser revisitado várias vezes**, sempre adicionando mais maturidade ao código.
