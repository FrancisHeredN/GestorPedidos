/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestor;
import modelo.Pedido;
import repositorio.PedidoRepository;
import servicio.CalculadoraPedido;
import servicio.EmailService;
import servicio.FacturaService;
import servicio.LogService;
import validacion.ValidadorCliente;
/**
 *
 * @author PC
 */
public class GestorPedidos {
    private ValidadorCliente validador;
    private CalculadoraPedido calculadora;
    private PedidoRepository repository;
    private FacturaService facturaService;
    private EmailService emailService;
    private LogService logService;

    public GestorPedidos() {

        validador = new ValidadorCliente();
        calculadora = new CalculadoraPedido();
        repository = new PedidoRepository();
        facturaService = new FacturaService();
        emailService = new EmailService();
        logService = new LogService();
    }

    public void procesarPedido(Pedido pedido) {

        if (!validador.validar(
                pedido.getNombreCliente(),
                pedido.getEmailCliente())) {

            return;
        }

        double subtotal =
                calculadora.calcularSubtotal(pedido);

        double descuento =
                calculadora.calcularDescuento(pedido);

        double impuesto =
                calculadora.calcularImpuesto(
                        subtotal,
                        descuento);

        double total =
                calculadora.calcularTotal(pedido);

        repository.guardarPedido(
                pedido.getNombreCliente(),
                total);

        facturaService.generarFactura(
                pedido,
                subtotal,
                descuento,
                impuesto,
                total);

        emailService.enviarConfirmacion(
                pedido.getNombreCliente(),
                pedido.getEmailCliente(),
                total);

        logService.registrar(
                "Pedido procesado para "
                + pedido.getNombreCliente()
                + " Total: "
                + total);
    }

    public void cancelarPedido(
            String nombre,
            String email,
            int idPedido) {

        if (!validador.validar(nombre, email)) {
            return;
        }

        repository.cancelarPedido(idPedido);

        emailService.enviarCancelacion(
                nombre,
                email,
                idPedido);

        logService.registrar(
                "Pedido cancelado: "
                + idPedido);
    }
}
