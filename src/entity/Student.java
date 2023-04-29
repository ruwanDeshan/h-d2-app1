package entity;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;

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

    @ElementCollection
    @JoinTable(
            name = "address_table",
            joinColumns = @JoinColumn(name="id")
    )
    @GenericGenerator(name = "address_sequence",strategy = "sequence")
    @CollectionId(
            columns = @Column(name = "address_id"),
            generator = "address_sequence",
            type = @Type(type = "int")
    )
    private Collection<Address> addressesList;

    public Student() {
    }

    public Student(long studentId, String name, Collection<Address> addressesList) {
        this.studentId = studentId;
        this.name = name;
        this.addressesList = addressesList;
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

    public Collection<Address> getAddressesList() {
        return addressesList;
    }

    public void setAddressesList(Collection<Address> addressesList) {
        this.addressesList = addressesList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", addressesList=" + addressesList +
                '}';
    }
}
