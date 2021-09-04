package br.com.letscode.harrypotterapi.response;

import br.com.letscode.harrypotterapi.entity.House;
import br.com.letscode.harrypotterapi.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentResponse {

    private long responseId;
    private String responseName;
    private House house;

    public StudentResponse(Student student, House house) {
        this.responseId = student.getStudentId();
        this.responseName = student.getName();
        this.house = house;
    }

}
