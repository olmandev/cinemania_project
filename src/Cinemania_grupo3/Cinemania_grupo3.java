/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cinemania_grupo3;

import Controlador.HorariosControlador;
import Controlador.InventarioControlador;
import Controlador.LoginControlador;
import Controlador.PeliculaControlador;
import Controlador.PrincipalControlador;
import Controlador.ProductoControlador;
import Controlador.ProveedorControlador;
import Controlador.SalaControlador;
import Controlador.VentaControlador;
import Vista.AsientosForm;
import Vista.Boletos;
import Vista.Horarios_CRUD;
import Vista.Informacion;
import Vista.Inventario_CRUD;
import Vista.Login;
import Vista.Peliculas_CRUD;
import Vista.Principal;
import Vista.Registro;
import modelo.ConsultaLogin;
import modelo.LoginPOO;
import Vista.Principal;
import Vista.Productos_CRUD;
import Vista.Proveedores_CRUD;
import Vista.Salas_CRUD;
import Vista.Tienda;
import Vista.Ventas_CRUD;

import modelo.ConsultaHorarios;
import modelo.ConsultaInventario;
import modelo.ConsultaPelicula;
import modelo.ConsultaProducto;
import modelo.ConsultaProveedor;
import modelo.ConsultaSalas;
import modelo.ConsultaVenta;
import modelo.HorariosPOO;
import modelo.InventarioPOO;
import modelo.ItemVentaPOO;
import modelo.PeliculaPOO;
import modelo.ProductoPOO;
import modelo.ProveedorPOO;
import modelo.SalasPOO;
import modelo.VentaPOO;

/**
 *
 * @author alexs
 */
public class Cinemania_grupo3 {

    private static String iniciarLogin() {
        ConsultaLogin conexion = new ConsultaLogin();
        LoginPOO user = new LoginPOO();
        Login form = new Login("", "");
        Registro formR = new Registro(form, true);
        Principal formprin = new Principal("ALX");

        new LoginControlador(form, user, conexion, formR, formprin);
        form.setVisible(true);

        while (form.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return (user.getUsuario().isEmpty() || user.getRol().isEmpty()) ? null : user.getUsuario() + "|" + user.getRol();
    }

    public static void main(String[] args) {
        String resultado = iniciarLogin();

        if (resultado != null) {
            String[] partes = resultado.split("\\|");
            String usuarioLogueado = partes[0];
            String rolUsuario = partes[1];

            inicializarPrincipal(usuarioLogueado, rolUsuario);
        } else {
            System.out.println("INICIO DE SESION FALLIDO :C");
        }

    }

    private static void inicializarPrincipal(String usuarioLogueado, String rolUsuario) {
        Principal prin = new Principal(usuarioLogueado);

        if (rolUsuario.equalsIgnoreCase("Administrador")) {
            prin.botPeliculas.setEnabled(true);
            prin.botSalas.setEnabled(true);
            prin.botProductos.setEnabled(true);
            prin.botProveedores.setEnabled(true);
            prin.botVentas.setEnabled(true);
            prin.botHorarios.setEnabled(true);
            prin.botInformacion.setEnabled(true);
            prin.botReportes.setEnabled(true);
            prin.botResgistrar.setEnabled(true);

        } else if (rolUsuario.equalsIgnoreCase("Cajero")) {
            prin.botPeliculas.setEnabled(false);
            prin.botSalas.setEnabled(false);
            prin.botProductos.setEnabled(false);
            prin.botProveedores.setEnabled(false);
            prin.botHorarios.setEnabled(false);
            prin.botInformacion.setEnabled(false);
            prin.botReportes.setEnabled(false);
            prin.botResgistrar.setEnabled(false);
            prin.botVentas.setEnabled(true);
            
        }

        PeliculaPOO peli = new PeliculaPOO();
        ProveedorPOO prove = new ProveedorPOO();
        ProductoPOO produ = new ProductoPOO();
        InventarioPOO inv = new InventarioPOO();
        SalasPOO sal = new SalasPOO();
        HorariosPOO hor = new HorariosPOO();
        VentaPOO vent = new VentaPOO();
        ItemVentaPOO item = new ItemVentaPOO();

        Peliculas_CRUD formpeli = new Peliculas_CRUD(prin, true, usuarioLogueado);
        Salas_CRUD formsala = new Salas_CRUD(prin, true, usuarioLogueado);
        Proveedores_CRUD formprove = new Proveedores_CRUD(prin, true, usuarioLogueado);
        Ventas_CRUD formventa = new Ventas_CRUD(prin, true, usuarioLogueado);
        Productos_CRUD formprodu = new Productos_CRUD(prin, true, usuarioLogueado);
        Inventario_CRUD forminv = new Inventario_CRUD(prin, true, usuarioLogueado);
        Horarios_CRUD formHor = new Horarios_CRUD(prin, true, usuarioLogueado);
        Boletos formB = new Boletos(prin, true);
        AsientosForm formA = new AsientosForm(prin, true);
        Tienda formT = new Tienda(prin, true);
        Informacion forminfo = new Informacion();
        Registro formR = new Registro(prin, true);
        ConsultaPelicula conPeli = new ConsultaPelicula();
        ConsultaProveedor conProve = new ConsultaProveedor();
        ConsultaProducto conProdu = new ConsultaProducto();
        ConsultaInventario conInv = new ConsultaInventario();
        ConsultaSalas conSal = new ConsultaSalas();
        ConsultaHorarios conHor = new ConsultaHorarios();
        ConsultaVenta conVent = new ConsultaVenta();
        

        PeliculaControlador peliCont = new PeliculaControlador(peli, formpeli, conPeli, prin);
        ProveedorControlador proveCont = new ProveedorControlador(prove, formprove, conProve, prin);
        ProductoControlador produCont = new ProductoControlador(produ, formprodu, conProdu, prin, forminv);
        InventarioControlador invCont = new InventarioControlador(inv, forminv, conInv, conProdu, produ, prin);
        SalaControlador salCont = new SalaControlador(sal, formsala, conSal, prin);
        HorariosControlador horCont = new HorariosControlador(hor, formHor, conHor, conPeli, prin);
        VentaControlador ventCont = new VentaControlador(formventa, prin, conVent, vent, formB, formA, formT, item);
       PrincipalControlador prinCont = new PrincipalControlador(prin, formpeli, formprove, formsala, formventa, formprodu,forminfo, formHor, formR);

        prinCont.Iniciar();

        prin.setVisible(true);
    }

}
