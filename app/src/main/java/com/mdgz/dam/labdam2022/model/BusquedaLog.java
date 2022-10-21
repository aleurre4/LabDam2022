package com.mdgz.dam.labdam2022.model;

import org.json.JSONException;
import org.json.JSONObject;

public class BusquedaLog {
    private Integer id;
    private String hora;
    private Integer cantidadPersonas;
    private String tipo;
    private String precioMin;
    private String precioMax;
    private String ciudad;
    private Boolean wifi;
    private Integer cantidadResultados;



    public JSONObject toJson(){

        JSONObject unaBusqueda = new JSONObject();

        try{

            unaBusqueda.put("id",id);
            unaBusqueda.put("hora",hora);
            unaBusqueda.put("cantidadPersonas",cantidadPersonas);
            unaBusqueda.put("tipo",tipo);
            unaBusqueda.put("precioMin",precioMin);
            unaBusqueda.put("precioMax",precioMax);
            unaBusqueda.put("ciudad", ciudad);
            unaBusqueda.put("wifi",wifi);
            unaBusqueda.put("cantidadResultados",cantidadResultados);

        }catch(JSONException e){
            e.printStackTrace();
        }
        return unaBusqueda;
    }

    public void loadFromJson(JSONObject fila){

        try{
            this.setId(fila.getInt("id"));
            this.setHora(fila.getString("hora"));
            this.setCantidadPersonas(fila.getInt("cantidadPersonas"));
            this.setTipo(fila.getString("tipo"));
            this.setPrecioMin(fila.getString("precioMin"));
            this.setPrecioMax(fila.getString("precioMax"));
            this.setCiudad(fila.getString("ciudad"));
            this.setWifi(fila.getBoolean("wifi"));
            this.setCantidadResultados(fila.getInt("cantidadResultados"));

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Integer cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrecioMin() {
        return precioMin;
    }

    public void setPrecioMin(String precioMin) {
        this.precioMin = precioMin;
    }

    public String getPrecioMax() {
        return precioMax;
    }

    public void setPrecioMax(String precioMax) {
        this.precioMax = precioMax;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Integer getCantidadResultados() {
        return cantidadResultados;
    }

    public void setCantidadResultados(Integer cantidadResultados) {
        this.cantidadResultados = cantidadResultados;
    }


    @Override
    public String toString() {
        return "BusquedaLog  { " +
                "id=" + id +
                ", hora='" + hora + '\'' +
                ", cantidadPersonas=" + cantidadPersonas +
                ", tipo='" + tipo + '\'' +
                ", precioMin='" + precioMin + '\'' +
                ", precioMax='" + precioMax + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", wifi=" + wifi +
                ", cantidadResultados=" + cantidadResultados +
                '}';
    }
}
