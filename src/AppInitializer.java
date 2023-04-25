import entity.Student;
import org.hibernate.Session;

public class AppInitializer {
    public static void main(String[] args) {
        Student student=new Student(1,"kamal");
        saveStudent(student);
    }

    private static void saveStudent(Student student) {
        try(Session session=HibernateUtil.getSessionFactory().openSession()){
            long saveId= (long) session.save(student);
            System.out.println("Saved student primary key: "+saveId);
        }
    }
}
