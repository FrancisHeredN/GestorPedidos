/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.util.List;

/**
 *
 * @author PC
 */
public class Pedido {
    private String nombreCliente;
    private String emailCliente;
    private List<String> nombresProductos;
    private List<Double> preciosProductos;
    private List<Integer> cantidades;
    private String tipoCliente;

    public Pedido(
            String nombreCliente,
            String emailCliente,
            List<String> nombresProductos,
            List<Double> preciosProductos,
            List<Integer> cantidades,
            String tipoCliente) {

        this.nombreCliente = nombreCliente;
        this.emailCliente = emailCliente;
        this.nombresProductos = nombresProductos;
        this.preciosProductos = preciosProductos;
        this.cantidades = cantidades;
        this.tipoCliente = tipoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public List<String> getNombresProductos() {
        return nombresProductos;
    }

    public List<Double> getPreciosProductos() {
        return preciosProductos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }
}
