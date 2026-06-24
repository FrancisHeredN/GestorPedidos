/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validacion;

/**
 *
 * @author PC
 */
public class ValidadorCliente {

    public boolean validar(String nombre, String email) {

        if (nombre == null || nombre.trim().isEmpty()) {
            System.out.println("Error: nombre invalido");
            return false;
        }

        if (email == null || !email.contains("@")) {
            System.out.println("Error: email invalido");
            return false;
        }

        return true;
    }
}
