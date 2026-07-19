package net.westdaiyo.binarytrainer.controller;
import org.springframework.stereotype.Controller;

import net.westdaiyo.binarytrainer.model.ConversionType;
import net.westdaiyo.binarytrainer.model.Question;
import net.westdaiyo.binarytrainer.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


@Controller
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // ルートURLへのGETリクエスト処理　問題を生成してHTMLへ渡す
    @GetMapping("/")
    public String index(Model model) {
        Question question = questionService.createQuestion(ConversionType.DECIMAL_TO_BINARY);
        model.addAttribute("question", question);

        return "index";
    }
    
}
