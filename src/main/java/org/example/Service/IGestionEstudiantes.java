package org.example.Service;

import org.example.Model.Estudiante;
import java.util.List;

public interface IGestionEstudiantes {

    void registrarEstudiantes(Estudiante estudiante);

    List<Estudiante> listarEstudiantes();

    Estudiante buscarEstudiante(int id);

    Estudiante eliminarEstudiante(int id);

    Estudiante modificarEstudiante(int id, String nombre, String correo, String programa);
}
