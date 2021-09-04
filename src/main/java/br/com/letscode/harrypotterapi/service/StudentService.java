package br.com.letscode.harrypotterapi.service;

import br.com.letscode.harrypotterapi.entity.Student;
import br.com.letscode.harrypotterapi.repository.StudentRepository;
import br.com.letscode.harrypotterapi.request.StudentRequest;
import br.com.letscode.harrypotterapi.response.StudentResponse;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public Single<StudentResponse> registerStudent(StudentRequest studentRequest) {
        return Single.create(single -> {
            var student = ConsumingApi.sortingHat();
            var house = ConsumingApi.findHouse(student);
            student.setName(studentRequest.getName());
            studentRepository.save(student);
            single.onSuccess(new StudentResponse(student, house));
        });
    }

    public Single<StudentResponse> findByName(String name) {
        return Single.create(single -> {
           var student = studentRepository.findStudentByName(name);
           var house = ConsumingApi.findHouse(student);
           single.onSuccess(new StudentResponse(student, house));
        });
    }

    @Transactional(readOnly = true)
    public Observable<?> listAll() {
        StopWatch timer = new StopWatch();
        timer.start();
        Observable<StudentResponse> map = Observable.fromIterable(studentRepository.findByNameIsNotNull()
                .collect(Collectors.toList())).map(this::convertToOne);
        timer.stop();
        log.info("Executou em {} ms", timer.getTotalTimeMillis());
        return map;
    }

    public StudentResponse convertToOne(Student student) {
        StopWatch timer = new StopWatch();
        timer.start();
        var house = ConsumingApi.findHouse(student);
        timer.stop();
        log.info("Executou em {} ms", timer.getTotalTimeMillis());
        return new StudentResponse(student, house);
    }

}
