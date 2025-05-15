package org.example.dao;

import org.example.dao.MiembrosDAO;
import org.example.model.Miembros;
import org.example.util.Conexion;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MiembrosDAOlmpl implements MiembrosDAO {

    @Override
    public void crear(Miembros miembro) {
        String sql = "INSERT INTO miembros (miembro_id, nombre, apellido, fecha_inscripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, miembro.getMiembro_id());
            stmt.setString(2, miembro.getNombre());
            stmt.setString(3, miembro.getApellido());
            stmt.setDate(4, Date.valueOf(miembro.getFecha_inscripcion()));

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Miembros buscar(String miembro_id) {
        String sql = "SELECT * FROM miembros WHERE miembro_id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(miembro_id));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Miembros miembro = new Miembros();
                miembro.setMiembro_id(rs.getInt("miembro_id"));
                miembro.setNombre(rs.getString("nombre"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setFecha_inscripcion(rs.getDate("fecha_inscripcion").toLocalDate());
                return miembro;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Miembros miembro) {
        String sql = "UPDATE miembros SET nombre = ?, apellido = ?, fecha_inscripcion = ? WHERE miembro_id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, miembro.getNombre());
            stmt.setString(2, miembro.getApellido());
            stmt.setDate(3, Date.valueOf(miembro.getFecha_inscripcion()));
            stmt.setInt(4, miembro.getMiembro_id());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String miembro_id) {
        String sql = "DELETE FROM miembros WHERE miembro_id = ?";
        try (Connection conn = Conexion.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt(miembro_id));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Miembros> listademiembros() {
        List<Miembros> miembros = new ArrayList<>();
        String sql = "SELECT * FROM miembros";
        try (Connection conn = Conexion.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Miembros miembro = new Miembros();
                miembro.setMiembro_id(rs.getInt("miembro_id"));
                miembro.setNombre(rs.getString("nombre"));
                miembro.setApellido(rs.getString("apellido"));
                miembro.setFecha_inscripcion(rs.getDate("fecha_inscripcion").toLocalDate());
                miembros.add(miembro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return miembros;
    }
}