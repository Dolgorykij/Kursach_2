package Kursach.Kursach_2.Service;

import Kursach.Kursach_2.Exception.IncorrectQuestionAmount;
import Kursach.Kursach_2.data.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final static Random random = new Random();
    private final  JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size()) {
            throw new IncorrectQuestionAmount("Задано неверное число вопросов");
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(javaQuestionService.getRandomQuestion());
        }
        return result;
    }
}
