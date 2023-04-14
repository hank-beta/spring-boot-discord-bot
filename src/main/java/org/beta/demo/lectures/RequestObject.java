package org.beta.demo.lectures;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 {
 "name": "sipro",
 "age": 200,
 "likeColors": ["red", "black", "white", "pink"],
 "skill": {
 "name": "java",
 "while": 29
 },
 "marry": false
 }
 */

@ToString
@Getter @Setter
public class RequestObject {
    private String name;
    private Integer age;
    private List<String> likeColors = new ArrayList<>();

    private Skill skill = new Skill();


    @Getter @Setter @ToString
    public static class Skill {
        private String name;
        @JsonAlias("while")
        private Integer whileYear;


    }


}
