package com.example.service;

import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceJdbcImpl implements PersonService {

    @Autowired
    DataSource dataSource;

    @Override
    public void addPerson(Person person) {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSON(FIRSTNAME,LASTNAME) VALUES (?,?)");
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());

            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }

    }

    @Override
    public List<Person> listPeople() {
        Connection connection = null;
        List<Person> people = new ArrayList<Person>();

        try {
            connection = dataSource.getConnection();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM PERSON");
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("ID"));
                person.setFirstName(resultSet.getString("FIRSTNAME"));
                person.setLastName(resultSet.getString("LASTNAME"));

                people.add(person);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }

        return people;
    }

    @Override
    public void removePerson(Integer id) {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PERSON WHERE PERSON.ID=?");
            preparedStatement.setInt(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }

    }
}
