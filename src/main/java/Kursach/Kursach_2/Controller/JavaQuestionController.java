package Kursach.Kursach_2.Controller;

import Kursach.Kursach_2.Service.JavaQuestionService;
import Kursach.Kursach_2.data.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;
    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/add")
    public Question add (@RequestParam ("question") String question, @RequestParam ("answer") String answer) {
        return javaQuestionService.add(question,answer);
    }
    @GetMapping("/remove")
    public Question remove (@RequestParam ("question") String question, @RequestParam ("answer") String answer) {
        return javaQuestionService.remove(question,answer);
    }
    @GetMapping
    public Collection<Question> getAll () {
        return javaQuestionService.getAll();
    }
}
