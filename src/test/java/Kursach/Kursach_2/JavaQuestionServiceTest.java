package Kursach.Kursach_2;

import Kursach.Kursach_2.Service.JavaQuestionService;
import Kursach.Kursach_2.data.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

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
}
