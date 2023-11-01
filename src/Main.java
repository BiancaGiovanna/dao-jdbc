import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.Database;
import database.DatabaseIntegrityException;

public class Main {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = Database.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM department "
                            + "WHERE "
                            + "Id = ?");

            st.setInt(1, 5);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new DatabaseIntegrityException(e.getMessage());
        } finally {
            Database.closeStatement(st);
            Database.closeConnection();
        }
    }
}