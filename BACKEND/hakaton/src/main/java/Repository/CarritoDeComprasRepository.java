package Repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import Model.CarritoDeCompras;
import Model.User;

@Repository
public class CarritoDeComprasRepository {

    private Map<String, CarritoDeCompras> carritos = new HashMap<>();

    public CarritoDeCompras obtenerCarritoPorUsuario(User usuario) {
        return carritos.get(usuario.getNombre());
    }

    public void guardarCarrito(CarritoDeCompras carrito) {
        carritos.put(carrito.getUsuario().getNombre(), carrito);
    }

    public void eliminarCarrito(User usuario) {
        carritos.remove(usuario.getNombre());
    }
}
