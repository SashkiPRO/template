package initialtask.com.dao.dbimplement.hibernate;

import initialtask.com.dao.EmployeeService;
import initialtask.com.dao.fileds.Messages;
import initialtask.com.exception.DBException;
import initialtask.com.model.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class HBEmployeeService implements EmployeeService {

    private SessionFactory sessionFactory;
    private static final Logger log = LoggerFactory.getLogger(HBEmployeeService.class);
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void update(Employee employee) throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(employee);

            transaction.commit();
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_EMPLOYEE);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> findAll() throws DBException {

        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Employee ");
            return (List<Employee>) query.getResultList();
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_FIND_EMPLOYEES_LIST);
        }
    }

    @Override
    public void remove(int employeeId) throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("delete Employee where id=:id");
            query.setParameter("id", employeeId);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_DELETE_EMPLOYEE);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> findEmployeesByDepartmentId(int departmentID) throws DBException {

        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Employee where departmentId=:departmentId");
            query.setParameter("departmentId", departmentID);
            return (List<Employee>) (query.getResultList());
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_FIND_EMPLOYEE_BY_ID);
        }
    }

    @Override
    public Employee findEmployeeById(int employeeId) throws DBException {

        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Employee where id=:id");
            query.setParameter("id", employeeId);
            return (Employee) query.getSingleResult();
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_FIND_EMPLOYEE_BY_ID);
        }
    }

    @Override
    public Employee findEmployeeByEmail(String email) throws DBException {

        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Employee where email=:email");
            query.setParameter("email", email);
            return (Employee) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_FIND_EMPLOYEE_BY_ID);
        }
    }
}
