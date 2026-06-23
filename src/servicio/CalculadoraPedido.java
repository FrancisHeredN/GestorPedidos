/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;
import descuento.DescuentoStrategy;
import descuento.FabricaDescuentos;
import modelo.Pedido;

/**
 *
 * @author PC
 */
public class CalculadoraPedido {
     private final FabricaDescuentos fabrica;

    public CalculadoraPedido() {
        fabrica = new FabricaDescuentos();
    }

    public double calcularSubtotal(Pedido pedido) {

        double subtotal = 0;

        for (int i = 0; i < pedido.getNombresProductos().size(); i++) {

            subtotal += pedido.getPreciosProductos().get(i)
                    * pedido.getCantidades().get(i);
        }

        return subtotal;
    }

    public double calcularDescuento(Pedido pedido) {

        double subtotal = calcularSubtotal(pedido);

        DescuentoStrategy estrategia =
                fabrica.obtener(pedido.getTipoCliente());

        return estrategia.calcular(subtotal);
    }

    public double calcularImpuesto(double subtotal,
                                   double descuento) {

        return (subtotal - descuento) * 0.12;
    }

    public double calcularTotal(Pedido pedido) {

        double subtotal = calcularSubtotal(pedido);

        double descuento =
                calcularDescuento(pedido);

        double impuesto =
                calcularImpuesto(subtotal,
                        descuento);

        return subtotal - descuento + impuesto;
    }
}
