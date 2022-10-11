package pl.coderslab.model;

import pl.coderslab.dao.AdminDao;

public class AdminMain {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDao();
        System.out.println(AdminDao.read(1));
//        AdminDao.findAll();
        Admin admin = new Admin();
        admin.setFirstName("Franek");
        admin.setLastName("Kimono");
        admin.setEmail("dupal@wp.pl");
        admin.setPassword("dupal");
        admin.setSuperAdmin(1);
        admin.setEnable(1);

//        adminDao.create(admin);
    }
}

