package pl.coderslab.model;


import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int superAdmin;
    private int enable;

    public Admin() {
    }

    public Admin(String firstName, String lastName, String email, String password, int superAdmin, int enable) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.superAdmin = superAdmin;
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", superAdmin=" + superAdmin +
                ", enable=" + enable +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(int superAdmin) {
        this.superAdmin = superAdmin;
    }

    public int getEnable() {
        return enable;
    }

    public void setEnable(int enable) {
        this.enable = enable;
    }

    public Admin map(ResultSet resultSet) throws SQLException {
        this.setId(resultSet.getInt("id"));
        this.setFirstName(resultSet.getString("first_name"));
        this.setLastName(resultSet.getString("last_name"));
        this.setEmail(resultSet.getString("email"));
        this.setPassword(resultSet.getString("password"));
        this.setSuperAdmin(resultSet.getInt("superadmin"));
        this.setEnable(resultSet.getInt("enable"));

        return this;
    }

}
