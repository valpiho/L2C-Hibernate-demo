package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class QueryStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();

            // query students
            List<Student> students = session.createQuery("from Student").getResultList();
            displayStudents(students);

            // query students: lastName='Piho'
            students = session.createQuery("from Student s where s.lastName='Piho'").getResultList();
            displayStudents(students);

            // query students: lastName='Piho' OR firstName='Val
            students = session.createQuery("from Student s where s.lastName='Piho' OR s.firstName='Val'").getResultList();
            displayStudents(students);

            // query students: email LIKE '%gmail.com'
            students = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();
            displayStudents(students);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students
        ) {
            System.out.println(student);
        }
    }
}
