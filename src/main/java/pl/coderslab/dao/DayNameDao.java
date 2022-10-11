package pl.coderslab.dao;
import pl.coderslab.utils.DbUtil;
import pl.coderslab.model.DayName;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DayNameDao {
    private static final String FIND_ALL_DAY_NAMES_QUERY = "SELECT * FROM dayName;";
    public List<DayName> findAll() {
        List<DayName> dayNames = new ArrayList<>();
       try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_DAY_NAMES_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                DayName dayNameToAdd = new DayName();
                dayNameToAdd.setId(resultSet.getInt("id"));
                dayNameToAdd.setName(resultSet.getString("name"));
                dayNameToAdd.setDisplayOrder(resultSet.getInt("displayOrder"));
                dayNames.add(dayNameToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dayNames;

    }
}
