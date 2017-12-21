package controlador;

import database.BD;
import modelo.Zapato;

/**
 *
 * @author Polett E.I.
 */
public class RegistroCalzados {
    
    public boolean agregar(Integer codigo, String nombre, String descripcion, String genero, Integer precioVenta, float numero, String color, String tipo, String hayStock, Integer cantidad){
        Zapato zapato = new Zapato();
        
        zapato.setCodigo(codigo);
        zapato.setNombre(nombre);
        zapato.setDescripcion(descripcion);
        zapato.setGenero(genero);
        zapato.setPrecioVenta(precioVenta);
        zapato.setNumero(numero);
        zapato.setColor(color);
        zapato.setTipo(tipo);
        zapato.setHayStock(hayStock);
        zapato.setCantidad(cantidad);
        
        
        BD bd = new BD();
        boolean ok = bd.agregar(zapato);
        return ok;
    }
    
    
}
