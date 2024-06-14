package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.permisos;

/**
 *
 * @author almed
 */
public class DaoPermiso {
    Connection con;
    conexion cn=new conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean insertar(permisos pe){
        String sql="insert into permisos(nombreCompleto,tipo_permiso,descripcion,foto,ci,fecha_permiso) values(?,?,?,?,?,?)";

        try{
            con = cn.conectar();
            ps=con.prepareCall(sql);
            ps.setString(1, pe.getNombreCompleto());
            ps.setString(2, pe.getTipo_permiso());
            ps.setString(3, pe.getDescripcion());
            //ps.setBytes(4, pe.getFoto());
            ps.setInt   (5, pe.getCi());
            //ps.setDate  (6, pe.getFecha_permiso());

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
}
