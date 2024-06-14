/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author almed
 */
public class permisos {
    int id_permiso;
    String nombreCompleto;
    String tipo_permiso;
    String descripcion;
    Byte foto;
    int ci;
    Date fecha_permiso;

    public permisos() {
    }

    public permisos(int id_permiso, String nombreCompleto, String tipo_permiso, String descripcion, Byte foto, int ci, Date fecha_permiso) {
        this.id_permiso = id_permiso;
        this.nombreCompleto = nombreCompleto;
        this.tipo_permiso = tipo_permiso;
        this.descripcion = descripcion;
        this.foto = foto;
        this.ci = ci;
        this.fecha_permiso = fecha_permiso;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipo_permiso() {
        return tipo_permiso;
    }

    public void setTipo_permiso(String tipo_permiso) {
        this.tipo_permiso = tipo_permiso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Byte getFoto() {
        return foto;
    }

    public void setFoto(Byte foto) {
        this.foto = foto;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public Date getFecha_permiso() {
        return fecha_permiso;
    }

    public void setFecha_permiso(Date fecha_permiso) {
        this.fecha_permiso = fecha_permiso;
    }
    
}
