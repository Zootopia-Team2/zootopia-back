package dev.team2.zoopoli.Services;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import dev.team2.zoopoli.Models.User;
import dev.team2.zoopoli.Repositories.UserRepository;

@Service
public class UserService {
    private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }
 
    public List<User> getAll() {
        return repository.findAll();
    }

    public User save(@NonNull User newUser) {
        User userSaved = repository.save(newUser);
        return userSaved;
    }

    public User findById(Long id) {
        return repository.findById(id).orElse(null);        
    }    

    public void delete(Long id){
        repository.deleteById(id);
    }
    
    
}
