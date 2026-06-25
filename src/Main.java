/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import gestor.GestorPedidos;
import java.util.Arrays;
import modelo.Pedido;
/**
 *
 * @author PC
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pedido pedido
                = new Pedido(
                        "Francisco",
                        "francisco@gmail.com",
                        Arrays.asList(
                                "Laptop",
                                "Mouse"),
                        Arrays.asList(
                                800.0,
                                25.0),
                        Arrays.asList(
                                1,
                                2),
                        "VIP");
  
        GestorPedidos gestor
                = new GestorPedidos();

        gestor.procesarPedido(pedido);
        gestor.cancelarPedido(
                "Juan",
                "Juan@gmail.com",
                1);
    }
}

