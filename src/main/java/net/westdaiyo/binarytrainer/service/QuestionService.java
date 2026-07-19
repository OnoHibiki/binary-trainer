package net.westdaiyo.binarytrainer.service;
import net.westdaiyo.binarytrainer.model.ConversionType;
import net.westdaiyo.binarytrainer.model.Question;

import java.text.Normalizer;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final Random random = new Random();

    // model/ConversionType.java内で定義している全てのenumをcase分けしているため、default不要
    public Question createQuestion(ConversionType conversionType) {
        return switch (conversionType) {
            case DECIMAL_TO_BINARY -> createDecimalToBinaryQuestion();   
            case BINARY_TO_DECIMAL -> createBinaryToDecimalQuestion();
            case DECIMAL_TO_HEX -> createDecimalToHexQuestion();
            case HEX_TO_DECIMAL -> createHexToDecimalQuestion();
            case BINARY_TO_HEX -> createBinaryToHexQuestion();
            case HEX_TO_BINARY -> createHexToBinaryQuestion();
        };
    }

    // 10進数から2進数への変換問題作成（DECIMAL_TO_BINARY）
    private Question createDecimalToBinaryQuestion() {
        int number = random.nextInt(256); //0~255までのランダムな10進数を作成

        String question = String.valueOf(number);
        String answer = Integer.toBinaryString(number);

        return new Question(question, answer, ConversionType.DECIMAL_TO_BINARY);
    }

    // 2進数から10進数への変換問題作成（BINARY_TO_DECIMAL）
    private Question createBinaryToDecimalQuestion() {
        int number = random.nextInt(256);

        String question = Integer.toBinaryString(number);
        String answer = String.valueOf(number);

        return new Question(question, answer, ConversionType.BINARY_TO_DECIMAL);
    }

    // 10進数から16進数への変換問題作成(DECIMAL_TO_HEX)
    private Question createDecimalToHexQuestion() {
        int number = random.nextInt(256);

        String question = String.valueOf(number);
        String answer = Integer.toHexString(number).toUpperCase();// 16進数はアルファベットの場合があるため

        return new Question(question, answer, ConversionType.DECIMAL_TO_HEX);
    }

    // 16進数から10進数への変換問題作成(HEX_TO_DECIMAL)
    private Question createHexToDecimalQuestion() {
        int number = random.nextInt(256);

        String question = Integer.toHexString(number).toUpperCase();
        String answer = String.valueOf(number);

        return new Question(question, answer, ConversionType.HEX_TO_DECIMAL);
    }

    // 2進数から16進数への変換問題作成（BINARY_TO_HEX)
    private Question createBinaryToHexQuestion() {
        int number = random.nextInt(256);

        String question = Integer.toBinaryString(number);
        String answer = Integer.toHexString(number).toUpperCase();

        return new Question(question, answer, ConversionType.BINARY_TO_HEX);
    }

    // 16進数から２進数への変換問題作成（HEX_TO_BINARY）
    private Question createHexToBinaryQuestion() {
        int number = random.nextInt(256);

        String question = Integer.toHexString(number).toUpperCase();
        String answer = Integer.toBinaryString(number);

        return new Question(question, answer, ConversionType.HEX_TO_BINARY);
    }

    // ---------------------------------------------------------------------
    // 全変換問題からランダムで出題(Controllerから利用するメソッドのため、publicにする)
    public Question createRandomQuestion() {
        ConversionType[] conversionTypes = ConversionType.values();
        ConversionType randomConversionType = conversionTypes[random.nextInt(conversionTypes.length)];

        return createQuestion(randomConversionType);
    }

    // 正誤判定
    public boolean isCorrectAnswer(String userAnswer, String correctAnswer) {
        // 全て半角で受付
        String normalizedUserAnswer = Normalizer.normalize(userAnswer, Normalizer.Form.NFKC);
        
        return normalizedUserAnswer.trim().equalsIgnoreCase(correctAnswer.trim());
    }
}