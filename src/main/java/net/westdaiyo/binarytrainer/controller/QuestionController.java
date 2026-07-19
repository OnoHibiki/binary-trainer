package net.westdaiyo.binarytrainer.controller;
import org.springframework.stereotype.Controller;

import net.westdaiyo.binarytrainer.model.ConversionType;
import net.westdaiyo.binarytrainer.model.Question;
import net.westdaiyo.binarytrainer.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.Normalizer;


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

    // 回答がPOSTで送られてきた時の処理　正誤を判定
    @PostMapping("/check")
    public String checkAnswer(
        @RequestParam("userAnswer") String userAnswer,
        @RequestParam("conversionType") ConversionType conversionType,//displayNameを使うため,CoversionType型として受け取る
        @RequestParam("questionText") String questionText,
        @RequestParam("correctAnswer") String correctAnswer) {
        
        //　正誤判定の処理（大文字小文字も厳格に.全角は半角にしてあげる）
        userAnswer = Normalizer.normalize(userAnswer, Normalizer.Form.NFKC);
        boolean isCorrect = userAnswer.trim().equals(correctAnswer.trim());
        

        System.out.println("変換形式: " + conversionType.getDisplayName());
        System.out.println("問題: " + questionText);
        System.out.println("あなたの回答: " + userAnswer);
        System.out.println("正解: " + correctAnswer);
        System.out.println(isCorrect ? "正解！！" : "不正解...");

        return "redirect:/";
    }

    
    
}
