package com.example.quizApp.repository;

import com.example.quizApp.model.Question;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

  List<Question> findByCategory(String category);
  List<Question> findRandomQuestionsByCategory(String category, int numQ);
}