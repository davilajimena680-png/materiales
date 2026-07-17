package utng.gtid.jdj.modelo;

public class Material {

    private int idMaterial;
    private String nombre;
    private String categoria;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private int cantidad;
    private String ubicacion;
    private String estado;

    // Constructor vacío
    public Material() {
    }

    // Constructor con parámetros
    public Material(int idMaterial, String nombre, String categoria, String marca,
                    String modelo, String numeroSerie, int cantidad,
                    String ubicacion, String estado) {

        this.idMaterial = idMaterial;
        this.nombre = nombre;
        this.categoria = categoria;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    // Getters y Setters

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}