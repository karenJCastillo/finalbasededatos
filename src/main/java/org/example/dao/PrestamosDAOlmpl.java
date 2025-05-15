package org.example.dao;

import org.example.dao.PrestamosDAO;
import org.example.model.Prestamos;
import org.example.util.Conexion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestamosDAOlmpl implements PrestamosDAO {

    @Override
    public void crear(Prestamos prestamo) {
        String sql = "INSERT INTO prestamos (prestamo_id, libro_id, miembro_id, fecha_prestamo, fecha_devolucion) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, prestamo.getPrestamo_id());
            stmt.setInt(2, prestamo.getLibro_id());
            stmt.setInt(3, prestamo.getMiembro_id());
            stmt.setDate(4, Date.valueOf(prestamo.getFecha_prestamo()));
            stmt.setDate(5, Date.valueOf(prestamo.getFecha_devolucion()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Prestamos buscar(String prestamo_id) {
        String sql = "SELECT * FROM prestamos WHERE prestamo_id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(prestamo_id));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Prestamos prestamo = new Prestamos();
                prestamo.setPrestamo_id(rs.getInt("prestamo_id"));
                prestamo.setLibro_id(rs.getInt("libro_id"));
                prestamo.setMiembro_id(rs.getInt("miembro_id"));
                prestamo.setFecha_prestamo(rs.getDate("fecha_prestamo").toLocalDate());
                prestamo.setFecha_devolucion(rs.getDate("fecha_devolucion").toLocalDate());
                return prestamo;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Prestamos prestamo) {
        String sql = "UPDATE prestamos SET libro_id = ?, miembro_id = ?, fecha_prestamo = ?, fecha_devolucion = ? WHERE prestamo_id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, prestamo.getLibro_id());
            stmt.setInt(2, prestamo.getMiembro_id());
            stmt.setDate(3, Date.valueOf(prestamo.getFecha_prestamo()));
            stmt.setDate(4, Date.valueOf(prestamo.getFecha_devolucion()));
            stmt.setInt(5, prestamo.getPrestamo_id());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String prestamo_id) {
        String sql = "DELETE FROM prestamos WHERE prestamo_id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(prestamo_id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Prestamos> listadeprestamos() {
        List<Prestamos> prestamos = new ArrayList<>();
        String sql = "SELECT * FROM prestamos";
        try (Connection conn = Conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Prestamos prestamo = new Prestamos();
                prestamo.setPrestamo_id(rs.getInt("prestamo_id"));
                prestamo.setLibro_id(rs.getInt("libro_id"));
                prestamo.setMiembro_id(rs.getInt("miembro_id"));
                prestamo.setFecha_prestamo(rs.getDate("fecha_prestamo").toLocalDate());
                prestamo.setFecha_devolucion(rs.getDate("fecha_devolucion").toLocalDate());
                prestamos.add(prestamo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prestamos;
    }
}