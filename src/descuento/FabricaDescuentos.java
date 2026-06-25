/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descuento;

/**
 *
 * @author PC
 */
public class FabricaDescuentos {

    public DescuentoStrategy obtener(String tipoCliente) {

        return switch (tipoCliente.toUpperCase()) {
            case "VIP" -> new VipDescuento();
            case "FRECUENTE" -> new FrecuenteDescuento();
            case "REGULAR" -> new RegularDescuento();
            default -> new NuevoDescuento();
        };
    }
}
