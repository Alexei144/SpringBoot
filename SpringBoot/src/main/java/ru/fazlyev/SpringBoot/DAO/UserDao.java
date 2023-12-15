package ru.fazlyev.SpringBoot.DAO;
import ru.fazlyev.SpringBoot.model.User;

import java.util.List;


public interface UserDao {
   List<User> getAllUsers();

   User getUserById(int id);

    void saveUser(User user);

    void deleteUser(int id);

    void updateUser(int id, User updatedUser);
}
