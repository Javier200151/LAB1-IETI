package co.escuelaing.ieti.apirest.service.impl;

import java.util.List;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import co.escuelaing.ieti.apirest.data.User;
import co.escuelaing.ieti.apirest.service.UserService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserServiceHashMap implements UserService{

    private final HashMap<String, User> usersHash;
    private static final AtomicInteger COUNTER_ID = new AtomicInteger(1);

    public UserServiceHashMap() {
        this.usersHash = new HashMap<>();
    }

    @Override
    public User create(User user) {
        
        for (User u: usersHash.values()) {
            if(u.getName()==user.getName() && u.getEmail()==user.getEmail() && u.getLastName()==user.getLastName()){
                throw new RuntimeException("Create user error.");
            }else{
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                user.setId(String.valueOf(COUNTER_ID.getAndIncrement()));
                user.setCreatedAt(format.format(new Date()));
                usersHash.put(user.getId(), user);
            }
        }

        return user;
    }

    @Override
    public User findById(String id) {
        return usersHash.get(id);
    }

    @Override
    public List<User> all() {
        return new ArrayList<>(usersHash.values());
    }

    @Override
    public void deleteById(String id) {
        usersHash.remove(id);
        
    }

    @Override
    public User update(User user, String userId) {
        if (usersHash.containsKey(userId))
        {
            user.setId(userId);
            user.setCreatedAt(usersHash.get(userId).getCreatedAt());
            usersHash.replace(userId, user);
            return user;
        }else
        {
            return null;
        }
    }
    
}
