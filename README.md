# 📦 E-Commerce API (Lab 7)

## 👨‍💻 Author

Judy Marie Dizon
Shella Colele

## 📌 Description

REST API using Spring Boot with in-memory storage.

---

## 🚀 How to Run

1. Open project
2. Run Spring Boot app
3. Access API via Postman

---

## 🔗 API Endpoints

| Method | Endpoint              | Description |
| ------ | --------------------- | ----------- |
| GET    | /api/v1/products      | Get all     |
| GET    | /api/v1/products/{id} | Get by ID   |
| POST   | /api/v1/products      | Create      |
| PUT    | /api/v1/products/{id} | Update      |
| DELETE | /api/v1/products/{id} | Delete      |

---

## ⚠️ Limitations

* Uses in-memory storage (data lost on restart)

---

## 🧪 API Testing (No Screenshot Version)

Below are sample test cases performed using Postman.

---

### ✅ 1. Create Product (POST)

**Request**

```http
POST /api/v1/products
Content-Type: application/json
```

**Body**

```json
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000,
  "category": "Electronics",
  "stockQuantity": 10
}
```

**Response (201 Created)**

```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 50000,
  "category": "Electronics",
  "stockQuantity": 10
}
```

---

### ✅ 2. Get All Products (GET)

**Request**

```http
GET /api/v1/products
```

**Response (200 OK)**

```json
[
  {
    "id": 1,
    "name": "Laptop",
    "price": 50000
  }
]
```

---

### ✅ 3. Get Product by ID (GET)

**Request**

```http
GET /api/v1/products/1
```

**Response (200 OK)**

```json
{
  "id": 1,
  "name": "Laptop",
  "price": 50000
}
```

---

### ❌ 4. Get Invalid ID

**Request**

```http
GET /api/v1/products/999
```

**Response (404 Not Found)**

```json
{
  "error": "Product not found"
}
```

---

### ✅ 5. Update Product (PUT)

**Request**

```http
PUT /api/v1/products/1
Content-Type: application/json
```

**Body**

```json
{
  "name": "Updated Laptop",
  "price": 55000
}
```

**Response (200 OK)**

```json
{
  "id": 1,
  "name": "Updated Laptop",
  "price": 55000
}
```

---

### ✅ 6. Delete Product (DELETE)

**Request**

```http
DELETE /api/v1/products/1
```

**Response (204 No Content)**

---

### ✅ 7. Filter Products

**Request**

```http
GET /api/v1/products/filter?filterType=name&filterValue=Laptop
```

**Response (200 OK)**

```json
[
  {
    "id": 1,
    "name": "Laptop"
  }
]
```

---

### ❌ 8. Invalid Data (Validation)

**Request**

```http
POST /api/v1/products
```

**Body**

```json
{
  "name": "",
  "price": -10
}
```

**Response (400 Bad Request)**

```json
{
  "error": "Invalid input data"
}
```

---

## 📝 Notes

* All endpoints were tested using Postman
* Proper HTTP status codes were returned:

  * 200 OK
  * 201 Created
  * 204 No Content
  * 400 Bad Request
  * 404 Not Found
