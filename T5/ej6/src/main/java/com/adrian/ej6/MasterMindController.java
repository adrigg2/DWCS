package com.adrian.ej6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.adrian.ej6.model.FormInfo;
import com.adrian.ej6.model.GameForm;

@Controller
@Scope("session")
public class MasterMindController {

    @Autowired
    public MasterMindService masterMindService;

    @GetMapping("/")
    public String showHome(Model model) {
        model.addAttribute("gameForm", new GameForm());
        return "indexView";
    }

    @GetMapping("/game")
    public String showGame(Model model) {
        model.addAttribute("formInfo", new FormInfo());
        model.addAttribute("attemptList", masterMindService.masterMind.getAttemptList());
        model.addAttribute("gameState", masterMindService.masterMind.getGameState());
        model.addAttribute("numberOfAttempts", masterMindService.masterMind.getAttemptList().size());
        return "gameView";
    }

    @PostMapping("/game")
    public String newTry(FormInfo formInfo) {
        masterMindService.checkAttempt(formInfo.getAttempt());
        return "redirect:/game";

    }

    @PostMapping("/newGame")
    public String newGame(GameForm gameForm) {
        masterMindService.masterMind.setMaxAttempts(gameForm.getAttemptsNumber());
        masterMindService.masterMind.setNumSize(gameForm.getNumberOfDigits());
        masterMindService.newGame();
        return "redirect:/game";
    }
}
