package com.example.hakaton.Model;

import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompras {
    private User usuario;
    private List<Producto> productos;
    private double total;

    public CarritoDeCompras(User usuario) {
        this.usuario = usuario;
        this.productos = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        total += producto.getPrecio();
    }

    public void removerProducto(Producto producto) {
        productos.remove(producto);
        total -= producto.getPrecio();
    }

    public void vaciarCarrito() {
        productos.clear();
        total = 0.0;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public User getUsuario() {
        return usuario;
    }

    public boolean pagar(MetodoPago metodoPago) {
        if (productos.isEmpty()) return false;

        switch (metodoPago) {
            case PSE:
                System.out.println("Procesando pago por PSE...");
                break;
            case TARJETA:
                System.out.println("Procesando pago con tarjeta...");
                break;
            case PAYPAL:
                System.out.println("Procesando pago con PayPal...");
                break;
            default:
                return false;
        }

        vaciarCarrito();
        System.out.println("Pago realizado exitosamente.");
        return true;
    }
}
