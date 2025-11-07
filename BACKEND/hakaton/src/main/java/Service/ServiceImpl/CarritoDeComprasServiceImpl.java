package Service.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import Model.CarritoDeCompras;
import Model.Producto;
import Model.User;
import Repository.CarritoDeComprasRepository;

@Service
public class CarritoDeComprasServiceImpl {

    private final CarritoDeComprasRepository repository;

    @Autowired
    public CarritoDeComprasServiceImpl(CarritoDeComprasRepository repository) {
        this.repository = repository;
    }

    public CarritoDeCompras crearCarrito(User usuario) {
        if (usuario == null) return null;
        CarritoDeCompras carrito = repository.obtenerCarritoPorUsuario(usuario);
        if (carrito == null) {
            carrito = new CarritoDeCompras(usuario);
            repository.guardarCarrito(carrito);
        }
        return carrito;
    }

    public CarritoDeCompras obtenerCarrito(User usuario) {
        if (usuario == null) return null;
        return repository.obtenerCarritoPorUsuario(usuario);
    }

    public void agregarProducto(User usuario, Producto producto) {
        if (usuario == null || producto == null) return;
        CarritoDeCompras carrito = repository.obtenerCarritoPorUsuario(usuario);
        if (carrito == null) {
            carrito = new CarritoDeCompras(usuario);
        }
        carrito.agregarProducto(producto);
        repository.guardarCarrito(carrito);
    }

    public void removerProducto(User usuario, Producto producto) {
        if (usuario == null || producto == null) return;
        CarritoDeCompras carrito = repository.obtenerCarritoPorUsuario(usuario);
        if (carrito == null) return;
        carrito.removerProducto(producto);
        repository.guardarCarrito(carrito);
    }

    public void vaciarCarrito(User usuario) {
        if (usuario == null) return;
        CarritoDeCompras carrito = repository.obtenerCarritoPorUsuario(usuario);
        if (carrito == null) return;
        carrito.vaciarCarrito();
        repository.guardarCarrito(carrito);
    }

    public double obtenerTotal(User usuario) {
        if (usuario == null) return 0.0;
        CarritoDeCompras carrito = repository.obtenerCarritoPorUsuario(usuario);
        return (carrito == null) ? 0.0 : carrito.getTotal();
    }
}