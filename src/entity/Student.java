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
    @AttributeOverrides(value = {
            @AttributeOverride(column = @Column(name = "residential_country"), name = "country"),
            @AttributeOverride(column = @Column(name = "residential_city"), name = "city"),
            @AttributeOverride(column = @Column(name = "residential_postal"), name = "postal")
    })
    private Address residentialAddress;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(column = @Column(name = "permanent_country"), name = "country"),
            @AttributeOverride(column = @Column(name = "permanent_city"), name = "city"),
            @AttributeOverride(column = @Column(name = "permanent_postal"), name = "postal")
    })
    private Address permanentAddress;

    public Student() {
    }

    public Student(long studentId, String name, Address residentialAddress, Address permanentAddress) {
        this.studentId = studentId;
        this.name = name;
        this.residentialAddress = residentialAddress;
        this.permanentAddress = permanentAddress;
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

    public Address getResidentialAddress() {
        return residentialAddress;
    }

    public void setResidentialAddress(Address residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    public Address getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(Address permanentAddress) {
        this.permanentAddress = permanentAddress;
    }
}
