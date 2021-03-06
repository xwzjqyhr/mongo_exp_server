package com.xwzjqyhr.mongodb.pojo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "student_course")
public class StudentCourse {
    @Id
    String id;
    String sid;
    String cid;
    String score;
    String tid;
}
