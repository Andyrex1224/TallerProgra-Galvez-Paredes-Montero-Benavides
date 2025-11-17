import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Tienda {

    private HashSet<Integer> idsUsados = new HashSet<>();
    private Random random = new Random();

    private List<Producto> productos = new ArrayList<>();


    private double precioLapActual = 1395.90;
    private double precioPcActual = 1110.50;
    private double precioCelActual = 863.84;

    public double getPrecioLapActual() {
        return precioLapActual;
    }

    public double getPrecioPcActual() {
        return precioPcActual;
    }

    public double getPrecioCelActual() {
        return precioCelActual;
    }

    public void actualizarMeses() {
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            p.setMes(p.getMes() + 1);
        }
        for (int i = 0; i < productos.size(); i++) {
            Producto p = productos.get(i);

            if (p.getMes() >= 4) {
                productos.remove(i);
                i--;
            }
        }

    }


    public void inflacion(Producto producto){

        String tipo = producto.getNombreProducto();

        switch (tipo) {
            case "Laptop":
                precioLapActual *= 1.10;
                break;
            case "PC":
                precioPcActual *= 1.10;
                break;
            case "Celular":
                precioCelActual *= 1.10;
                break;
        }
    }

    public int generarID() {
        int id;

        do {
            id = random.nextInt(9000) + 1000; // genera entre 1000 y 9999
        } while (idsUsados.contains(id));

        idsUsados.add(id);
        return id;
    }

    public void anadirPro(Producto p, int mes) {
        p.setMes(mes);
        productos.add(p);
    }


    public List<Producto> buscarNombre(Producto temp) {
        List<Producto> encontrados = new ArrayList<>();

        for (Producto p : productos) {
            if (p.getNombreProducto().equalsIgnoreCase(temp.getNombreProducto())) {
                encontrados.add(p);
            }
        }

        return encontrados;
    }


    public String busquedaBinaria(int id) {
        if (productos.isEmpty()) {
            return "No hay productos registrados.";
        }


        int inicio = 0;
        int fin = productos.size() - 1;

        while (inicio <= fin) {
            int mid = (inicio + fin) / 2;

            if (productos.get(mid).getIdProducto() == id) {
                Producto p = productos.get(mid);
                return "Encontrado:\nID: " + p.getIdProducto() +
                        " | Nombre: " + p.getNombreProducto() +
                        " | Precio: $" + p.getPrecioActual() +
                        " | Mes: " + p.getMes();
            }

            if (productos.get(mid).getIdProducto() < id) {
                inicio = mid + 1;
            } else {
                fin = mid - 1;
            }
        }

        return "Producto con ID " + id + " no encontrado.";
    }

    public void ordenatPorBurbuja() {
        int n = productos.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (productos.get(j).getIdProducto() > productos.get(j + 1).getIdProducto()) {
                    // Intercambiar objetos
                    Producto temp = productos.get(j);
                    productos.set(j, productos.get(j + 1));
                    productos.set(j + 1, temp);
                }
            }
        }
    }
}