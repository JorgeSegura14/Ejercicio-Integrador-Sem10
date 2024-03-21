package quiz.semana.pkg10;
import javax.swing.JOptionPane;
enum TipoProducto {
    ALIMENTOS,
    BEBIDAS,
    HIGIENE,
    LIMPIEZA
}
class Producto {
    String codigo;
    String nombre;
    String nombreEmpleado;
    String cedulaEmpleado;
    int cantidad;
    double precioBase;
    TipoProducto tipo;
    double precioBruto;
    double ganancia;

    public Producto(String codigo, String nombre, String nombreEmpleado, String cedulaEmpleado, int cantidad,
                    double precioBase, TipoProducto tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nombreEmpleado = nombreEmpleado;
        this.cedulaEmpleado = cedulaEmpleado;
        this.cantidad = cantidad;
        this.precioBase = precioBase;
        this.tipo = tipo;
        calcularPrecioBruto();
        calcularGanancia();
    }

    private void calcularPrecioBruto() {
        switch (tipo) {
            case ALIMENTOS:
                precioBruto = precioBase * 0.20 + precioBase;
                break;
            case BEBIDAS:
                precioBruto = precioBase * 0.30 + precioBase;
                break;
            case HIGIENE:
                precioBruto = precioBase * 0.25 + precioBase + 500;
                break;
            case LIMPIEZA:
                precioBruto = precioBase * 0.19 + precioBase * 0.04 + 1000 + precioBase;
                break;
        }
    }

    private void calcularGanancia() {
        ganancia = (precioBruto - precioBase) * cantidad;
    }
}

class Inventario {
    Producto[] productos;
    int cantidadProductos;


    public Inventario(int capacidad) {
        productos = new Producto[capacidad];
        cantidadProductos = 0;
    }

    public void agregarProducto(Producto producto) {
        if (cantidadProductos < productos.length) {
            productos[cantidadProductos++] = producto;
        } else {
            JOptionPane.showMessageDialog(null, "El inventario está lleno, no se puede agregar más productos.");
        }
    }

  
    public void mostrarProductos() {
        StringBuilder mensaje = new StringBuilder("Productos agregados:\n");
        for (int i = 0; i < cantidadProductos; i++) {
            mensaje.append(productos[i].nombre).append(" - Ganancia: $").append(productos[i].ganancia).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString());
    }

 
    public double calcularGananciaTotal() {
        double gananciaTotal = 0;
        for (int i = 0; i < cantidadProductos; i++) {
            gananciaTotal += productos[i].ganancia;
        }
        return gananciaTotal;
    }
}



public class QuizSemana102 {
    
}
