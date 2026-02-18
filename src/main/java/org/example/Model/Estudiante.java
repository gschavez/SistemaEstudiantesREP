package org.example.Model;

public class Estudiante {
    private int id;
    private String nombre;
    private String correo;
    private String programaAcademico;
    private static int contador = 0;


    public Estudiante(String correo, String nombre, String programaAcademico) {//constructor sin id puesto que este se asignara por el sistema
        this.id=++contador; //se genera el id cada vez que se crea un objeto
        this.correo = correo;
        this.nombre = nombre;
        this.programaAcademico = programaAcademico;

    }

    public int getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "correo='" + correo + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", programaAcademico='" + programaAcademico + '\'' +
                '}';
    }



}
