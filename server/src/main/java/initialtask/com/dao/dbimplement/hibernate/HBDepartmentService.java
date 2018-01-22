package initialtask.com.dao.dbimplement.hibernate;

import initialtask.com.dao.DepartmentService;
import initialtask.com.dao.fileds.Messages;
import initialtask.com.exception.DBException;
import initialtask.com.model.Department;
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
public class HBDepartmentService implements DepartmentService {
    private Logger log = LoggerFactory.getLogger(HBDepartmentService.class);
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void update(Department department) throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(department);
            transaction.commit();
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_DEPARTMENT_LIST);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Department> findAll() throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Department");
            return (List<Department>) query.list();
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_DEPARTMENT_LIST);
        }
    }

    @Override
    public void remove(int departmentId) throws DBException {

        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("delete Department where id=:id");
            query.setParameter("id", departmentId);
            query.executeUpdate();
            transaction.commit();
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_DELETE_DEPARTMENT);
        }
    }

    @Override
    public Department findDepartmnetById(int id) throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Department where id=:id");
            query.setParameter("id", id);
            return (Department) query.getSingleResult();
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_FIND_DEPARTMENT_BY_ID);
        }
    }

    @Override
    public Department findDepartmentByName(String name) throws DBException {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from Department where name=:name");
            query.setParameter("name", name);
            return (Department) query.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (HibernateException ex) {
            log.error("CANNOT CREATE OBJECT {}", SessionFactory.class);
            throw new DBException(Messages.ERR_CANNOT_FIND_DEPARTMENT_BY_ID);
        }
    }


}
