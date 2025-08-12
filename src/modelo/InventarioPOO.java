/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alexs
 */
public class InventarioPOO {
    
    private int codigo;
    private String descripcioninv;
    private int cantidadinv;
    private String estado;
    private String proveedor;
    private int stockMin;
    private int stockMax;
    private String tipoMove;
    private String motivo;
    private String fecha;
    private String vencimiento;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcioninv() {
        return descripcioninv;
    }

    public void setDescripcioninv(String descripcioninv) {
        this.descripcioninv = descripcioninv;
    }

    public int getCantidadinv() {
        return cantidadinv;
    }

    public void setCantidadinv(int cantidadinv) {
        this.cantidadinv = cantidadinv;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public int getStockMin() {
        return stockMin;
    }

    public void setStockMin(int stockMin) {
        this.stockMin = stockMin;
    }

    public int getStockMax() {
        return stockMax;
    }

    public void setStockMax(int stockMax) {
        this.stockMax = stockMax;
    }

    public String getTipoMove() {
        return tipoMove;
    }

    public void setTipoMove(String tipoMove) {
        this.tipoMove = tipoMove;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
    
    
    
}
