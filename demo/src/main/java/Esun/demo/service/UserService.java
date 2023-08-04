package Esun.demo.service;

import Esun.demo.model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    public User addUser(User user);

    public User getUserById(String id);

    public List<User> getUsers();

    public void deleteUser(String id);

    public User updateUser(User user);

    // stored procedure
    public List<User> getUsersByProcedure(String a, String b);

}
