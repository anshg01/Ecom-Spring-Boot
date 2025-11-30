# E-Commerce API Documentation

**Base URL:** `/api`  
**Cross-Origin Enabled:** Yes

---

## Product Schema

```json
{
  "id": "integer",
  "name": "string",
  "brand": "string",
  "price": "number (double)",
  "description": "string",
  "category": "string",
  "releaseDate": "string (format: dd-MM-yyyy)",
  "inStock": "boolean",
  "quantity": "integer",
  "rating": "number (double)",
  "imageUrl": "string (URL to the image)"
}
```

---

## API Endpoints

### 1. Home / Welcome Endpoint
**GET** `/api/`

**Description:** Welcome message endpoint

**Parameters:** None

**Response:**
- **Status:** 200 OK
- **Body:** 
  ```
  Welcome to E-commerce Application
  ```

---

### 2. Get All Products
**GET** `/api/products`

**Description:** Retrieve all products from the database

**Parameters:** None

**Response:**
- **Status:** 200 OK
- **Body:** 
  ```json
  [
    {
      "id": 1,
      "name": "Product Name",
      "brand": "Brand Name",
      "price": 99.99,
      "description": "Product description",
      "category": "Electronics",
      "releaseDate": "29-11-2025",
      "inStock": true,
      "quantity": 50,
      "rating": 4.5,
      "imageUrl": "https://cdn.example.com/images/product.jpg"
    }
  ]
  ```

---

### 3. Get Product by ID
**GET** `/api/products/{productId}`

**Description:** Retrieve a single product by its ID

**Path Parameters:**
- `productId` (integer, required): The unique identifier of the product

**Response:**
- **Status:** 200 OK (if found)
  ```json
  {
    "id": 1,
    "name": "Product Name",
    "brand": "Brand Name",
    "price": 99.99,
    "description": "Product description",
    "category": "Electronics",
    "releaseDate": "29-11-2025",
    "inStock": true,
    "quantity": 50,
    "rating": 4.5,
    "imageUrl": "https://cdn.example.com/images/product.jpg"
  }
  ```
