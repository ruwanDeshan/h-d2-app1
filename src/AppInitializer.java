import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
        Address permanentAddress=new Address("Sri Lanka","Colombo",1500);
        Address residentialAddress=new Address("Sri Lanka","emb",1300);
        Student student1=new Student(1,"amal",residentialAddress,permanentAddress);
        saveStudent(student1);
    }

    private static void saveStudent(Student student) {
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction=session.beginTransaction();
            long saveId= (long) session.save(student);
            transaction.commit();
            System.out.println("Saved student primary key: "+saveId);
        }
    }
}
