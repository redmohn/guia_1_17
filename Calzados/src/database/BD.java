package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Zapato;

/**
 *
 * @author Polett E.I.
 */
public class BD {

    private Connection conectar() {
        Connection conexion = null;
        try {
            String driverClassName = "oracle.jdbc.driver.OracleDriver";
            String driverUrl = "jdbc:oracle:thin:@localhost:1521:XE";
            Class.forName(driverClassName);
            conexion = DriverManager.getConnection(driverUrl, "system", "system");
        } catch (Exception e) {
            conexion = null;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return conexion;
    }

    private void desconectar(Connection conexion) {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
    }

    public boolean agregar(Zapato zapato) {
        boolean ok = false;
        try {
            if (zapato != null) {
                Connection conexion = conectar();
                if (conexion != null) {

                    PreparedStatement ps = conexion.prepareStatement("INSERT INTO \"SYSTEM\".\"ZAPATO\" (CODIGO, NOMBRE, DESCRIPCION, GENERO, PRECIO_VENTA, NUMERO, COLOR, TIPO, HAY_STOCK, CANTIDAD) VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?', '?')");
                    ps.setInt(1, zapato.getCodigo());
                    ps.setString(2, zapato.getNombre());
                    ps.setString(3, zapato.getDescripcion());
                    ps.setString(4, zapato.getGenero());
                    ps.setInt(5, zapato.getPrecioVenta());
                    ps.setFloat(6, zapato.getNumero());
                    ps.setString(7, zapato.getColor());
                    ps.setString(8, zapato.getTipo());
                    ps.setString(9, zapato.getHayStock());
                    ps.setInt(10, zapato.getCantidad());
                    ps.execute();
                    ok = true;
                }
                desconectar(conexion);
            }
        } catch (Exception e) {
            ok = false;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return ok;
    }

    public boolean eliminar(Zapato zapato) {
        boolean ok = false;
        try {
            if (zapato != null) {
                Connection conexion = conectar();
                if (conexion != null) {
                    PreparedStatement ps = conexion.prepareStatement("DELETE FROM \"SYSTEM\".\"ZAPATO\"  WHERE CODIGO=?");
                    ps.setInt(1, zapato.getCodigo());
                    ps.execute();
                    ok = true;
                }
                desconectar(conexion);
            }
        } catch (Exception e) {
            ok = false;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return ok;
    }

    public Zapato buscarUno(Integer codigo){
        Zapato zapato = null;
        
        try {
            if (codigo != null){
                Connection conexion = conectar();
                if (conexion != null){
                    PreparedStatement ps = conexion.prepareStatement("SELECT * FROM libros WHERE CODIGO=?");
                    ps.setInt(1, zapato.getCodigo());
                    ResultSet rs = ps.executeQuery();
                    if (rs != null){
                        zapato = new Zapato();
                        zapato.setCodigo(rs.getInt("CODIGO"));
                        zapato.setNombre(rs.getString("NOMBRE"));
                        zapato.setDescripcion(rs.getString("DESCRIPCION"));
                        zapato.setGenero(rs.getString("GENERO"));
                        zapato.setPrecioVenta(rs.getInt("PRECIO_VENTA"));
                        zapato.setNumero(rs.getFloat("NUMERO"));
                        zapato.setColor(rs.getString("COLOR"));
                        zapato.setTipo(rs.getString("TIPO"));
                        zapato.setHayStock(rs.getString("HAY_STOCK"));
                        zapato.setCantidad(rs.getInt("CANTIDAD"));
                    }
                    rs.close();
                }
                desconectar (conexion);
            }            
        } catch (Exception e) {
            zapato = null;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }        
        return zapato;
    }
    
    public boolean modificar(Zapato zapato){
        boolean ok = false;
        try {
            if (zapato != null) {
                Connection conexion = conectar();
                if (conexion != null) {

                    PreparedStatement ps = conexion.prepareStatement("UPDATE INTO \"SYSTEM\".\"ZAPATO\" SET (NOMBRE=?, DESCRIPCION=?, GENERO=?, PRECIO_VENTA=?, NUMERO=?, COLOR=?, TIPO=?, HAY_STOCK=?, CANTIDAD=?) WHERE (CODIGO=?)");
                    ps.setString(1, zapato.getNombre());
                    ps.setString(2, zapato.getDescripcion());
                    ps.setString(3, zapato.getGenero());
                    ps.setInt(4, zapato.getPrecioVenta());
                    ps.setFloat(5, zapato.getNumero());
                    ps.setString(6, zapato.getColor());
                    ps.setString(7, zapato.getTipo());
                    ps.setString(8, zapato.getHayStock());
                    ps.setInt(9, zapato.getCantidad());
                    ps.setInt(10, zapato.getCodigo());
                    ps.execute();
                    ok = true;
                }
                desconectar(conexion);
            }
        } catch (Exception e) {
            ok = false;
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        } 
        return ok;
    }
    
    public List<Zapato> listadoZapatos(){
        List<Zapato> listaZapatos = new ArrayList<>();
        try {
            Connection conexion = conectar();
            if (conexion != null){
                PreparedStatement ps = conexion.prepareStatement("SELECT * FROM libros WHERE CODIGO=?");
                ResultSet rs = ps.executeQuery();
                    if (rs != null){
                        while(rs.next()){
                        Zapato zapato = new Zapato();
                        zapato.setCodigo(rs.getInt("CODIGO"));
                        zapato.setNombre(rs.getString("NOMBRE"));
                        zapato.setDescripcion(rs.getString("DESCRIPCION"));
                        zapato.setGenero(rs.getString("GENERO"));
                        zapato.setPrecioVenta(rs.getInt("PRECIO_VENTA"));
                        zapato.setNumero(rs.getFloat("NUMERO"));
                        zapato.setColor(rs.getString("COLOR"));
                        zapato.setTipo(rs.getString("TIPO"));
                        zapato.setHayStock(rs.getString("HAY_STOCK"));
                        zapato.setCantidad(rs.getInt("CANTIDAD"));
                        
                        listaZapatos.add(zapato);
                        }
                        rs.close();
                    }
             desconectar(conexion);
            }            
        } catch (Exception e) {
            System.err.println(String.format("Ha ocurrido error: %s", e.toString()));
        }
        return listaZapatos;
    }    
}
