import Models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Burak Köken on 5.7.2017.
 */
public class HibernateTest {

    public static void main(String[] args) {

        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        String hql = "FROM Employee AS E WHERE E.salary >= ?";
        Query query = session.createQuery(hql);
        query.setParameter(0, 4000);

        List<Employee> resultList = query.list();
        System.out.println("result list size : " + resultList.size());

        for (Employee employee : resultList) {
            System.out.println("id : " + employee.getId()
                    + ", name : " + employee.getName()
                    + ", salary : " + employee.getSalary());
        }

    }
}
