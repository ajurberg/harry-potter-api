package br.com.letscode.harrypotterapi.repository;

import br.com.letscode.harrypotterapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentByName(String name);
    Stream<Student> findByNameIsNotNull();

}