- **Status:** 404 Not Found (if product doesn't exist)

---

### 4. Create New Product
**POST** `/api/products`

**Description:** Add a new product; image is provided as a URL

**Content-Type:** `multipart/form-data` (or `application/json` with `imageUrl` field)

**Parameters:**
- `product` (multipart/form-data or JSON, required): Product object
  ```json
  {
    "name": "Product Name",
    "brand": "Brand Name",
    "price": 99.99,
    "description": "Product description",
    "category": "Electronics",
    "releaseDate": "29-11-2025",
    "inStock": true,
    "quantity": 50,
    "rating": 4.5
  }
  ```
- `imageUrl` (string, required): Publicly accessible URL of the product image

**Response:**
- **Status:** 201 Created (success)
  ```json
  {
    "id": 1,
    "name": "Product Name",
    "brand": "Brand Name",
    "price": 99.99,
    "description": "Product description",
    "category": "Electronics",
    "releaseDate": "29-11-2025",
    "inStock": true,
    "quantity": 50,
    "rating": 4.5,
    "imageUrl": "https://cdn.example.com/images/product.jpg"
  }
  ```
- **Status:** 500 Internal Server Error (if error occurs)
  ```
  Error message
  ```

---

### 5. Get Product Image
**GET** `/api/products/{productId}/image`

**Description:** Retrieve the image URL of a specific product

**Path Parameters:**
- `productId` (integer, required): The unique identifier of the product

**Response:**
- **Status:** 200 OK (if found)
  - **Content-Type:** `text/plain` or `application/json`
  - **Body:** String containing the public image URL, e.g.:
    ```
    https://cdn.example.com/images/product.jpg
    ```
- **Status:** 404 Not Found (if product or image doesn't exist)

---

### 6. Update Product
**PUT** `/api/products/{productId}`

**Description:** Update an existing product; provide `imageUrl` to change image

**Path Parameters:**
- `productId` (integer, required): The unique identifier of the product to update

**Content-Type:** `application/json` or `multipart/form-data`

**Parameters:**
- `product` (request body, required): Updated product object
  ```json
  {
    "name": "Updated Product Name",
    "brand": "Updated Brand",
    "price": 149.99,
    "description": "Updated description",
    "category": "Updated Category",
    "releaseDate": "29-11-2025",
    "inStock": false,
    "quantity": 100,
    "rating": 4.8
  }
  ```
- `imageUrl` (string, optional): New public image URL (if updating the image)

**Response:**
- **Status:** 200 OK (success)
  ```
  Product updated successfully
  ```
- **Status:** 400 Bad Request (if product not found or error occurs)
  ```
  Error message
  ```

---

### 7. Delete Product
**DELETE** `/api/products/{productId}`

**Description:** Delete a product by its ID

**Path Parameters:**
- `productId` (integer, required): The unique identifier of the product to delete

**Response:**
- **Status:** 200 OK (success)
  ```
  Product deleted successfully
  ```
- **Status:** 404 Not Found (if product doesn't exist)
  ```
  Product not found
  ```
- **Status:** 500 Internal Server Error (if error occurs)
  ```
  Error message
  ```

---

### 8. Search Products
**GET** `/api/products/search`

**Description:** Search for products by name, description, brand, or category

**Query Parameters:**
- `searchedQuery` (string, required): The search term

**Response:**
- **Status:** 200 OK
  ```json
  [
    {
      "id": 1,
      "name": "Laptop",
      "brand": "Dell",
      "price": 799.99,
      "description": "High-performance laptop",
      "category": "Electronics",
      "releaseDate": "29-11-2025",
      "inStock": true,
      "quantity": 25,
      "rating": 4.7,
      "imageUrl": "https://cdn.example.com/images/laptop.jpg"
    }
  ]
  ```

---

## HTTP Status Codes

| Status Code | Meaning |
|-------------|---------|
| 200 | OK - Request successful |
| 201 | Created - Resource successfully created |
| 400 | Bad Request - Invalid request parameters |
| 404 | Not Found - Resource not found |
| 500 | Internal Server Error - Server error occurred |

---

## Example Requests (cURL)

### Get all products
```bash
curl -X GET http://localhost:8080/api/products
```

### Get product by ID
```bash
curl -X GET http://localhost:8080/api/products/1
```

### Create a new product
```bash
curl -X POST http://localhost:8080/api/products \
  -F "product={\"name\":\"Laptop\",\"brand\":\"Dell\",\"price\":999.99,\"description\":\"High-end laptop\",\"category\":\"Electronics\",\"releaseDate\":\"29-11-2025\",\"inStock\":true,\"quantity\":10,\"rating\":4.5}" \
  -F "imageUrl=https://cdn.example.com/images/laptop.jpg"
```

### Get product image (returns URL)
```bash
curl -X GET http://localhost:8080/api/products/1/image
```

### Update a product
```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name":"Updated Laptop",
    "brand":"Dell",
    "price":1099.99,
    "description":"Updated description",
    "category":"Electronics",
    "releaseDate":"29-11-2025",
    "inStock":true,
    "quantity":15,
    "rating":4.8,
    "imageUrl":"https://cdn.example.com/images/updated_laptop.jpg"
  }'
```

### Delete a product
```bash
curl -X DELETE http://localhost:8080/api/products/1
```

### Search products
```bash
curl -X GET "http://localhost:8080/api/products/search?searchedQuery=laptop"
```

---

## Notes for Frontend Developers

- All API endpoints are accessible from any origin (CORS enabled)
- Product images are stored as a string URL in the `imageUrl` field (public URL)
- Search functionality searches across: name, description, brand, and category (case-insensitive)
- Date format for `releaseDate` is `dd-MM-yyyy`
- When creating products, include a valid `imageUrl` (publicly accessible)
- When updating products, include `imageUrl` in the body to change the product image
- The `/image` endpoint returns the image URL; you can use it directly as an `<img>` source: `<img src="https://..." />`

