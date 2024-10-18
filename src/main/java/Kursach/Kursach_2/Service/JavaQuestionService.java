package Kursach.Kursach_2.Service;

import Kursach.Kursach_2.Exception.BadAddException;
import Kursach.Kursach_2.Exception.BadRemoveException;
import Kursach.Kursach_2.data.Question;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {

    private final static Random random = new Random();
    private final Set<Question> questions = new HashSet<>();

    public JavaQuestionService () {
        this.questions.add(new Question("Вопрос1","Ответ1"));
        this.questions.add(new Question("Вопрос2","Ответ2"));
        this.questions.add(new Question("Вопрос3","Ответ3"));
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question,answer);
        if (questions.contains(question1)) {
            throw new BadAddException();
        }
        questions.add(question1);
        return question1;
    }
    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new BadAddException();
        }
        questions.add(question);
        return question;
    }
    @Override
    public Question remove(String question, String answer) {
        Question question1 = new Question(question,answer);
        if (!questions.contains(question1)) {
            throw new BadRemoveException();
        }
        questions.remove(question1);
        return question1;
    }
    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new BadRemoveException();
        }
        questions.remove(question);
        return question;
    }
    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }
    @Override
    public Question getRandomQuestion() {
        int questionNumber = random.nextInt(questions.size());
        return new ArrayList<>(questions).get(questionNumber);
    }
}
