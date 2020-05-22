package com.example.convertidor;

public class MedidaCocina {
    private String nombre;
    private String medida1;
    private String medida2;
    private String medida3;
    private int imagen;

    public MedidaCocina(String nombre, String medida1, String medida2, String medida3, int imagen) {
        this.nombre = nombre;
        this.medida1 = medida1;
        this.medida2 = medida2;
        this.medida3 = medida3;
        this.imagen  = imagen;
    }



    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMedida1() {
        return medida1;
    }

    public void setMedida1(String medida1) {
        this.medida1 = medida1;
    }

    public String getMedida2() {
        return medida2;
    }

    public void setMedida2(String medida2) {
        this.medida2 = medida2;
    }

    public String getMedida3() {
        return medida3;
    }

    public void setMedida3(String medida3) {
        this.medida3 = medida3;
    }
}
