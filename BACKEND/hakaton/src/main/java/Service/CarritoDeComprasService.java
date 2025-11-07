package Service;
import Model.CarritoDeCompras;
import Model.Producto;
import Model.User;



public interface CarritoDeComprasService {

    CarritoDeCompras crearCarrito(User usuario);
    CarritoDeCompras obtenerCarrito(User usuario);
    void agregarProducto(User usuario, Producto producto);
    void removerProducto(User usuario, Producto producto);
    void vaciarCarrito(User usuario);
    double obtenerTotal(User usuario);
}
