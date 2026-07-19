package net.westdaiyo.binarytrainer.model;

public class Question {
    private final String question; //問題（2進数や16進数のために、String）
    private final String answer;  //回答（2進数や16進数のために、String）
    private final ConversionType conversionType; //変換モード（10→2や2→16など）

    public Question(String question, String answer, ConversionType conversionType) {
        this.question = question; 
        this.answer = answer;
        this.conversionType = conversionType;
    }

    // Getter
    public String getQuestion() {
        return question;
    }
    public String getAnswer() {
        return answer;
    }
    public ConversionType getConversionType() {
        return conversionType;
    }


}