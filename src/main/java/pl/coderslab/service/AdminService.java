package pl.coderslab.service;

import pl.coderslab.exception.ServiceException;
import pl.coderslab.dao.AdminDao;
import pl.coderslab.model.Admin;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class AdminService {
    private final AdminDao dao;

    public AdminService() {
        this.dao = new AdminDao();
    }

    public AdminService(AdminDao dao) {
        this.dao = dao;
    }

    public Admin create(String firstName, String lastName, String email, String password, int superAdmin, int enable) {
        if (
                verifyEmail(email) && verifyPassword(password) &&
                        dao.findByFirstName(firstName) == null && dao.findByEmail(email) == null
        ) {
            Admin admin = new Admin(firstName, lastName, email, password, superAdmin, enable);
            return dao.create(admin);
        } else {
            if (verifyEmail(email) == false) throw new ServiceException(String.format("Email [%s] niepoprawny", email));
            if (verifyPassword(password) == false)
                throw new ServiceException(String.format("Hasło niepoprawne", email));
        }
        return null;
    }

    private boolean verifyPassword(String password) {
        return Pattern.matches("(?=.*[A-Z].*[a-z])" +
                "[A-Za-z0-9]{10,15}", password);
    }

    private boolean verifyEmail(String email) {
        String regexStr = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";
        Pattern pattern = Pattern.compile(regexStr);
        return pattern.matcher(email).matches();
    }
}
