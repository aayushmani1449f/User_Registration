package com.addressbook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBService implements IAddressBookDataService {

    private static final String URL = "jdbc:mysql://localhost:3306/address_book_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // Set actual password

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public void writeData(List<Contact> contacts) {
        // Implement in UC19
    }

    @Override
    public void readData() {
        List<Contact> contacts = readDataFromDB();
        System.out.println("Contacts read from DB: ");
        contacts.forEach(System.out::println);
    }

    public List<Contact> readDataFromDB() {
        List<Contact> contactList = new ArrayList<>();
        String query = "SELECT * FROM contacts";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            
            while (resultSet.next()) {
                Contact contact = new Contact(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("address"),
                        resultSet.getString("city"),
                        resultSet.getString("state"),
                        resultSet.getString("zip"),
                        resultSet.getString("phone_number"),
                        resultSet.getString("email")
                );
                contactList.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactList;
    }
}
