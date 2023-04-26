package entity;

import javax.persistence.*;

@Entity(name="student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator = "student_sequence")
    @SequenceGenerator(
            name = "student_sequence",
            initialValue = 1,
            sequenceName = "st_seq",
            allocationSize = 1
    )
    @Column(name="id")
    private long studentId;

    @Column(name="student_name",length=50,nullable = false)
    private String name;

    @Embedded
    private Address address;

    public Student() {
    }

    public Student(long studentId, String name, Address address) {
        this.studentId = studentId;
        this.name = name;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
