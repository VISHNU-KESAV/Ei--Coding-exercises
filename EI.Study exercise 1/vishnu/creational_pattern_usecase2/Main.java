class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        System.out.println("Database Connection created!");
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to the database.");
    }

    public void disconnect() {
        System.out.println("Disconnected from the database.");
    }
}

public class Main {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        db1.connect();

        DatabaseConnection db2 = DatabaseConnection.getInstance();
        db2.disconnect();

        if (db1 == db2) {
            System.out.println("Both are the same instance.");
        }
    }
}
