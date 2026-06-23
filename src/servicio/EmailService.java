/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

/**
 *
 * @author PC
 */
public class EmailService {
     public void enviarConfirmacion(
            String nombre,
            String email,
            double total) {

        System.out.println(
                "Enviando correo a "
                + email);

        System.out.println(
                "Asunto: Confirmacion Pedido");

        System.out.println(
                "Cuerpo: Estimado "
                + nombre
                + ", su pedido por $"
                + total
                + " fue procesado.");
    }

    public void enviarCancelacion(
            String nombre,
            String email,
            int idPedido) {

        System.out.println(
                "Enviando correo a "
                + email);

        System.out.println(
                "Asunto: Cancelacion");

        System.out.println(
                "Pedido #"
                + idPedido
                + " cancelado.");
    }
}
