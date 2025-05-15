package org.example.dao;

import org.example.model.Miembros;

import java.util.List;

public interface MiembrosDAO {
    void crear(Miembros miembro_id);
    Miembros buscar(String miembro_id);
    void actualizar(Miembros miembro);
    void eliminar(String miembro_id);
    List<Miembros> listademiembros();
}
