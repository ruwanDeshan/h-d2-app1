import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {
        Student student=new Student(1,"kamal");
        saveStudent(student);
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
