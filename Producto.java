public class Producto {
    private int idProducto;
    private String nombreProducto;
    private double precioActual;
    private int mes;



    public Producto() {}

    public Producto(int idProducto, String nombreProducto , double precioActual) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioActual = precioActual;
    }

    public int getIdProducto() {
        return idProducto;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(double precioActual) {
        this.precioActual = precioActual;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}