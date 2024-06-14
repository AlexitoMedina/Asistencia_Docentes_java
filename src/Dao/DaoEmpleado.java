package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.empleado;

/**
 *
 * @author almed
 */

public class DaoEmpleado {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
//INSERTA DATOS     
    public boolean insertar(empleado em){
        String sql="insert into empleados(ci,nombre,apellido,telefono,correo,id_cargos,id_materia) values(?,?,?,?,?,?,?)";

        try{
            con = cn.conectar();
            ps=con.prepareCall(sql);
            ps.setInt   (1, em.getCi());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getApellido());
            ps.setInt   (4, em.getTelefono());
            ps.setString(5, em.getCorreo());
            ps.setInt   (6, em.getIdCargos());
            ps.setString(7, em.getIdMateria());
            
            int n=ps.executeUpdate();
            if(n!=0){
                return true;
            }else{
                return false;  
            }
            
        }catch(Exception er){
            JOptionPane.showConfirmDialog(null, er);
            return false;
        }
    }
    
    public DefaultTableModel listar(){
        DefaultTableModel modelo;
        
        String[] titulos = {"CI","Nombre","Apellido","Telefono","Correo","ID Cargo","Cargo","Sigla","Materia"};
        
        String[] registros = new String[9];
        modelo=new DefaultTableModel(null,titulos);
        
        String sql="select e.ci,e.nombre,e.apellido,e.telefono,e.correo,c.id_cargos,c.nom_cargo,m.id_materia,m.nombre "
                + "from empleados e "
                + "inner join materias m on m.id_materia = e.id_materia "
                + "inner join cargos c on c.id_cargos = e.id_cargos;";
        
        try{
            con = cn.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                registros[0]=rs.getString("ci");
                registros[1]=rs.getString("nombre");
                registros[2]=rs.getString("apellido");
                registros[3]=rs.getString("telefono");
                registros[4]=rs.getString("correo");
                registros[5]=rs.getString("id_cargos");
                registros[6]=rs.getString("nom_cargo");
                registros[7]=rs.getString("id_materia");
                registros[8]=rs.getString("m.nombre");
                modelo.addRow(registros);
            }
            return modelo;
        }catch(Exception er){
            JOptionPane.showConfirmDialog(null, er);
            return null;
        }
    }
  
    public boolean editar(empleado em, int auxCi){
            int auxCI = auxCi;
            em.mostrar();
            String sql = "UPDATE `empleados` SET `ci` = ?, `nombre` = ?, `apellido` = ?, `telefono` = ?, `correo` = ?, `id_cargos` = ?, `id_materia` = ?  WHERE `empleados`.`ci` = ?;";                  
            try{ 
            con = cn.conectar();
            ps=con.prepareCall(sql);
            ps.setInt   (1, em.getCi());
            ps.setString(2, em.getNombre());
            ps.setString(3, em.getApellido());
            ps.setInt   (4, em.getTelefono());
            ps.setString(5, em.getCorreo());
            ps.setInt   (6, em.getIdCargos());
            ps.setString(7, em.getIdMateria());
            ps.setInt   (8, auxCI);
                
            int n=ps.executeUpdate();
                System.out.println("\n"+n+"\n");
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
    
    public boolean Buscar(empleado em){
        String sql = "select *  from empleados where ci=?";
        try{
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, em.getCi());
            rs=ps.executeQuery();
            if(rs.next()){
                em.setCi(rs.getInt(1));
                em.setNombre(rs.getString(2));
                em.setApellido(rs.getString(3));
                em.setTelefono(rs.getInt(4));
                em.setCorreo(rs.getString(5));
                em.setIdCargos(rs.getInt(6));
                em.setIdMateria(rs.getString(7));
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        } 
    }    
    
    
    public boolean eliminar(empleado em){
            String sql = "DELETE FROM `empleados` WHERE `empleados`.`CI` = ?;";
            try{ 
            con = cn.conectar();
            ps=con.prepareCall(sql);
            ps.setInt(1, em.getCi());
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
}

