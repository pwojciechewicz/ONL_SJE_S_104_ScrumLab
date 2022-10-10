package pl.coderslab.model;

import pl.coderslab.dao.AdminDao;

public class AdminMain {
    public static void main(String[] args) {
        AdminDao adminDao = new AdminDao();
//        System.out.println(AdminDao.read(1));
//        AdminDao.findAll();
        Admin admin = new Admin("adminin", "rhig", "email@wp.pl", "ijaij!@Q", 1,1);

        adminDao.create(admin);
    }
}

