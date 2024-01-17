# Product List

**Web application task that is part of fawry intern tasks for implementing product list using servlet, JSP, and embedded server tomcat.**

## Requirements
- Create a web project using JEE
- Add a front controller for Managing products (add product, list products, remove product)
- Add a page that lists products, beside each product a delete button.
  - when pressing on it a request should be sent to the front controller to delete this product
- Above the products list an add button that redirects to a new page for adding product.

---

- Application control flow should be as the following:
- `ProductServlet` --> `ProductService` --> `ProductRepository`
- `ProductServlet`: (The front controller) receives requests and displays pages
- `ProductService`: execute validations
- `ProductRepository`: fetch/insert data

---

[Project Demo.webm](https://github.com/Zeyad2003/Product-List/assets/87117386/d8b654ec-0597-442f-bcc7-4ada557b2ba2)

