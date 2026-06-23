/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Pedido;

/**
 *
 * @author PC
 */
public class FacturaService {
    
    public void generarFactura(
            Pedido pedido,
            double subtotal,
            double descuento,
            double impuesto,
            double total) {

        try {

            FileWriter writer =
                    new FileWriter(
                    "factura_"
                    + pedido.getNombreCliente()
                    + ".txt");

            writer.write("FACTURA\n");
            writer.write("Cliente: "
                    + pedido.getNombreCliente()
                    + "\n");

            for (int i = 0;
                 i < pedido.getNombresProductos().size();
                 i++) {

                writer.write(
                        pedido.getNombresProductos().get(i)
                        + " x"
                        + pedido.getCantidades().get(i)
                        + " = $"
                        + (pedido.getPreciosProductos().get(i)
                        * pedido.getCantidades().get(i))
                        + "\n");
            }

            writer.write(
                    "Subtotal: $"
                    + subtotal + "\n");

            writer.write(
                    "Descuento: $"
                    + descuento + "\n");

            writer.write(
                    "Impuesto: $"
                    + impuesto + "\n");

            writer.write(
                    "TOTAL: $"
                    + total + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error factura: "
                    + e.getMessage());
        }
    }
}
