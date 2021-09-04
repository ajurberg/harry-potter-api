package br.com.letscode.harrypotterapi.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class House {

    private String id;
    private String name;
    private String animal;
    private String founder;
    private List<Object> values;

}
