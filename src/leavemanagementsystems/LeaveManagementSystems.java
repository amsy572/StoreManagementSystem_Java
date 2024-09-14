/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package leavemanagementsystems;

import java.sql.Connection;

import java.sql.PreparedStatement;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.time.LocalDateTime;

public class LeaveManagementSystems {

    public static void displayInventoryData() {
        Connection connection = SQLiteConnection.connect();
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                String selectQuery = "SELECT * FROM Inventory"; // Select all columns and rows from the 'Inventory' table

                ResultSet resultSet = statement.executeQuery(selectQuery);

                System.out.println("Inventory Data:");
                System.out.println("ItemCode | ItemName | Category | Quantity | Price | Description");

                while (resultSet.next()) {
                    int itemCode = resultSet.getInt("ItemCode");
                    String itemName = resultSet.getString("ItemName");
                    String category = resultSet.getString("Category");
                    int quantity = resultSet.getInt("Quantity");
                    double price = resultSet.getDouble("Price");
                    String description = resultSet.getString("Description");

                    // Display the retrieved data
                    System.out.println(itemCode + " | " + itemName + " | " + category + " | " + quantity + " | " + price + " | " + description);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void displaySalesReportData() {
        Connection connection = SQLiteConnection.connect();
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                String selectQuery = "SELECT * FROM InformSalesManager"; // Select all columns and rows from the 'Inventory' table

                ResultSet resultSet = statement.executeQuery(selectQuery);

                System.out.println("Sales Reports:");
                System.out.println("UserName | Message ");

                while (resultSet.next()) {
                    String UserName = resultSet.getString("UserName");
                    String Message = resultSet.getString("Message");

                    // Display the retrieved data
                    System.out.println(UserName + " | " + Message);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void displayInventoryReportData() {
        Connection connection = SQLiteConnection.connect();
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                String selectQuery = "SELECT * FROM InformInventoryManager"; // Select all columns and rows from the 'Inventory' table

                ResultSet resultSet = statement.executeQuery(selectQuery);

                System.out.println("Sales Reports:");
                System.out.println("UserName | Message ");

                while (resultSet.next()) {
                    String UserName = resultSet.getString("UserName");
                    String Message = resultSet.getString("Message");

                    // Display the retrieved data
                    System.out.println(UserName + " | " + Message);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void displayCancelBillData() {
        Connection connection = SQLiteConnection.connect();
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                String selectQuery = "SELECT * FROM CancelBills"; // Select all columns and rows from the 'Inventory' table

                ResultSet resultSet = statement.executeQuery(selectQuery);

                System.out.println("Cancel Bill Data:");
                System.out.println(" BillId | ItemCode | ItemName | Category | Quantity | Price | Date ");

                while (resultSet.next()) {
                    int itemCode = resultSet.getInt("ItemCode");
                    String itemName = resultSet.getString("ItemName");
                    String category = resultSet.getString("Category");
                    int quantity = resultSet.getInt("Quantity");
                    double price = resultSet.getDouble("Price");
                    int BillId = resultSet.getInt("BillId");
                    String Time = resultSet.getString("Date");

                    // Display the retrieved data
                    System.out.println(BillId + " | " + itemCode + " | " + itemName + " | " + category + " | " + quantity + " | " + price+ " | " + Time);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void displayBillData() {
        Connection connection = SQLiteConnection.connect();

        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                String selectQuery = "SELECT * FROM Bills"; // Select all columns and rows from the 'Inventory' table

                ResultSet resultSet = statement.executeQuery(selectQuery);

                System.out.println("Bill Data:");
                System.out.println(" BillId | ItemCode | ItemName | Category | Quantity | Price | Date");
                double totalPrice = 0.0;

                while (resultSet.next()) {
                    int itemCode = resultSet.getInt("ItemCode");
                    String itemName = resultSet.getString("ItemName");
                    String category = resultSet.getString("Category");
                    int quantity = resultSet.getInt("Quantity");
                    double price = resultSet.getDouble("Price");
                    int BillId = resultSet.getInt("BillId");
                    String Time = resultSet.getString("Date");
                    totalPrice += price;

                    // Display the retrieved data
                    System.out.println(BillId + " | " + itemCode + " | " + itemName + " | " + category + " | " + quantity + " | " + price+" | " + Time);
                }
                System.out.println("Total Price: "+totalPrice);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void SearchInventoryData(String item) {
        Connection connection = SQLiteConnection.connect();
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                String selectQuery = "SELECT * FROM Inventory  WHERE ItemName = '" + item + "' OR Category = '" + item + "';"; // Select all columns and rows from the 'Inventory' table

                ResultSet resultSet = statement.executeQuery(selectQuery);

                System.out.println("Inventory Data:");
                System.out.println("ItemCode | ItemName | Category | Quantity | Price | Description");

                while (resultSet.next()) {
                    int itemCode = resultSet.getInt("ItemCode");
                    String itemName = resultSet.getString("ItemName");
                    String category = resultSet.getString("Category");
                    int quantity = resultSet.getInt("Quantity");
                    double price = resultSet.getDouble("Price");
                    String description = resultSet.getString("Description");

                    // Display the retrieved data
                    System.out.println(itemCode + " | " + itemName + " | " + category + " | " + quantity + " | " + price + " | " + description);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createInventoryTable() {
        Connection connection = SQLiteConnection.connect();
        Scanner scanner = new Scanner(System.in);
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                // SQL statement to create the 'Inventory' table if it doesn't exist
                String createTableSQL = "CREATE TABLE IF NOT EXISTS Inventory ("
                        + "ItemCode INTEGER PRIMARY KEY,"
                        + "ItemName TEXT,"
                        + "Category TEXT,"
                        + "Quantity INTEGER,"
                        + "Price REAL,"
                        + "Description TEXT)";
                statement.execute(createTableSQL);
                System.out.println("Table 'Inventory' created or already exists.");
                System.out.print("Enter ItemCode: ");
                int ItemCode = scanner.nextInt();
                System.out.print("Enter ItemName: ");
                String ItemName = scanner.next();
                System.out.print("Enter Category: ");
                String Category = scanner.next();
                System.out.print("Enter Quantity: ");
                int Quantity = scanner.nextInt();
                System.out.print("Enter Price: ");
                double Price = scanner.nextDouble();
                System.out.print("Enter Description: ");
                String Description = scanner.next();
                insertInventoryData(ItemCode, ItemName, Category, Quantity, Price, Description);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createBillTable() {
        Connection connection = SQLiteConnection.connect();
        Scanner scanner = new Scanner(System.in);
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                // SQL statement to create the 'Inventory' table if it doesn't exist
                String createTableSQL = "CREATE TABLE IF NOT EXISTS Bills ("
                        + "ItemCode INTEGER ,"
                        + "ItemName TEXT,"
                        + "Category TEXT,"
                        + "Quantity INTEGER,"
                        + "Date DATETIME,"
                        + "Price REAL,"
                        + "BillId INTEGER PRIMARY KEY)";
                statement.execute(createTableSQL);
                System.out.print("Enter Item Name: ");
                String item = scanner.next();
                String selectQuery = "SELECT * FROM Inventory  WHERE ItemName = '" + item + "';"; // Select all columns and rows from the 'Inventory' table

                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    int itemCode = resultSet.getInt("ItemCode");
                    String itemName = resultSet.getString("ItemName");
                    String category = resultSet.getString("Category");
                    double price = resultSet.getDouble("Price");
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    System.out.print("Enter BillId: ");
                    int BillId = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    int Quantity = scanner.nextInt();

                    String insertSQL = "INSERT INTO Bills (ItemCode, ItemName, Category, Quantity, Price, BillId,Date) VALUES (?, ?, ?, ?, ?, ?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setInt(1, itemCode);
                    preparedStatement.setString(2, itemName);
                    preparedStatement.setString(3, category);
                    preparedStatement.setInt(4, Quantity);
                    preparedStatement.setDouble(5, price);
                    preparedStatement.setInt(6, BillId);
                    preparedStatement.setString(7, currentDateTime.toString());
                    int rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " rows inserted successfully.");
                    displayBillData();

                    // Display the retrieved data
//                    System.out.println(itemCode + " | " + itemName + " | " + category + " | " + quantity + " | " + price + " | " + description);
//                    insertBillData(itemCode, itemName, category, Quantity, price, BillId);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createCancelBillTable() {
        Connection connection = SQLiteConnection.connect();
        Scanner scanner = new Scanner(System.in);
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                // SQL statement to create the 'Inventory' table if it doesn't exist
                String createTableSQL = "CREATE TABLE IF NOT EXISTS CancelBills ("
                        + "ItemCode INTEGER ,"
                        + "ItemName TEXT,"
                        + "Category TEXT,"
                        + "Quantity INTEGER,"
                        + "Price REAL,"
                        + "Date DATETIME,"
                        + "BillId INTEGER PRIMARY KEY)";
                statement.execute(createTableSQL);
                System.out.print("Enter Bill ID: ");
                int Bill = scanner.nextInt();
                String selectQuery = "SELECT * FROM Bills  WHERE BillId = '" + Bill + "';"; // Select all columns and rows from the 'Inventory' table

                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    int itemCode = resultSet.getInt("ItemCode");
                    String itemName = resultSet.getString("ItemName");
                    String category = resultSet.getString("Category");
                    int quantity = resultSet.getInt("Quantity");
                    double price = resultSet.getDouble("Price");
                    int BillId = resultSet.getInt("BillId");
                    LocalDateTime currentDateTime = LocalDateTime.now();

                    String insertSQL = "INSERT INTO CancelBills (ItemCode, ItemName, Category, Quantity, Price, BillId,Date) VALUES (?, ?, ?, ?, ?, ?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                    preparedStatement.setInt(1, itemCode);
                    preparedStatement.setString(2, itemName);
                    preparedStatement.setString(3, category);
                    preparedStatement.setInt(4, quantity);
                    preparedStatement.setDouble(5, price);
                    preparedStatement.setInt(6, BillId);
                    preparedStatement.setString(7, currentDateTime.toString());
                    int rowsAffected = preparedStatement.executeUpdate();
                    System.out.println(rowsAffected + " rows inserted successfully.");
                    displayCancelBillData();

                    // Display the retrieved data
//                    System.out.println(itemCode + " | " + itemName + " | " + category + " | " + quantity + " | " + price + " | " + description);
//                    insertBillData(itemCode, itemName, category, Quantity, price, BillId);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createInformInventoryManagerTable() {
        Connection connection = SQLiteConnection.connect();
        Scanner scanner = new Scanner(System.in);
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                // SQL statement to create the 'Inventory' table if it doesn't exist
                String createTableSQL = "CREATE TABLE IF NOT EXISTS InformInventoryManager ("
                        + "UserName TEXT ,"
                        + "Message TEXT)";
                statement.execute(createTableSQL);
                System.out.print("Enter Your UserName: ");
                String UserName = scanner.next();
                System.out.print("Write Your Message: ");
                String Message = scanner.next();

                String insertSQL = "INSERT INTO InformInventoryManager (UserName, Message) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                preparedStatement.setString(1, UserName);
                preparedStatement.setString(2, Message);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " Message sent successfully.");

                // Display the retrieved data
//                    System.out.println(itemCode + " | " + itemName + " | " + category + " | " + quantity + " | " + price + " | " + description);
//                    insertBillData(itemCode, itemName, category, Quantity, price, BillId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createInformSalesManagerTable() {
        Connection connection = SQLiteConnection.connect();
        Scanner scanner = new Scanner(System.in);
        if (connection != null) {
            try ( Statement statement = connection.createStatement()) {
                // SQL statement to create the 'Inventory' table if it doesn't exist
                String createTableSQL = "CREATE TABLE IF NOT EXISTS InformSalesManager ("
                        + "UserName TEXT ,"
                        + "Message TEXT)";
                statement.execute(createTableSQL);
                System.out.print("Enter Your UserName: ");
                String UserName = scanner.next();
                System.out.print("Write Your Message: ");
                String Message = scanner.next();

                String insertSQL = "INSERT INTO InformSalesManager (UserName, Message) VALUES (?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                preparedStatement.setString(1, UserName);
                preparedStatement.setString(2, Message);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " Message sent successfully.");

                // Display the retrieved data
//                    System.out.println(itemCode + " | " + itemName + " | " + category + " | " + quantity + " | " + price + " | " + description);
//                    insertBillData(itemCode, itemName, category, Quantity, price, BillId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void insertInventoryData(int itemCode, String itemName, String category, int quantity, double price, String description) {
        Connection connection = SQLiteConnection.connect();

        if (connection != null) {
            try {
                String insertSQL = "INSERT INTO Inventory (ItemCode, ItemName, Category, Quantity, Price, Description) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
                preparedStatement.setInt(1, itemCode);
                preparedStatement.setString(2, itemName);
                preparedStatement.setString(3, category);
                preparedStatement.setInt(4, quantity);
                preparedStatement.setDouble(5, price);
                preparedStatement.setString(6, description);
                int rowsAffected = preparedStatement.executeUpdate();
                System.out.println(rowsAffected + " rows inserted successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void registerUser(String username, String password) {
        String insertQuery = "INSERT INTO Users (username, password) VALUES ('" + username + "', '" + password + "');";

        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery);
            System.out.println("User registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void registerAdmin(String username, String password) {
        String insertQuery = "INSERT INTO Admin (username, password) VALUES ('" + username + "', '" + password + "');";

        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery);
            System.out.println("User registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void registerSalesManager(String username, String password) {
        String insertQuery = "INSERT INTO SalesManager (username, password) VALUES ('" + username + "', '" + password + "');";

        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery);
            System.out.println("User registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void registerInventoryManager(String username, String password) {
        String insertQuery = "INSERT INTO InventoryManager (username, password) VALUES ('" + username + "', '" + password + "');";

        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
            statement.executeUpdate(insertQuery);
            System.out.println("User registered successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changeInventoryManagerPassword(String username, String newPassword) {
        String updateQuery = "UPDATE InventoryManager SET password = ? WHERE username = ?";

        try ( Connection connection = SQLiteConnection.connect();  PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("User not found or password not changed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changeSalesManagerPassword(String username, String newPassword) {
        String updateQuery = "UPDATE SalesManage SET password = ? WHERE username = ?";

        try ( Connection connection = SQLiteConnection.connect();  PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("User not found or password not changed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changeAdminPassword(String username, String newPassword) {
        String updateQuery = "UPDATE Admin SET password = ? WHERE username = ?";

        try ( Connection connection = SQLiteConnection.connect();  PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("User not found or password not changed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void changeSalesPersonPassword(String username, String newPassword) {
        String updateQuery = "UPDATE Users SET password = ? WHERE username = ?";

        try ( Connection connection = SQLiteConnection.connect();  PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, newPassword);
            preparedStatement.setString(2, username);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Password changed successfully.");
            } else {
                System.out.println("User not found or password not changed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean authenticateUser(String username, String password) {
        String selectQuery = "SELECT * FROM Users WHERE username = '" + username + "' AND password = '" + password + "';";

        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            return resultSet.next(); // Returns true if the user exists with the provided username and password
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean authenticateInventoryManager(String username, String password) {
        String selectQuery = "SELECT * FROM InventoryManager WHERE username = '" + username + "' AND password = '" + password + "';";

        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            return resultSet.next(); // Returns true if the user exists with the provided username and password
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean authenticateAdmin(String username, String password) {
        String selectQuery = "SELECT * FROM Admin WHERE username = '" + username + "' AND password = '" + password + "';";

        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            return resultSet.next(); // Returns true if the user exists with the provided username and password
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean authenticateSalesManager(String username, String password) {
        String selectQuery = "SELECT * FROM SalesManager WHERE username = '" + username + "' AND password = '" + password + "';";

        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            return resultSet.next(); // Returns true if the user exists with the provided username and password
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nADMIN");
        System.out.println("1. Create Admin Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                try {

                String createTableQuery = "CREATE TABLE IF NOT EXISTS Admin ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "username TEXT,"
                        + "password TEXT)";
                try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
                    statement.executeUpdate(createTableQuery);
                }

                // User registration
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();
                registerAdmin(username, password);

            } catch (Exception e) {
                e.printStackTrace();
            }
            break;
            case 2:
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();
                if (authenticateAdmin(username, password)) {
                    System.out.println("\nADMIN MENU");
                    System.out.println("1. Create User Account");
                    System.out.println("2. Change Password");
                    System.out.println("3. Add New Item");
                    System.out.println("4. Exit");
                    System.out.print("Enter your choice: ");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("\nADMIN MENU");
                            System.out.println("1. Create Sales Person Account");
                            System.out.println("2. Create Sales Manager Account");
                            System.out.println("3. Create Inventory Manager Account");
                            System.out.println("4. Exit");
                            System.out.print("Enter your choice: ");
                            choice = scanner.nextInt();
                            switch (choice) {
                                case 1 -> {
                                    try {
                                        
                                        String createTableQuery = "CREATE TABLE IF NOT EXISTS Users ("
                                                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                + "username TEXT,"
                                                + "password TEXT)";
                                        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
                                            statement.executeUpdate(createTableQuery);
                                        }
                                        
                                        // User registration
                                        System.out.print("Enter username: ");
                                        username = scanner.next();
                                        System.out.print("Enter password: ");
                                        password = scanner.next();
                                        registerUser(username, password);
                                        
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                            }
                                    
                                case 2 -> {
                                    try {
                                        
                                        String createTableQuery = "CREATE TABLE IF NOT EXISTS SalesManager ("
                                                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                + "username TEXT,"
                                                + "password TEXT)";
                                        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
                                            statement.executeUpdate(createTableQuery);
                                        }
                                        
                                        // User registration
                                        System.out.print("Enter username: ");
                                        String Susername = scanner.next();
                                        System.out.print("Enter password: ");
                                        String Spassword = scanner.next();
                                        registerSalesManager(Susername, Spassword);
                                        
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                            }
                                    
                                case 3 -> {
                                    try {
                                        
                                        String createTableQuery = "CREATE TABLE IF NOT EXISTS InventoryManager ("
                                                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                                + "username TEXT,"
                                                + "password TEXT)";
                                        try ( Connection connection = SQLiteConnection.connect();  Statement statement = connection.createStatement()) {
                                            statement.executeUpdate(createTableQuery);
                                        }
                                        
                                        // User registration
                                        System.out.print("Enter username: ");
                                        username = scanner.next();
                                        System.out.print("Enter password: ");
                                        password = scanner.next();
                                        registerInventoryManager(username, password);
                                        
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                            }
                                    
                                case 4 -> {
                                    return;
                            }
                                default -> System.out.println("Invalid choice");
                            }
                }
                        case 2 -> {
                            System.out.print("Enter username: ");
                            username = scanner.nextLine();
                            System.out.print("Enter New password: ");
                            password = scanner.nextLine();
                            changeAdminPassword(username, password);
                }
                        case 3 -> createInventoryTable();

                        case 4 -> {
                            return;
                }
                        default -> System.out.println("Invalid choice");
                    }

                } else {
                    System.out.println("Login failed. Invalid username or password.");
                }
//                          while (true) {

                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice");
        }

    }

    public static void userLogin() {
        try {
            // Create the Users table if it doesn't exist
            // ... (same as in the previous code)

            // User login
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (authenticateUser(username, password)) {
                System.out.println("Login successful.");

                System.out.println("\nUSER MENU");
                System.out.println("1. Inventory Status");
                System.out.println("2. Search Item");
                System.out.println("3. Purchased Item");
                System.out.println("4. Cancel Bill");
                System.out.println("5. Inform Inventory Manager");
                System.out.println("6. Inform Sales Manager");
                    System.out.println("7.Change Password");
                System.out.println("8. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> displayInventoryData();
                    case 2 -> {
                        System.out.print("Search Item By Name Or Category: ");
                        String item = scanner.next();
                        SearchInventoryData(item);
                    }
                    case 3 -> createBillTable();
                    case 4 -> createCancelBillTable();

                    case 5 -> createInformSalesManagerTable();

                    case 6 -> createInformInventoryManagerTable();

                    case 7 -> {
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                        System.out.print("Enter New password: ");
                        password = scanner.nextLine();
                        changeSalesPersonPassword(username, password);
                    }
                    case 8 -> {
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }

            } else {
                System.out.println("Login failed. Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void InventoryManagerLogin() {
        try {
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (authenticateInventoryManager(username, password)) {
                System.out.println("Login successful.");

                System.out.println("\nInventory MENU");
                System.out.println("1. Inventory Status");
                System.out.println("2. Sales Reports");
                System.out.println("3. Generate Inventory Roport");
                System.out.println("4. Change Password");
                System.out.println("5. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        displayInventoryData();
                        break;
                    case 2:
                        displayInventoryReportData();
                        break;
                    case 3:
                        displayInventoryReportData();
                        break;
                    case 4:
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                        System.out.print("Enter New password: ");
                        password = scanner.nextLine();
                        changeInventoryManagerPassword(username, password);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid choice");
                }

            } else {
                System.out.println("Login failed. Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void SalesManagerLogin() {
        try {
            // Create the Users table if it doesn't exist
            // ... (same as in the previous code)

            // User login
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (authenticateSalesManager(username, password)) {
                System.out.println("Login successful.");

                System.out.println("\nSales MENU");
                System.out.println("1. Bills & Money Status");
                System.out.println("2. Cancel Bills Status");
                System.out.println("3. Sales Report");
                System.out.println("4. Generate Report");
                System.out.println("5. Change Password");
                System.out.println("6. Logout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 ->
                        displayBillData();

                    case 2 ->
                        displayCancelBillData();
                    case 3 ->
                        displaySalesReportData();

                    case 4 ->
                        displayBillData();

                    case 5 -> {
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                        System.out.print("Enter New password: ");
                        password = scanner.nextLine();
                        changeSalesManagerPassword(username, password);
                    }
                    

                    case 6 -> {
                        return;
                    }
                    
                  
                    default ->
                        System.out.println("Invalid choice");
                }

            } else {
                System.out.println("Login failed. Invalid username or password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//      displayInventoryData();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Leave Management System");

        while (true) {
            System.out.println("\nLOGIN");
            System.out.println("1. Admin");
            System.out.println("2. Sales Person");
            System.out.println("3. Inventory Manager");
            System.out.println("4. Sales Manager");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;

                case 3:
                    InventoryManagerLogin();
                    break;

                case 4:
                    SalesManagerLogin();
                    break;
                case 5:
                    System.out.println("Exiting the ATM System");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }


    }

}
