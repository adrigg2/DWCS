package com.adrian.ej3.services;

import com.adrian.ej3.domain.Answer;
import com.adrian.ej3.domain.Question;

public interface QuestionsService {
    void loadQuestions();
    Question getNextQuestion();
    Integer getResult();
    Integer getNumberOfQuestions();
    void checkAnswer(Answer answer);
    void newGame();
    Integer getCurrentQuestionNum();
}
