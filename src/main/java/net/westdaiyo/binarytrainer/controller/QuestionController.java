package net.westdaiyo.binarytrainer.controller;
import org.springframework.stereotype.Controller;
import net.westdaiyo.binarytrainer.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }
    
}
