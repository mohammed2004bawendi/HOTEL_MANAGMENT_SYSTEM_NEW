package org.example.models;

import java.sql.*;
import java.util.ArrayList;

public class OdaDAO {

    // إنشاء الجدول إذا لم يكن موجودًا
    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS oda (" +
                "odaNumarasi INTEGER PRIMARY KEY, " +
                "kapasite INTEGER NOT NULL, " +
                "fiyat REAL NOT NULL, " +
                "durum TEXT NOT NULL, " +
                "manzara TEXT NOT NULL" +
                ");";

        try (Connection conn = ConnectDB.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'oda' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
        }
    }

    // إضافة غرفة جديدة مع التحقق من وجودها
    public static void insertOda(OdaDTO oda) {
        // تحقق مما إذا كانت الغرفة موجودة بالفعل
        if (isOdaExists(oda.getOdaNumarasi())) {
            System.err.println("Error: Oda zaten mevcut (Oda Numarası: " + oda.getOdaNumarasi() + ")");
            return;
        }

        String sql = "INSERT INTO oda (odaNumarasi, kapasite, fiyat, durum, manzara) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, oda.getOdaNumarasi());
            pstmt.setInt(2, oda.getKapasite());
            pstmt.setDouble(3, oda.getFiyat());
            pstmt.setString(4, oda.getDurum());
            pstmt.setString(5, oda.getManzara());
            pstmt.executeUpdate();
            System.out.println("Oda başarıyla eklendi.");
        } catch (SQLException e) {
            System.err.println("Error adding Oda: " + e.getMessage());
        }
    }

    // التحقق من وجود الغرفة في قاعدة البيانات
    public static boolean isOdaExists(int odaNumarasi) {
        String sql = "SELECT COUNT(*) FROM oda WHERE odaNumarasi = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, odaNumarasi);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                return true; // الغرفة موجودة
            }
        } catch (SQLException e) {
            System.err.println("Error checking Oda existence: " + e.getMessage());
        }
        return false; // الغرفة غير موجودة
    }

    // عرض جميع الغرف كقائمة نصوص
    public static ArrayList<String> getAllOdaAsList() {
        ArrayList<String> odaList = new ArrayList<>();
        String sql = "SELECT * FROM oda";

        try (Connection conn = ConnectDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String odaInfo = "Oda No: " + rs.getInt("odaNumarasi") +
                        ", Kapasite: " + rs.getInt("kapasite") +
                        ", Fiyat: " + rs.getDouble("fiyat") +
                        ", Durum: " + rs.getString("durum") +
                        ", Manzara: " + rs.getString("manzara");
                odaList.add(odaInfo);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving Oda list: " + e.getMessage());
        }

        return odaList;
    }

    // تحديث حالة الغرفة
    public static void updateOdaDurum(int odaNumarasi, String yeniDurum) {
        String sql = "UPDATE oda SET durum = ? WHERE odaNumarasi = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, yeniDurum);
            pstmt.setInt(2, odaNumarasi);
            pstmt.executeUpdate();
            System.out.println("Oda durumu başarıyla güncellendi.");
        } catch (SQLException e) {
            System.err.println("Error updating Oda: " + e.getMessage());
        }
    }

    // حذف غرفة
    public static void deleteOda(int odaNumarasi) {
        String sql = "DELETE FROM oda WHERE odaNumarasi = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, odaNumarasi);
            pstmt.executeUpdate();
            System.out.println("Oda başarıyla silindi.");
        } catch (SQLException e) {
            System.err.println("Error deleting Oda: " + e.getMessage());
        }
    }
}
