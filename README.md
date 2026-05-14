# CRUD API - Cliente y Pedido

API REST con Spring Boot y PostgreSQL que implementa CRUD para `Cliente` y `Pedido` con relacion 1:N.

## Requisitos
- Java 21
- Maven
- PostgreSQL en `localhost:5432`

## Configuracion de base de datos
Por defecto la app usa:
- Base: `crud_api`
- Usuario: `postgres`
- Clave: `postgres`

Puedes cambiarlo en `src/main/resources/application.properties`.

## Endpoints
### Clientes
- `GET /api/clientes`
- `GET /api/clientes/{id}`
- `POST /api/clientes`
- `PUT /api/clientes/{id}`
- `DELETE /api/clientes/{id}`

### Pedidos
- `GET /api/pedidos`
- `GET /api/pedidos?clienteId={id}`
- `GET /api/pedidos/{id}`
- `POST /api/pedidos`
- `PUT /api/pedidos/{id}`
- `DELETE /api/pedidos/{id}`

