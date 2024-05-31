package ru.DmitryOrlov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.DmitryOrlov.model.Products;
import ru.DmitryOrlov.model.Type;
import ru.DmitryOrlov.repository.ProductRepository;
import ru.DmitryOrlov.repository.TypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AppController {

    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "TMK");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "О компании");
        return "about";
    }

    @GetMapping("/product_type")
    public String product_type(Model model){
        Iterable<Type> type = typeRepository.findAll();
        model.addAttribute("title", "Продукция и сервис");
        model.addAttribute("type", type);
        return "product_type";
    }

    @GetMapping("/appeal")
    public String appeal(Model model){
        model.addAttribute("title", "Обратная связь");
        return "appeal";
    }
    @GetMapping("/contacts")
    public String contacts(Model model){
        model.addAttribute("title", "Контакты");
        return "contacts";
    }

    @GetMapping("/facts")
    public String facts(Model model){
        model.addAttribute("title", "Ключевые факты");
        return "facts";
    }

    @GetMapping("/mission")
    public String mission(Model model){
        model.addAttribute("title", "Наша миссия");
        return "mission";
    }

    @GetMapping("/product_type/{id}")
    public String products(@PathVariable(value = "id") long id, Model model){
        Type type = typeRepository.findById(id).orElse(null);
        if (type != null) {
            model.addAttribute("type", type);
            System.out.println(id);
            model.addAttribute("product", productRepository.findByTypeId(id));
        }
        return "products";
    }

}
