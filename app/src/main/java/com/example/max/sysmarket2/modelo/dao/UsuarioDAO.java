package com.example.max.sysmarket2.modelo.dao;

import com.example.max.sysmarket2.modelo.conexion.ConexionBD;
import com.example.max.sysmarket2.modelo.vo.UsuarioVO;
import com.example.max.sysmarket2.vista.RegistroActivity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {


    public void registrarUsuario(UsuarioVO user) {
        ConexionBD conn = new ConexionBD();
        PreparedStatement state;

        try {
            state = conn.conexion().prepareStatement("INSERT INTO Usuario VALUES (?,?,?,?,?,?,?,1)");
            state.setString(1, user.getNomUser());
            state.setString(2, user.getNombre());
            state.setString(3, user.getApellido());
            state.setString(4, user.getRut());
            state.setString(5, user.getFecha_Nac());
            state.setString(6, user.getEmail());
            state.setString(7, user.getContrasena());
            state.executeUpdate();
            state.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

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



