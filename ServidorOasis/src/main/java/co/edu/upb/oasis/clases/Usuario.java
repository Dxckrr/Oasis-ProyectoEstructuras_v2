package co.edu.upb.oasis.clases;

import java.io.Serializable;

public class Usuario implements Serializable {
    String usuario;
    String password;
    int id;
    public Usuario(String usuario, String password,int id){
        this.usuario = usuario;
        this.password = password;
        this.id = id;
    }
    public Usuario(String usuario, String password){
        this.usuario = usuario;
        this.password = password;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}

