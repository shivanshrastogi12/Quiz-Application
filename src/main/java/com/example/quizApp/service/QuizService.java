package com.example.quizApp.service;

import com.example.quizApp.model.Question;
import com.example.quizApp.model.QuestionWrapper;
import com.example.quizApp.model.Quiz;
import com.example.quizApp.model.Response;
import com.example.quizApp.repository.QuestionRepository;
import com.example.quizApp.repository.QuizRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class QuizService {

  private final QuizRepository quizRepository;
  private final QuestionRepository questionRepository;

  public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository) {
    this.quizRepository = quizRepository;
    this.questionRepository = questionRepository;
  }


  public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

    List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);

    Quiz quiz = new Quiz();
    quiz.setTitle(title);
    quiz.setQuestions(questions);

    quizRepository.save(quiz);
    return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
  }

  public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
    Optional<Quiz> quiz = quizRepository.findById(id);

    if(quiz.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    List<Question> questionsFromDB = quiz.get().getQuestions();
    List<QuestionWrapper> questionsForUsers = new ArrayList<>();
    for(Question q : questionsFromDB) {
      QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
      questionsForUsers.add(qw);
    }
    return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
  }

  public ResponseEntity<String> calculateResult(Integer id, List<Response> responses) {
    Optional<Quiz> quizOptional = quizRepository.findById(id);
    if (quizOptional.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Quiz quiz = quizOptional.get();
    List<Question> questions = quiz.getQuestions();

    int score = 0;
    int questionIndex = 0;
    for (Response r : responses) {
      if (r.getResponse().equals(questions.get(questionIndex).getRightAnswer())) {
        score++;
      }
      questionIndex++;
    }
    return new ResponseEntity<>("Your score is: " + score, HttpStatus.OK);
  }
} 