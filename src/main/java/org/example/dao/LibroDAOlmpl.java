package org.example.dao;

import org.example.model.Libro;
import org.example.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroDAOlmpl implements LibroDAO {

    @Override
    public void crear(Libro libro) {
        String sql = "INSERT INTO libro(titulo, genero, autor_id) VALUES (?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getGenero());
            ps.setInt(3, libro.getAutor_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Libro buscar(String libro_id) {
        String sql = "SELECT * FROM libro WHERE libro_id = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(libro_id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Libro(rs.getInt("libro_id"), rs.getString("titulo"), rs.getString("genero"), rs.getInt("autor_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Libro libro) {
        String sql = "UPDATE libro SET titulo = ?, genero = ?, autor_id = ? WHERE libro_id = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getGenero());
            ps.setInt(3, libro.getAutor_id());
            ps.setInt(4, libro.getLibro_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String libro_id) {
        String sql = "DELETE FROM libro WHERE libro_id = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(libro_id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Libro> listadelibros() {
        List<Libro> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        try (Connection con = Conexion.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Libro(rs.getInt("libro_id"), rs.getString("titulo"), rs.getString("genero"), rs.getInt("autor_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}