package com.geekbrains.controllers;

import com.geekbrains.entites.Product;
import com.geekbrains.entites.Student;
import com.geekbrains.repositories.ProductsRepository;
import com.geekbrains.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductsService productsService;
    private ProductsRepository productsList = new ProductsRepository();

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String openCatalog(Model model) {

        ProductsRepository productsList = new ProductsRepository();
        model.addAttribute("products", productsList.getProducts());

        return "catalog";
    }

    @RequestMapping(value = "/products/addProduct", method = RequestMethod.GET)
    public String addProduct(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form-add";
    }

    @RequestMapping("/addProductOpenCatalog")
    public String addProductAndOpenCatalog(Model uiModel, Product product) {
        productsList.addProduct(product);
        uiModel.addAttribute("products", productsList.getProducts());
        return "catalog";
    }

    @RequestMapping("/showProduct")
    public String hello(Model uiModel) {
        uiModel.addAttribute("products", productsList);
        return "products";
    }

    //
    @RequestMapping(path = "/showProductById", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(Model uiModel, @RequestParam int id) {
        Product product = productsService.getProductById(id);
        return product;
    }
    //
    @RequestMapping(path = "/showProductById/{sid}", method = RequestMethod.GET)
    @ResponseBody
    public Product showProductById(@PathVariable("sid") int id) {
        Product product = productsService.getProductById(id);
        return product;
    }
    //
    @RequestMapping(path = "/setProductById", method = RequestMethod.POST)
    public void setProduct(@RequestBody Product product) {
        System.out.println("" + product.getId() + " " + product.getTitle());
    }
    //
    @RequestMapping("/showForm")
    public String showSimpleForm(Model uiModel) {
        Product product = new Product();
        uiModel.addAttribute("product", product);
        return "product-form";
    }

    @RequestMapping("/processFormOpenCatalog")
    public String processFormOpenCatalog(Model uiModel) {
        uiModel.addAttribute("products", productsList.getProducts());
        return "catalog";
    }

}
