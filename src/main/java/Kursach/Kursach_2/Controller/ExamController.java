package Kursach.Kursach_2.Controller;

import Kursach.Kursach_2.Service.ExaminerServiceImpl;
import Kursach.Kursach_2.data.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/get")
    public class ExamController {

    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Collection<Question> getQuestions (@RequestParam ("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
