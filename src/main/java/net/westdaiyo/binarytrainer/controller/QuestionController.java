package net.westdaiyo.binarytrainer.controller;
import org.springframework.stereotype.Controller;

import net.westdaiyo.binarytrainer.model.ConversionType;
import net.westdaiyo.binarytrainer.model.Question;
import net.westdaiyo.binarytrainer.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class QuestionController {
    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // 通常アクセスでは問題を生成し、回答後のリダイレクトでは正誤結果だけを表示する
    @GetMapping("/")
    public String index(Model model) {
        // 全６種類の変換処理問題からランダムで出題　（回答直後は新しい問題を生成しない）
        if(!model.containsAttribute("isCorrect")){
            Question question = questionService.createRandomQuestion();
            model.addAttribute("question", question);
        }
        return "index";
    }

    // 正誤を判定
    @PostMapping("/check")
    public String checkAnswer(
        @RequestParam("userAnswer") String userAnswer,
        @RequestParam("conversionType") ConversionType conversionType,//displayNameを使うため,CoversionType型として受け取る
        @RequestParam("questionText") String questionText,
        @RequestParam("correctAnswer") String correctAnswer,
        RedirectAttributes redirectAttributes) {
        
        //　正誤判定の処理（大文字小文字どちらでもOK.全角は半角にしてあげる）
        boolean isCorrect = questionService.isCorrectAnswer(userAnswer, correctAnswer);
        

        System.out.println("変換形式: " + conversionType.getDisplayName());
        System.out.println("問題: " + questionText);
        System.out.println("あなたの回答: " + userAnswer);
        System.out.println("正解: " + correctAnswer);
        System.out.println(isCorrect ? "正解！！" : "不正解...");
        
        // リダイレクト時に、答えた問題の正誤をHTML側に渡す処理　※isCorrectを入れて渡す
        redirectAttributes.addFlashAttribute("isCorrect", isCorrect);
        return "redirect:/";
    }
    
}
