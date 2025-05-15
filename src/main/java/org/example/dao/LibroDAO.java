package org.example.dao;
import org.example.model.Libro;
import java.util.List;
public interface LibroDAO {
    void crear(Libro libro);
    Libro buscar(String libro_id);
    void actualizar(Libro libro);
    void eliminar(String libro_id);
    List<Libro> listadelibros();
}
