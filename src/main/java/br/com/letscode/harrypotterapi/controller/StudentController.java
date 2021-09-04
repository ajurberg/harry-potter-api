package br.com.letscode.harrypotterapi.controller;

import br.com.letscode.harrypotterapi.request.StudentRequest;
import br.com.letscode.harrypotterapi.response.StudentResponse;
import br.com.letscode.harrypotterapi.service.StudentService;
import io.reactivex.rxjava3.core.Observable;
import lombok.AllArgsConstructor;
import io.reactivex.rxjava3.core.Single;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/student")
@AllArgsConstructor
@RestController
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)
    public Single<StudentResponse> registerStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.registerStudent(studentRequest);
    }

    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public Observable<?> findAll() {
        StopWatch timer = new StopWatch();
        timer.start();
        Observable<?> students = studentService.listAll();
        timer.stop();
        log.info("Executou em {} ms.", timer.getTotalTimeMillis());
        return students;
    }

    @GetMapping("findStudentByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public Single<StudentResponse> findStudentByName(@PathVariable String name) {
        return studentService.findByName(name);
    }

}
