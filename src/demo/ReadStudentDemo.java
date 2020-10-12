package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ReadStudentDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        try {
            //start a transaction
            session.beginTransaction();

            // retrieve student based on the id
            Student student = session.get(Student.class, 2);

            // commit transaction
            session.getTransaction().commit();

            System.out.println(student);

        } finally {
            sessionFactory.close();
        }
    }
}
