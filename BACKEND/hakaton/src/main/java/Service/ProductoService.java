package Service;

import java.util.List;
import java.util.Optional;

import Model.Producto;

public interface ProductoService {
    Producto createProducto(Producto producto);
    List<Producto> getAllProductos();
    Optional<Producto> getProductoById(Long id);
    Producto updateProducto(Long id, Producto producto);
    boolean eliminarProducto(Long id);
    List<Producto> findByCategoria(String categoria);
    List<Producto> searchByNombre(String nombre);
}
