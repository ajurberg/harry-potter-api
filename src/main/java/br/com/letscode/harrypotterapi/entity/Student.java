package br.com.letscode.harrypotterapi.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder @Entity
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String name;
    @SerializedName("sorting-hat-choice")
    private String houseId;

}
