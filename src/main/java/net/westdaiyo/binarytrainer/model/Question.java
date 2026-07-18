package net.westdaiyo.binarytrainer.model;

public class Question {
    private String question; //問題
    private String answer;  //回答
    private String conversionType; //変換モード（10→2や2→16など）

    public Question(String question, String answer, String conversionType) {
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
    public String getConversionType() {
        return conversionType;
    }


}