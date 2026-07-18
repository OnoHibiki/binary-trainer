package net.westdaiyo.binarytrainer.service;
import net.westdaiyo.binarytrainer.model.Question;

public class QuestionService {

    public Question createQuestion() {
        return new Question("25","11001","10→2");
    }
}