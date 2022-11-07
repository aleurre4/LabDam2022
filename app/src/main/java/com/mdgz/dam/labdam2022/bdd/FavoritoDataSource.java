package com.mdgz.dam.labdam2022.bdd;

import com.mdgz.dam.labdam2022.bdd.pojo.Favorito;

public class FavoritoDataSource implements DataSource<Favorito>{


    FavoritoDAO favoritoDAO;

    public FavoritoDataSource(FavoritoDAO favoritoDAO){

        this.favoritoDAO = favoritoDAO;


    }

    @Override
    public void guardarXYZ(Favorito entidad, GuardarCallback callback) {

        favoritoDAO.insert(entidad);

    }

    @Override
    public void recuperarXYZ(RecuperarCallback callback) {
        favoritoDAO.loadAll();
    }
}
