package org.example.models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        OdaDAO.createTable();

        OdaDTO oda = new OdaDTO();
        oda.setOdaNumarasi(101);
        oda.setKapasite(2);
        oda.setFiyat(300.5);
        oda.setDurum("Boş");
        oda.setManzara("Deniz");

        OdaDAO.insertOda(oda);
        OdaDAO.getAllOdaAsList();
    }
}
