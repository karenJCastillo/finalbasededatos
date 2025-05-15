package org.example.dao;


import org.example.dao.AutoresDAO;
import org.example.model.Autores;
import org.example.util.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoresDAOlmpl implements AutoresDAO {

    @Override
    public void crear(Autores autor) {
        String sql = "INSERT INTO autores(nombre, apellido, nacionalidad) VALUES (?, ?, ?)";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApellido());
            ps.setString(3, autor.getNacionalidad());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Autores buscar(String autor_id) {
        String sql = "SELECT * FROM autores WHERE autor_id = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(autor_id));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Autores(rs.getInt("autor_id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("nacionalidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void actualizar(Autores autor) {
        String sql = "UPDATE autores SET nombre = ?, apellido = ?, nacionalidad = ? WHERE autor_id = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getApellido());
            ps.setString(3, autor.getNacionalidad());
            ps.setInt(4, autor.getAutor_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(String autor_id) {
        String sql = "DELETE FROM autores WHERE autor_id = ?";
        try (Connection con = Conexion.obtenerConexion(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(autor_id));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Autores> listadeautores() {
        List<Autores> lista = new ArrayList<>();
        String sql = "SELECT * FROM autores";
        try (Connection con = Conexion.obtenerConexion(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Autores(rs.getInt("autor_id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("nacionalidad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}