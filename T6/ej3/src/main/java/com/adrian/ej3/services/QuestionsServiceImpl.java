package com.adrian.ej3.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.ej3.domain.Answer;
import com.adrian.ej3.domain.Question;

@Service
public class QuestionsServiceImpl implements QuestionsService {
    private List<Question> questions = new ArrayList<>();
    private int currentQuestion = 0;
    private int correctQuestions = 0;

    @Override
    public void loadQuestions() {
        try {
            List<String> questionsData = Files.readAllLines(Path.of("questions.csv"));
            for (String question : questionsData) {
                String[] questionData = question.split(",");
                questions.add(new Question(Integer.parseInt(questionData[0]), questionData[1], new String[] {questionData[2], questionData[3], questionData[4], questionData[5]}, questionData[6]));
            }
        } catch (IOException ioe) {
            return;
        }
    }

    @Override
    public Question getNextQuestion() {
        currentQuestion++;
        return questions.get(currentQuestion);
    }

    @Override
    public Integer getResult() {
        return correctQuestions;
    }

    @Override
    public Integer getNumberOfQuestions() {
        return questions.size();
    }

    @Override
    public void checkAnswer(Answer answer) {
        Question question = questions.get(currentQuestion);
        if (answer.getAnswer().equals(question.getCorrectAnswer())) {
            correctQuestions++;
        }
    }

    @Override
    public void newGame() {
        currentQuestion = -1;
        correctQuestions = 0;
    }

    @Override
    public Integer getCurrentQuestionNum() {
        return currentQuestion;
    }
}
