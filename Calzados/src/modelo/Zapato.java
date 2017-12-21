package modelo;

/**
 *
 * @author Polett E.I.
 */
public class Zapato {
    
    private Integer codigo;
    private String nombre;
    private String descripcion;
    private String genero;
    private Integer precioVenta;
    private float numero;
    private String color;
    private String tipo;
    private String hayStock;
    private Integer cantidad;

    public Zapato() {
    }

    public Zapato(Integer codigo, String nombre, String descripcion, String genero, Integer precioVenta, float numero, String color, String tipo, String hayStock, Integer cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.genero = genero;
        this.precioVenta = precioVenta;
        this.numero = numero;
        this.color = color;
        this.tipo = tipo;
        this.hayStock = hayStock;
        this.cantidad = cantidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getNumero() {
        return numero;
    }

    public void setNumero(float numero) {
        this.numero = numero;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHayStock() {
        return hayStock;
    }

    public void setHayStock(String hayStock) {
        this.hayStock = hayStock;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
}
