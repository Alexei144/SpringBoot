package ru.fazlyev.SpringBoot.DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.fazlyev.SpringBoot.model.User;
import java.util.List;


    @Repository
    public class UserDaoImpl implements UserDao {

        @PersistenceContext   // @Autowired - может так лучше?
        private EntityManager entityManager;

        public List<User> getAllUsers() {
            return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
        }

        public User getUserById(int id) {
            return entityManager.find(User.class, id);
        }

        public void saveUser(User user) {
            entityManager.persist(user);
        }


        public void updateUser(int id, User updatedUser) {
            entityManager.merge(updatedUser);
        }


        public void deleteUser(int id) {
            entityManager.remove(entityManager.find(User.class, id));
        }
}
