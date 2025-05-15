package org.example.dao;

import org.example.model.Autores;
import java.util.List;

public interface AutoresDAO {
    void crear(Autores autor);
    Autores buscar(String autor_id);
    void actualizar(Autores autor);
    void eliminar(String autor_id);
    List<Autores> listadeautores();
}
