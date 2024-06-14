/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.materias;

/**
 *
 * @author almed
 */
public class DaoMateria {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;

    public boolean editar(materias m){
        String sql = "update materias set id_materia=? , nombre= ? where materias.id_materia=?";
        //UPDATE materias SET id_materia = 'pop8888', `nombre` = 'pooooo888' WHERE `materias`.`id_materia` = 'pop8';
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getIdMateria());
            ps.setString(2, m.getNomMateria());
            ps.setString(3, m.getIdMateria());
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 
    }
    
    public boolean insertar(materias m){
        String sql = "insert into materias(id_materia,nombre) values (?,?)";
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getIdMateria());
            ps.setString(2, m.getNomMateria());
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public List Listar(){
        List<materias> lista = new ArrayList<>();
        String sql = "select * from materias";
        try{
           con = cn.conectar();
           ps = con.prepareStatement(sql);
           rs = ps.executeQuery();
           while(rs.next()){
               materias m=new materias();
               m.setIdMateria(rs.getString(1));
               m.setNomMateria(rs.getString(2));
               lista.add(m);
           }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
        return lista;
    }

        public boolean eliminar(materias m){
        String sql = "delete from materias where materias.id_materia=?";
        //DELETE FROM `materias` WHERE `materias`.`id_materia` = \'\'"
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1,m.getIdMateria());
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 
    }

    public boolean Buscar(materias m){
        String sql = "select *  from materias where id_materia=?";
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, m.getIdMateria());
            rs=ps.executeQuery();
            if(rs.next()){
                m.setIdMateria(rs.getString(1));
                m.setNomMateria(rs.getString(2));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
}
