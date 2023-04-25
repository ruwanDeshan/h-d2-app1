package entity;

import javax.persistence.*;

@Entity(name="student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Column(name="id")
    private long studentId;

    @Column(name="student_name",length=50,nullable = false)
    private String name;

    public Student() {
    }

    public Student(long studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                '}';
    }                          //test comment
}
