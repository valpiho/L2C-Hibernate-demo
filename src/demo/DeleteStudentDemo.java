package demo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteStudentDemo {

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

            // delete student
            session.delete(student);

            // delete student
            session.createQuery("delete from Student where id=1").executeUpdate();

            // commit transaction
            session.getTransaction().commit();

        } finally {
            sessionFactory.close();
        }
    }
}
