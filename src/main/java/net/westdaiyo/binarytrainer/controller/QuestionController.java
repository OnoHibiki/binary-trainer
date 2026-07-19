package net.westdaiyo.binarytrainer.controller;
import org.springframework.stereotype.Controller;
import net.westdaiyo.binarytrainer.service.QuestionService;

@Controller
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
}
