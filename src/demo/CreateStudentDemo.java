package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // create a student object
            Student student = new Student("Val", "Piho", "val.piho@gmail.com");

            //start a transaction
            session.beginTransaction();

            // save the student object
            session.save(student);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
