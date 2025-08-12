/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Reportes.Reporte;
import Vista.Horarios_CRUD;
import Vista.Informacion;
import Vista.Peliculas_CRUD;
import Vista.Principal;
import Vista.Productos_CRUD;
import Vista.Proveedores_CRUD;
import Vista.Registro;
import Vista.Salas_CRUD;
import Vista.Ventas_CRUD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author alexs
 */
public class PrincipalControlador implements ActionListener {

    private Principal prin;
    private Peliculas_CRUD formpeli;
    private Proveedores_CRUD formprove;
    private Salas_CRUD formsala;
    private Ventas_CRUD formventa;
    private Horarios_CRUD formHor;
    private Productos_CRUD formprodu;
    private Informacion forminfo;
    private Registro formR;
    
    public PrincipalControlador(Principal prin, Peliculas_CRUD formpeli, Proveedores_CRUD formprove, Salas_CRUD formsala, Ventas_CRUD formventa, Productos_CRUD formprodu, Horarios_CRUD formHor, Informacion forminfo, Registro formR) {
        this.prin = prin;
        this.formpeli = formpeli;
        this.formR = formR;
        this.formprove = formprove;
        this.formsala = formsala;
        this.formventa = formventa;
        this.formprodu = formprodu;
        this.forminfo = forminfo;
        this.formHor = formHor;
        
        this.prin.botPeliculas.addActionListener(this);
        this.prin.botProductos.addActionListener(this);
        this.prin.botInformacion.addActionListener(this);
        this.prin.botSalas.addActionListener(this);
        this.prin.botsalir.addActionListener(this);
        this.prin.botResgistrar.addActionListener(this);
        this.prin.botProveedores.addActionListener(this);
        this.prin.botHorarios.addActionListener(this);
        this.prin.botVentas.addActionListener(this);
    }

    public void Iniciar() {

        prin.setLocationRelativeTo(null);
        formpeli.setLocationRelativeTo(null);
        formsala.setLocationRelativeTo(null);
        formprove.setLocationRelativeTo(null);
        formprodu.setLocationRelativeTo(null);
        forminfo.setLocationRelativeTo(null);
        formHor.setLocationRelativeTo(null);
        formR.setLocationRelativeTo(null);
        formventa.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == prin.botProductos) {
            prin.setVisible(false);
            formprodu.setVisible(true);
        }
        if (e.getSource() == prin.botPeliculas) {
            prin.setVisible(false);
            formpeli.setVisible(true);
        }
        if (e.getSource() == prin.botSalas) {
            prin.setVisible(false);
            formsala.setVisible(true);
        }
        if (e.getSource() == prin.botInformacion) {
            prin.setVisible(true);
            forminfo.setVisible(true);
        }
        if (e.getSource() == prin.botProveedores) {
            prin.setVisible(false);
            formprove.setVisible(true);
        }
        if (e.getSource() == prin.botHorarios) {
            prin.setVisible(false);
            formHor.setVisible(true);
        }
        
        if (e.getSource() == prin.botVentas) {
            prin.setVisible(false);
            formventa.setVisible(true);
        }
        if(e.getSource() == prin.botResgistrar){
            prin.setVisible(true);
            formR.setVisible(true);
        }
         
        if (e.getSource() == prin.botsalir) {
            System.exit(0);
        }
    }
}
