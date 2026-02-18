package org.example.Service;

import org.example.Model.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class SistemaGestionEstudiantes {

    List<Estudiante> estudiantes= new ArrayList<>();//se crea la lista

    public void registrarEstudiantes(Estudiante estudiante){
        estudiantes.add(estudiante);
    }
    public List<Estudiante> listarEstudiates(){
        return estudiantes;
    }
    public Estudiante buscarEstudiante(int id){//filtro para buscar estudiante por el id
        for (Estudiante i: estudiantes){
            if(i.getId()== id){
                return i;
            }
        }
         return null;
    }
    public Estudiante eliminarEstudiante(int id){//reutilizo el metodo para buscar al estudiante que deseo eliminar
        Estudiante Encontrado=buscarEstudiante(id);
        if (Encontrado == null){
            return null;
        }
        estudiantes.remove(Encontrado);
        return Encontrado;
    }
    public Estudiante modificarEstudiante(int id, String nuevoNombre, String nuevoCorreo, String nuevoPrograma){// metodo que actuaiza nformacion del estudiante

        Estudiante encontrado = buscarEstudiante(id);

        if(encontrado == null){
            return null;
        }

        encontrado.setNombre(nuevoNombre);
        encontrado.setCorreo(nuevoCorreo);
        encontrado.setProgramaAcademico(nuevoPrograma);

        return encontrado;
    }










}
