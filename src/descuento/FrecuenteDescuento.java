/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package descuento;

/**
 *
 * @author PC
 */
public class FrecuenteDescuento implements DescuentoStrategy {

 
    public double calcular(double subtotal) {
        return subtotal * 0.10;
    }
}
