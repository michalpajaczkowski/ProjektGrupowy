package hibernate;

import mail.SendEmailComponent;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateDao implements HibernateEntity{

    private SendEmailComponent sendEmailComponent;

    public HibernateDao(){
        sendEmailComponent = new SendEmailComponent();
    }

    public void saveHibernateEntity(HibernateEntity hibernateEntity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            if(hibernateEntity instanceof Employees) {
                sendEmailComponent.sendEmailAdd((Employees) hibernateEntity);
            }

            session.save(hibernateEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }



    public void updateHibernateEntity(HibernateEntity hibernateEntity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            if(hibernateEntity instanceof Employees) {
                sendEmailComponent.sendEmailUpdate((Employees) hibernateEntity);
            }

            session.update(hibernateEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteHibernateEntity(HibernateEntity hibernateEntity) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            if(hibernateEntity instanceof Employees) {
                sendEmailComponent.sendEmailDelete((Employees) hibernateEntity);
            }

            session.delete(hibernateEntity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Employees> getEmployees() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Employees", Employees.class).list();
        }
    }
	
	 public List<Cars> getCars() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Cars", Cars.class).list();
        }
    }

    public List<Printer> getPrinter() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Printer", Printer.class).list();
        }
    }

}
