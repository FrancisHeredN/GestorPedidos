/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class PedidoRepository {

    private Connection conexion;

   public PedidoRepository() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gestorpedidos",
                    "root",
                    ""
            );
            System.out.println("Conexión exitosa");

        } catch (Exception e) {
            System.out.println("ERROR CONEXIÓN: " + e.getMessage());
            conexion = null;
        }
    }

    public void guardarPedido(String cliente, double total) {

        if (conexion == null) {
            System.out.println("No hay conexión a la base de datos");
            return;
        }

        try {
            String sql =
                    "INSERT INTO pedidos(cliente,total) VALUES (?,?)";

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, cliente);
            ps.setDouble(2, total);

            ps.executeUpdate();

            System.out.println("Pedido guardado");

        } catch (SQLException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void cancelarPedido(int idPedido) {

        if (conexion == null) {
            System.out.println("No hay conexión a la base de datos");
            return;
        }

        try {
            String sql =
                    "DELETE FROM pedidos WHERE id=?";

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, idPedido);

            ps.executeUpdate();

            System.out.println("Pedido cancelado");

        } catch (SQLException e) {
            System.out.println("Error al cancelar: " + e.getMessage());
        }
    }
    
}
