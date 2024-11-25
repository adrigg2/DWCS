package com.adrian.ej3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.adrian.ej3.domain.Answer;
import com.adrian.ej3.domain.Question;
import com.adrian.ej3.services.QuestionsService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;

    @GetMapping("/")
    public String getIndex() {
        questionsService.newGame();
        return "indexView";
    }
    
    @GetMapping("/question")
    public String getQuestion(Model model) {
        Question question = questionsService.getNextQuestion();
        model.addAttribute("question", question);
        Answer answer = new Answer();
        model.addAttribute("answer", answer);
        return "questionView";
    }

    @PostMapping("/answer")
    public String postAnswer(Answer answer) {
        questionsService.checkAnswer(answer);
        if (questionsService.getCurrentQuestionNum() == questionsService.getNumberOfQuestions() - 1) {
            return "redirect:/result";
        }
        return "redirect:/question";
    }

    @GetMapping("/result")
    public String getMethodName(Model model) {
        model.addAttribute("correct", questionsService.getResult());
        model.addAttribute("total", questionsService.getNumberOfQuestions());
        return "resultView";
    }
    
}
