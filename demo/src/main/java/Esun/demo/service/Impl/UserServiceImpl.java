package Esun.demo.service.Impl;


import Esun.demo.model.User;
import Esun.demo.repository.UserRepository;
import Esun.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import javax.lang.model.type.NullType;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    // repository
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        try {
            User check = userRepository.findById(user.getID()).get();
            // primary in database, do not let user add
            check.setName(null);
            return check;
        }
        catch(Exception e) {
            return userRepository.save(user);
        }
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getUsers() {
        return (List<User>)userRepository.findAll();
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsersByProcedure(String a, String b){ return userRepository.getUsersByProcedure(a, b); }
}
