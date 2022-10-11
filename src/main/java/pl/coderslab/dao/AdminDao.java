package pl.coderslab.dao;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.exception.DaoException;
import pl.coderslab.exception.NotFoundException;
import pl.coderslab.model.Admin;
import pl.coderslab.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {
    private static final String CREATE_ADMIN_QUERY = "INSERT INTO admins(first_name,last_name,email,password,superadmin,enable) VALUES (?,?,?,?,?,?)";
    private static final String DELETE_ADMIN_QUERY = "DELETE FROM admins where id = ?";
    private static final String FIND_ALL_ADMINS_QUERY = "SELECT * FROM admins";
    private static final String READ_ADMIN_QUERY = "SELECT * from admins where id = ?";
    private static final String UPDATE_ADMIN_QUERY = "UPDATE admins SET first_name = ? , last_name = ?, email = ?, password = ?, superadmin = ?, enable = ? WHERE	id = ?";

    private static final String READ_ADMIN_QUERY_ID = "SELECT * from admins where id = ? LIMIT 1";
    private static final String READ_ADMIN_QUERY_FIRSTNAME = "SELECT * from admins where first_name = ? LIMIT 1";

    /**
     * Get admin by id
     *
     * @param adminId
     * @return
     */
    public static Admin read(int adminId) {
        Admin admin = new Admin();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ADMIN_QUERY)
        ) {
            statement.setInt(1, adminId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    admin.setId(resultSet.getInt("id"));
                    admin.setFirstName(resultSet.getString("first_name"));
                    admin.setLastName(resultSet.getString("last_name"));
                    admin.setEmail(resultSet.getString("email"));
                    admin.setEmail(resultSet.getString("password"));
                    admin.setSuperAdmin(resultSet.getInt("superadmin"));
                    admin.setSuperAdmin(resultSet.getInt("enable"));

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return admin;

    }

    /**
     * Return all admins
     *
     * @return
     */
    public static List<Admin> findAll() {
        List<Admin> adminsList = new ArrayList<>();
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_ADMINS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Admin adminToAdd = new Admin();
                adminToAdd.setId(resultSet.getInt("id"));
                adminToAdd.setFirstName(resultSet.getString("first_name"));
                adminToAdd.setLastName(resultSet.getString("last_name"));
                adminToAdd.setEmail(resultSet.getString("email"));
                adminToAdd.setSuperAdmin(resultSet.getInt("superadmin"));
                adminsList.add(adminToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adminsList;

    }

    /**
     * Create admin
     *
     * @param admin
     * @return
     */
    public static Admin create(Admin admin) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement insertStm = connection.prepareStatement(CREATE_ADMIN_QUERY,
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            insertStm.setString(1, admin.getFirstName());
            insertStm.setString(2, admin.getLastName());
            insertStm.setString(3, admin.getEmail());
            insertStm.setString(4, hashPass(admin.getPassword()));
            insertStm.setInt(5, admin.getSuperAdmin());
            insertStm.setInt(6, admin.getEnable());
            int result = insertStm.executeUpdate();

            if (result != 1) {
                throw new RuntimeException("Execute update returned " + result);
            }

            try (ResultSet generatedKeys = insertStm.getGeneratedKeys()) {
                if (generatedKeys.first()) {
                    admin.setId(generatedKeys.getInt(1));
                    return admin;
                } else {
                    throw new RuntimeException("Generated key was not found");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Remove admin by id
     *
     * @param adminId
     */
    public static void delete(int adminId) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ADMIN_QUERY)) {
            statement.setInt(1, adminId);
            statement.executeUpdate();

            boolean deleted = statement.execute();
            if (!deleted) {
                throw new NotFoundException("Admin not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Update admin
     *
     * @param admin
     */
    public void update(Admin admin) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ADMIN_QUERY)) {
            statement.setString(1, admin.getFirstName());
            statement.setString(2, admin.getLastName());
            statement.setString(3, admin.getEmail());
            statement.setString(4, this.hashPass(admin.getPassword()));
            statement.setInt(5, admin.getSuperAdmin());
            statement.setInt(6, admin.getEnable());
            statement.setInt(7, admin.getId());

            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String hashPass(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public Admin findByFirstName(String firstName) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_ADMIN_QUERY_FIRSTNAME);
            statement.setString(1, firstName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Admin user = new Admin();
                return user.map(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Błąd pobierania użytkownika", ex);
        }
        return null;
    }

    public Admin findById(int id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(READ_ADMIN_QUERY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Admin admin = new Admin();
                return admin.map(resultSet);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new DaoException("Błąd pobierania użytkownika", ex);
        }
        return null;
    }
}
