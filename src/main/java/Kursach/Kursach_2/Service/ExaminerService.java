package Kursach.Kursach_2.Service;

import Kursach.Kursach_2.Exception.IncorrectQuestionAmount;
import Kursach.Kursach_2.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws IncorrectQuestionAmount;
}
