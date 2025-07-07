/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import Dominio.AlbumDominio;
import Dominio.ArtistaSolitarioDominio;
import Dominio.BandaDominio;
import java.util.ArrayList;

/**
 *
 * @author $Luis Carlos Manjarrez Gonzalez
 */
public class AlbumDAO {
  public ArrayList<AlbumDominio> consultarAlbumesSolitario(ArtistaSolitarioDominio artista){
        return artista.getListaAlbumes();
    }
    public ArrayList<AlbumDominio> consultarAlbumesBanda(BandaDominio banda){
        return banda.getListaAlbumes();
    }
}
