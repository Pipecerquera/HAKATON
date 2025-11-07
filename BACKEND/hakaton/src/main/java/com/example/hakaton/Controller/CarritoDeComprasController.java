package com.example.hakaton.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hakaton.Model.CarritoDeCompras;
import com.example.hakaton.Model.MetodoPago;
import com.example.hakaton.Model.Producto;
import com.example.hakaton.Model.User;
import com.example.hakaton.Service.ServiceImpl.CarritoDeComprasServiceImpl;

@RestController
@RequestMapping("/api/carrito")
public class CarritoDeComprasController {

    private final CarritoDeComprasServiceImpl service;

    @Autowired
    public CarritoDeComprasController(CarritoDeComprasServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/crear")
    public ResponseEntity<CarritoDeCompras> crearCarrito(@RequestBody User usuario) {
        if (usuario == null) return ResponseEntity.badRequest().build();
        CarritoDeCompras carrito = service.crearCarrito(usuario);
        if (carrito == null) return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(carrito);
    }

    @PostMapping("/obtener")
    public ResponseEntity<CarritoDeCompras> obtenerCarrito(@RequestBody User usuario) {
        if (usuario == null) return ResponseEntity.badRequest().build();
        CarritoDeCompras carrito = service.obtenerCarrito(usuario);
        if (carrito == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(carrito);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Void> agregarProducto(@RequestBody AgregarRemoverRequest req) {
        if (req == null || req.usuario == null || req.producto == null) return ResponseEntity.badRequest().build();
        service.agregarProducto(req.usuario, req.producto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/remover")
    public ResponseEntity<Void> removerProducto(@RequestBody AgregarRemoverRequest req) {
        if (req == null || req.usuario == null || req.producto == null) return ResponseEntity.badRequest().build();
        service.removerProducto(req.usuario, req.producto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/vaciar")
    public ResponseEntity<Void> vaciarCarrito(@RequestBody User usuario) {
        if (usuario == null) return ResponseEntity.badRequest().build();
        service.vaciarCarrito(usuario);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/total")
    public ResponseEntity<Double> obtenerTotal(@RequestBody User usuario) {
        if (usuario == null) return ResponseEntity.badRequest().build();
        double total = service.obtenerTotal(usuario);
        return ResponseEntity.ok(total);
    }
    
    @PostMapping("/pagar")
    public ResponseEntity<String> pagarCarrito(@RequestBody PagoRequest request) {
        if (request == null || request.usuario == null || request.metodoPago == null)
            return ResponseEntity.badRequest().build();

        boolean exito = service.pagarCarrito(request.usuario, request.metodoPago);

        if (exito)
            return ResponseEntity.ok("Pago realizado exitosamente.");
        else
            return ResponseEntity.status(500).body("Error al procesar el pago o carrito vacío.");
    }

    public static class AgregarRemoverRequest {
        public User usuario;
        public Producto producto;

        public AgregarRemoverRequest() {}
        public AgregarRemoverRequest(User usuario, Producto producto) {
            this.usuario = usuario;
            this.producto = producto;
        }
    }

    public static class PagoRequest {
        public User usuario;
        public MetodoPago metodoPago;

        public PagoRequest() {}
        public PagoRequest(User usuario, MetodoPago metodoPago) {
            this.usuario = usuario;
            this.metodoPago = metodoPago;
        }
    }
}
