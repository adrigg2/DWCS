package com.adrian.ej3.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class Question {
    private int number;
    private String text;
    private String[] answers;
    private String correctAnswer;
}
