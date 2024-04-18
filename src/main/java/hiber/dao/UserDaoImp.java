package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Queue;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   /**
    * метод, который с помощью hql-запроса будет доставать юзера, владеющего машиной по ее модели и серии.
    * */
   @Override
   public User getCatByUser(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("FROM User WHERE car.model = : model AND car.series = : series", User.class)
              .setParameter("model", model)
              .setParameter("series", series);

      return query.getSingleResult();
   }


}
