package com.example.quizApp.service;

import com.example.quizApp.model.Question;
import com.example.quizApp.repository.QuestionRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

  private final QuestionRepository questionRepository;

  public QuestionService(QuestionRepository questionRepository) {
    this.questionRepository = questionRepository;
  }

  public ResponseEntity<List<Question>> getAllQuestions() {
    try {
      List<Question> allQuestions = questionRepository.findAll();
      if(allQuestions.isEmpty()) {
        return new ResponseEntity<>(allQuestions, HttpStatus.NOT_FOUND);
      }
      return ResponseEntity.ok(allQuestions);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

  }

  public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
    try {
      List<Question> byCategory = questionRepository.findByCategory(category);
      if(byCategory.isEmpty()) {
        return new ResponseEntity<>(byCategory, HttpStatus.NOT_FOUND);
      }
      return ResponseEntity.ok(byCategory);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

  }

  public ResponseEntity<String> addQuestion(Question question) {
    try {
      questionRepository.save(question);
      return new ResponseEntity<>("Question added successfully", HttpStatus.CREATED);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>("Failed to add question", HttpStatus.BAD_REQUEST);
    }
  }
}