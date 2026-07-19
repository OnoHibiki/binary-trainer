package net.westdaiyo.binarytrainer.service;
import net.westdaiyo.binarytrainer.model.ConversionType;
import net.westdaiyo.binarytrainer.model.Question;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final Random random = new Random();

    public Question createQuestion(ConversionType conversionType) {
        switch (conversionType) {
            case DECIMAL_TO_BINARY:
                return createDecimalToBinaryQuestion();        
            default:
                throw new UnsupportedOperationException(
                    "存在しない変換形式です : " + conversionType 
                );  //暫定処置
        }
    }

    // 10進数から2進数への変換問題作成
    private Question createDecimalToBinaryQuestion() {
        int number = random.nextInt(256); //0~255までのランダムな10進数を作成

        String question = String.valueOf(number);
        String answer = Integer.toBinaryString(number);

        return new Question(question, answer, ConversionType.DECIMAL_TO_BINARY);
    }
}