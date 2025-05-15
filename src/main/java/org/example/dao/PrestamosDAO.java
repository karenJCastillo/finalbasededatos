package org.example.dao;
import org.example.model.Prestamos;
import java.util.List;
public interface PrestamosDAO {
        void crear(Prestamos prestamo);
        Prestamos buscar(String prestamo_id);
        void actualizar(Prestamos prestamo);
        void eliminar(String prestamo_id);
        List<Prestamos> listadeprestamos();

}
