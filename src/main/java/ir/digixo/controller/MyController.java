package ir.digixo.controller;

import ir.digixo.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/")
public class MyController {

    List<Product> productList;

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("date", new Date());
        return "home";
    }

    @PostConstruct
    public void loadDate()
    {
        productList = List.of(
                new Product(1l,"fdf","dfdf",new BigDecimal("1000")),
                new Product(2l,"fdf","dfdf",new BigDecimal("1000")),
                new Product(3l,"fdf","dfdf",new BigDecimal("1000")),
                new Product(3l,"fdf","dfdf",new BigDecimal("1000"))
        );
    }
    @GetMapping("products")
    public String products(Model model) {
        model.addAttribute("products", productList);
        return "product";
    }

}
