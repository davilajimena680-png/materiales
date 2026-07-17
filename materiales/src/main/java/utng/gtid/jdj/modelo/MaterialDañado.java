package utng.gtid.jdj.modelo;

import java.time.LocalDate;


public class MaterialDañado {


    private int idMaterialDanado;

    private int idMaterial;

    private LocalDate fechaReporte;

    private String tipoDanio;

    private String descripcion;

    private String estado;

    private String observaciones;



    // Constructor vacío

    public MaterialDañado() {

    }



    // Constructor completo

    public MaterialDañado(int idMaterialDanado,
                          int idMaterial,
                          LocalDate fechaReporte,
                          String tipoDanio,
                          String descripcion,
                          String estado,
                          String observaciones) {


        this.idMaterialDanado = idMaterialDanado;
        this.idMaterial = idMaterial;
        this.fechaReporte = fechaReporte;
        this.tipoDanio = tipoDanio;
        this.descripcion = descripcion;
        this.estado = estado;
        this.observaciones = observaciones;

    }




    public int getIdMaterialDanado() {
        return idMaterialDanado;
    }


    public void setIdMaterialDanado(int idMaterialDanado) {
        this.idMaterialDanado = idMaterialDanado;
    }




    public int getIdMaterial() {
        return idMaterial;
    }


    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }




    public LocalDate getFechaReporte() {
        return fechaReporte;
    }


    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }




    public String getTipoDanio() {
        return tipoDanio;
    }


    public void setTipoDanio(String tipoDanio) {
        this.tipoDanio = tipoDanio;
    }




    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }




    public String getObservaciones() {
        return observaciones;
    }


    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }



}
