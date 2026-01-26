package org.example.java4n_sp26_sd20307.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.java4n_sp26_sd20307.entity.Category;
import org.example.java4n_sp26_sd20307.entity.Product;
import org.example.java4n_sp26_sd20307.service.CategoryService;
import org.example.java4n_sp26_sd20307.service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = {
        "/products",
        "/products/new",
        "/products/insert",
        "/products/edit",
        "/products/update"
})
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductService();
    private CategoryService categoryService = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();

        switch (path) {
            case "/products":
                listProducts(request, response);
                break;
            case "/products/new":
                showNewForm(request, response);
                break;
            case "/products/insert":
                insertProduct(request, response);
                break;
            case "/products/edit":
                editProduct(request, response);
                break;
            case "/products/update":
                updateProduct(request, response);
                break;
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Product product = getProductFromForm(request);

        productService.updateProduct(product);

        response.sendRedirect("/products");
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Product product = productService.getProductById(id);
        request.setAttribute("product", product);

        List<Category> categories = categoryService.getCategories();
        request.setAttribute("categories", categories);

        request.setAttribute("categoryId", product.getCategory().getId());

        request.getRequestDispatcher("/view/updateProductForm.jsp").forward(request, response);

    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // read product info from form
        Product product = getProductFromForm(request);

        // save product to DB
        productService.addProduct(product);

        // return view
        response.sendRedirect("/products");

    }

    private Product getProductFromForm(HttpServletRequest request) {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        Double price = Double.parseDouble(request.getParameter("price"));
        Long categoryId = Long.parseLong(request.getParameter("category_id"));

        Category category = categoryService.getCategoryById(categoryId);

        Product product = new Product(id, name, price, category);

        return product;

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Category> categories = categoryService.getCategories();

        request.setAttribute("categories", categories);

        getServletContext()
                .getRequestDispatcher("/view/addProductForm.jsp")
                .forward(request, response);
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get data from db
        List<Product> products = productService.getProducts();

        // send data to view
        request.setAttribute("products", products);
        request.getRequestDispatcher("/view/productList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}