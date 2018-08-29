package com.example.tarrito.tarea_4.models;

import com.example.tarrito.tarea_4.application.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Alumno extends RealmObject {

    @PrimaryKey
    private int Id;
    private String Rut;
    private String Nombre;
    private String Apellidos;
    private int Edad;
    private String Carrera;
    private int Ano;
    private String Semestre;

    public Alumno() {} // Only for Realm

    public Alumno(String Rut, String Nombre, String Apellidos, int Edad, String Carrera, int Ano, String Semestre) {
        this.Id = MyApplication.alumnoID.incrementAndGet();
        this.Rut = Rut;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Edad = Edad;
        this.Carrera = Carrera;
        this.Ano = Ano;
        this.Semestre = Semestre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getRut() {
        return Rut;
    }

    public void setRut(String rut) {
        this.Rut = rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        this.Apellidos = apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        this.Edad = edad;
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String carrera) {
        this.Carrera = carrera;
    }

    public int getAno() {
        return Ano;
    }

    public void setAno(int ano) {
        this.Ano = ano;
    }

    public String getSemestre() {
        return Semestre;
    }

    public void setSemestre(String semestre) {
        this.Semestre = semestre;
    }
}