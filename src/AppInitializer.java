import entity.Address;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Arrays;

public class AppInitializer {
    public static void main(String[] args) {
        Address address1=new Address("Sri Lanka","galle",55465);
        Address address2=new Address("Sri Lanka","emb",1300);
        Address address3=new Address("USA","texas",54654);
        Student student1=new Student();
       /* ArrayList list=new ArrayList();
        list.add(address1);
        list.add(address2);
        list.add(address3);*/
        student1.setName("Ruwan");
        student1.setAddressesList(Arrays.asList(address1,address2,address3));
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
