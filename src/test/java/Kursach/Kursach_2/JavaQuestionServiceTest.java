package Kursach.Kursach_2;

import Kursach.Kursach_2.Exception.BadAddException;
import Kursach.Kursach_2.Exception.BadRemoveException;
import Kursach.Kursach_2.Service.JavaQuestionService;
import Kursach.Kursach_2.data.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void addTest () {
        int count = javaQuestionService.getAll().size();
        javaQuestionService.add(new Question("1","1"));
        javaQuestionService.add(new Question("2","2"));
        javaQuestionService.add(new Question("3","3"));
        javaQuestionService.add(new Question("4","4"));
        var actual = javaQuestionService.getAll().size();
        var expected = count + 4;
        assertEquals(expected,actual);
    }

    @Test
    public void BadAddTest () {
        assertThrows(BadAddException.class, () -> javaQuestionService.add("Вопрос1","Ответ1"));
    }

    @Test
    public void removeTest () {
        int count = javaQuestionService.getAll().size();
        javaQuestionService.add(new Question("1","1"));
        javaQuestionService.add(new Question("2","2"));
        javaQuestionService.add(new Question("3","3"));
        javaQuestionService.remove("1","1");
        javaQuestionService.remove("2","2");
        var actual = javaQuestionService.getAll().size();
        var expected = count + 1;
        assertEquals(actual,expected);
    }

    @Test
    public void BadRemoveTest () {
        assertThrows(BadRemoveException.class, () -> javaQuestionService.remove("Вопрос4","Ответ4"));
    }

    @Test
    public void GetAlltest () {
        HashSet<Question> testSet = new HashSet<>();
        testSet.add(new Question("Вопрос1","Ответ1"));
        testSet.add(new Question("Вопрос2","Ответ2"));
        testSet.add(new Question("Вопрос3","Ответ3"));
        testSet.add(new Question("qTest","aTest"));
        Question testQuestion = new Question("qTest","aTest");
        javaQuestionService.add(testQuestion);
        var expectedLength = 4;
        assertEquals(expectedLength,javaQuestionService.getAll().size());
        assertThat(javaQuestionService.getAll().contains(testQuestion)).isEqualTo(testSet.contains(testQuestion));
    }

    @Test
    public void getRandomTest () {
        Question testQ1 = new Question("Вопрос1","Ответ1");
        Question testQ2 = new Question("Вопрос2","Ответ2");
        Question testQ3 = new Question("Вопрос3","Ответ3");
        Question actual = javaQuestionService.getRandomQuestion();
        assertThat(actual.equals(testQ1) || actual.equals(testQ2) || actual.equals(testQ3))
                .isEqualTo(javaQuestionService.getAll().contains(testQ1)
                || javaQuestionService.getAll().contains(testQ2)
                || javaQuestionService.getAll().contains(testQ3));
    }
}
