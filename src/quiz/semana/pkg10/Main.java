package quiz.semana.pkg10;

import javax.swing.JOptionPane;

        public class Main {
        public static void main(String[] args) {
            String nombreSupermercado = JOptionPane.showInputDialog("Ingrese el nombre del supermercado:");
            String codigoSupermercado = JOptionPane.showInputDialog("Ingrese el código del supermercado:");
            String nombreEmpleado = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
            String cedulaEmpleado = JOptionPane.showInputDialog("Ingrese la cédula del empleado:");

            Inventario inventario = new Inventario(100);

            while (true) {
                String codigoProducto = JOptionPane.showInputDialog("Ingrese el código del producto (o 'fin' para terminar):");
                if (codigoProducto.equals("fin")) {
                    break;
                }
                String nombreProducto = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
                int cantidadProducto = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de productos a ingresar:"));
                double precioBaseProducto = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio base del producto:"));
                String tipoString = JOptionPane.showInputDialog("Ingrese el tipo de producto (Alimentos, Bebidas, Higiene, Limpieza):");
                TipoProducto tipoProducto = TipoProducto.valueOf(tipoString.toUpperCase());

                Producto producto = new Producto(codigoProducto, nombreProducto, nombreEmpleado, cedulaEmpleado,
                        cantidadProducto, precioBaseProducto, tipoProducto);
                inventario.agregarProducto(producto);
            }

            inventario.mostrarProductos();
            JOptionPane.showMessageDialog(null, "Ganancia total esperada: $" + inventario.calcularGananciaTotal());
        }
    }


    

