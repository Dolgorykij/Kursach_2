package Kursach.Kursach_2;

import Kursach.Kursach_2.Service.ExaminerServiceImpl;
import Kursach.Kursach_2.Service.JavaQuestionService;
import Kursach.Kursach_2.data.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final static Random random = new Random();

    @ParameterizedTest
    @ValueSource(ints = {5,10})
    public void getQuestionsTest (int amount) {
        Collection<Question> testCollection = IntStream.generate(random::nextInt)
                .limit(amount)
                .boxed()
                .map(Objects::toString)
                .map(s -> new Question(s, s))
                .toList();
        when(javaQuestionService.getAll()).thenReturn(testCollection);

        when(javaQuestionService.getRandomQuestion()).thenAnswer(invocation -> new Question(random.nextInt() + "",random.nextInt() + ""));
        Collection<Question> actual = examinerService.getQuestions(amount);
        assertEquals(actual.size(),amount);
        verify(javaQuestionService, atLeast(amount)).getRandomQuestion();
    }
}
