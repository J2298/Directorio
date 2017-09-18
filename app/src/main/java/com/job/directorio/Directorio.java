package com.job.directorio;

public class Directorio {

    String nombre;
    String correo;
    String oficina;
    int telefono;

    public Directorio() {
    }

    public Directorio(String nombre, String correo, String oficina, int telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.oficina = oficina;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getOficina() {
        return oficina;
    }

    public void setOficina(String oficina) {
        this.oficina = oficina;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Directorio{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", oficina='" + oficina + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
