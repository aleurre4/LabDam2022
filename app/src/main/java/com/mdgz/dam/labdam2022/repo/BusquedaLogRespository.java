package com.mdgz.dam.labdam2022.repo;

import android.content.Context;

import com.mdgz.dam.labdam2022.model.BusquedaLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BusquedaLogRespository {

    String FILENAME = "busquedas";

    Context ctx;
    private static List<BusquedaLog> REPOSITORIOLOG = new ArrayList<>();

    public BusquedaLogRespository(Context ctx){
        this.ctx = ctx;
        cargarLista();
    }

    public void agregar(BusquedaLog log) {
        REPOSITORIOLOG.add(log);
        guardarLista();
    }

    public void actualizar(BusquedaLog log) {
        int indice = REPOSITORIOLOG.indexOf(log);
        REPOSITORIOLOG.set(indice,log);
        guardarLista();
    }

    public void eliminar(BusquedaLog log) {
        REPOSITORIOLOG.remove(log);
        guardarLista();
    }

    public List<BusquedaLog> listarTodos() {
        return REPOSITORIOLOG;
    }


    public BusquedaLog busquedaPorID(Integer id) {

        for(BusquedaLog log: REPOSITORIOLOG){
            if(log.getId().equals(id)) return log;
        }

        return null;
    }

    private void cargarLista(){
        try {
            JSONArray datos =
                    (JSONArray) new JSONTokener(this.leerDeArchivo()).nextValue();
            REPOSITORIOLOG.clear();
            for(int i=0;i<datos.length();i++){
                JSONObject fila = datos.getJSONObject(i);
                BusquedaLog log= new BusquedaLog();
                log.loadFromJson(fila);
                REPOSITORIOLOG.add(log);
            }
        } catch (JSONException e) {e.printStackTrace();}
    }
    private void guardarLista(){
        JSONArray arregloBusquedaLogs = new JSONArray();
        for(BusquedaLog log : this.REPOSITORIOLOG){
            arregloBusquedaLogs.put(log.toJson());
        }
        escribirEnArchivo(arregloBusquedaLogs);
    }

    private void escribirEnArchivo(JSONArray arregloBusquedaLogs){
        FileOutputStream fos = null;
        try {
            fos = ctx.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fos.write(arregloBusquedaLogs.toString().getBytes());
            fos.close();
        } catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) { e.printStackTrace();}
    }

    private String leerDeArchivo(){
        FileInputStream fis = null;
        StringBuilder sb = new StringBuilder();
        try {
            fis = ctx.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader buffRdr= new BufferedReader(isr);
            String line;
            while ((line = buffRdr.readLine()) != null) { sb.append(line); }
            fis.close();
        } catch (FileNotFoundException e) {e.printStackTrace();}
        catch (IOException e) { e.printStackTrace(); }
        return sb.toString();
    }




}
