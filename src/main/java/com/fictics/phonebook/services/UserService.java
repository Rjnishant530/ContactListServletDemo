package com.fictics.phonebook.services;

import com.fictics.phonebook.dao.DaoFactory;
import com.fictics.phonebook.dao.UserDao;
import com.fictics.phonebook.entity.User;
import lombok.var;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.Map;

public class UserService {

    public User registerUser(String name, String email, String password, String cPassword, Map<String,String> errors) throws IOException {

        if(name.trim().length()==0){
            errors.put("name", "Name can not be empty");

        }else if(name.trim().length()<3){
            errors.put("name length","Name Length must be more than 3");

        }
        if(email.trim().length()==0){
            errors.put("email","Email Address can not be empty");
        }
        if(password.trim().length()==0){
            errors.put("password","Password can not be empty");
        }
        if(!password.trim().equals(cPassword.trim())) {
            errors.put("cpassword", "Passwords do not Match");
        }
        UserDao userDao = DaoFactory.getUserDao();
        User user = userDao.getUserByEmail(email);
        if(user!=null){
            errors.put("user","User is already Registered");
        }
        if(errors.size()>0)
            return null;

        String pass = BCrypt.hashpw(password, BCrypt.gensalt(12));
        user = new User(name,email,pass);
        userDao.createUser(user);
        return user;
    }

    public User login(String email, String password, Map<String, String> errors) throws IOException {
        if(email.trim().length()==0){
            errors.put("email","Email Address can not be empty");
        }
        if(password.trim().length()==0){
            errors.put("password","Password can not be empty");
        }
        if(errors.size()>0)
            return null;

        UserDao userDao = DaoFactory.getUserDao();
        User user = userDao.getUserByEmail(email);

        if(user==null){
            errors.put("email","Invalid Email or Password");
        }else{
            boolean result = BCrypt.checkpw(password,user.getPassword());
            if(!result)
                errors.put("email","Invalid Email or Password");

        }
        if(errors.size()>0)
            return null;


        return user;
    }
}
