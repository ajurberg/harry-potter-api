package br.com.letscode.harrypotterapi.response;

import br.com.letscode.harrypotterapi.entity.House;
import br.com.letscode.harrypotterapi.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private long id;
    private String name;
    private House house;

    public StudentResponse(Student student, House house) {
        this.id = student.getStudentId();
        this.name = student.getName();
        this.house = house;
    }

}
