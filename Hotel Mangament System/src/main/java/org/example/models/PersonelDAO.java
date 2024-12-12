import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonelDAO {
    // Add a personel record to the database
    public void addPersonel(Personel personel) {
        String sql = "INSERT INTO personnel (isimSoyisim, personelKimlik, gorevAlani, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, personel.getIsimSoyisim());
            stmt.setString(2, personel.getPersonelKimlik());
            stmt.setString(3, personel.getGorevAlani());
            stmt.setDouble(4, personel.getSalary());
            stmt.executeUpdate();
            System.out.println("Personnel added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error adding personnel.");
        }
    }

    // Retrieve all personel records from the database
    public List<Personel> getAllPersonel() {
        List<Personel> personelList = new ArrayList<>();
        String sql = "SELECT * FROM personnel";
        try (Connection conn = DatabaseUtils.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String isimSoyisim = rs.getString("isimSoyisim");
                String personelKimlik = rs.getString("personelKimlik");
                String gorevAlani = rs.getString("gorevAlani");
                double salary = rs.getDouble("salary");
                personelList.add(new Personel(isimSoyisim, personelKimlik, gorevAlani, salary));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error retrieving personnel.");
        }
        return personelList;
    }

    // Delete a personel record by ID
    public void deletePersonel(String personelKimlik) {
        String sql = "DELETE FROM personnel WHERE personelKimlik = ?";
        try (Connection conn = DatabaseUtils.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, personelKimlik);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Personnel deleted successfully!");
            } else {
                System.out.println("Personnel not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error deleting personnel.");
        }
    }
}
