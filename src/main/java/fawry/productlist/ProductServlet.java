package fawry.productlist;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/product-servlet")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() {
        productService = new ProductService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("action") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            productService.removeProduct(id);
            request.setAttribute("products", productService.listProducts());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } else {
            String name = request.getParameter("name");
            double price;
            try {
                price = Double.parseDouble(request.getParameter("price"));

                Product product = new Product(1, name, price);

                productService.addProduct(product);

                request.setAttribute("products", productService.listProducts());

                request.getRequestDispatcher("list.jsp").forward(request, response);
            } catch (NumberFormatException e) {
                response.sendRedirect("errorPage.html");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productService.listProducts());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}