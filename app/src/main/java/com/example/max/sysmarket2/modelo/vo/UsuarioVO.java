package com.example.max.sysmarket2.modelo.vo;

import com.example.max.sysmarket2.modelo.conexion.ConexionBD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioVO {


    String nomUser;
    int idPerfil;
    String nombre;
    String apellido;
    String rut;
    String fecha_Nac;
    String email;
    String contrasena;
    int estado;

    public UsuarioVO(String nomUser, int idPerfil, String nombre, String apellido, String rut, String fecha_Nac, String email, String contrasena) {
        this.nomUser = nomUser;
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.fecha_Nac = fecha_Nac;
        this.email = email;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public UsuarioVO() {

    }


    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getFecha_Nac() {
        return fecha_Nac;
    }

    public void setFecha_Nac(String fecha_Nac) {
        this.fecha_Nac = fecha_Nac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContraseña(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<UsuarioVO> obtenerUsuario() {
        List<UsuarioVO> usuario = new ArrayList<>();
        ConexionBD conn = new ConexionBD();
        try {
            Statement state = conn.conexion().createStatement();
            ResultSet result = state.executeQuery("select * from Usuario");
            while (result.next()) {
                usuario.add(new UsuarioVO(result.getString("Usuario"), result.getInt("IdPerfil"), result.getString("Nombre"),
                        result.getString("Apellido"), result.getString("Rut"), result.getString("Fecha_Nac"), result.getString("Email"),
                        result.getString("Clave")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;


    }
}

