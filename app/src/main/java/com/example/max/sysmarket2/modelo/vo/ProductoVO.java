package com.example.max.sysmarket2.modelo.vo;

public class ProductoVO {

    int cod_barra;
    int id_Local;
    int id_Usuario;
    int id_Categoria;
    String nom_Prod;
    int precio;
    int cantidad;
    int total;

    public ProductoVO(int cod_barra, int id_Local, int id_Usuario, int id_Categoria, String nom_Prod, int precio, int cantidad, int total) {
        this.cod_barra = cod_barra;
        this.id_Local = id_Local;
        this.id_Usuario = id_Usuario;
        this.id_Categoria = id_Categoria;
        this.nom_Prod = nom_Prod;
        this.precio = precio;
        this.cantidad = cantidad;
        this.total = total;
    }

    public ProductoVO() {
    }

    public int getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(int cod_barra) {
        this.cod_barra = cod_barra;
    }

    public int getId_Local() {
        return id_Local;
    }

    public void setId_Local(int id_Local) {
        this.id_Local = id_Local;
    }

    public int getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public int getId_Categoria() {
        return id_Categoria;
    }

    public void setId_Categoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    public String getNom_Prod() {
        return nom_Prod;
    }

    public void setNom_Prod(String nom_Prod) {
        this.nom_Prod = nom_Prod;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}


