package com.example.hakaton.Service;
import com.example.hakaton.Model.CarritoDeCompras;
import com.example.hakaton.Model.Producto;
import com.example.hakaton.Model.User;



public interface CarritoDeComprasService {

    CarritoDeCompras crearCarrito(User usuario);
    CarritoDeCompras obtenerCarrito(User usuario);
    void agregarProducto(User usuario, Producto producto);
    void removerProducto(User usuario, Producto producto);
    void vaciarCarrito(User usuario);
    double obtenerTotal(User usuario);
}
