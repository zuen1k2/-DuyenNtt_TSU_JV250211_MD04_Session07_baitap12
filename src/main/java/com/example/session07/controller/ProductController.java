package com.example.session07.controller;

import com.example.session07.model.Product;
import com.example.session07.service.CategoryService;
import com.example.session07.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String listProducts(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "listProducts";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.findAll());
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, Model model , RedirectAttributes redirectAttributes) {
        if (product.getProductName() == null || product.getCategoryId() == null ||
                product.getDescription() == null || product.getPrice() == null) {
            model.addAttribute("product",product);
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin");
            return "addProduct";
        } else if (productService.checkProductNameExists(product.getProductName())) {
            model.addAttribute("product",product);
            model.addAttribute("error", "Tên sản phẩm đã tồn tại.");
            return "addProduct";
        }
        productService.save(product);
        redirectAttributes.addFlashAttribute("message", "Thêm mới sản phẩm thành công !");
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.findAll());
        return "editProduct";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute Product product, Model model,RedirectAttributes redirectAttributes) {
        Product oldProduct = productService.findById(id);
        if (product.getProductName() == null || product.getCategoryId() == null ||
                product.getDescription() == null || product.getPrice() == null) {
            model.addAttribute("error", "Vui lòng nhập đầy đủ thông tin");
            model.addAttribute("product", product);
            return "editProduct";
        } else if (productService.checkProductNameExists(product.getProductName()) && !oldProduct.getProductName().equalsIgnoreCase(product.getProductName())) {
            model.addAttribute("product",product);
            model.addAttribute("error", "Tên sản phẩm đã tồn tại.");
            return "addProduct";
        }
        product.setProductId(id); // Đảm bảo id không thay đổi
        redirectAttributes.addFlashAttribute("message","Cập nhật sản phẩm thành công !");
        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

}
