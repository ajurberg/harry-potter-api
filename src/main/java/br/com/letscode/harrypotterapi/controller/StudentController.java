package br.com.letscode.harrypotterapi.controller;

import br.com.letscode.harrypotterapi.request.StudentRequest;
import br.com.letscode.harrypotterapi.response.StudentResponse;
import br.com.letscode.harrypotterapi.service.StudentService;
import io.reactivex.rxjava3.core.Observable;
import lombok.AllArgsConstructor;
import io.reactivex.rxjava3.core.Single;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
    public Observable<?> findAll() {
        return studentService.listAll();
    }

    @GetMapping("findStudentByName/{name}")
    public Single<StudentResponse> findStudentByName(@PathVariable String name) {
        return studentService.findByName(name);
    }

}
