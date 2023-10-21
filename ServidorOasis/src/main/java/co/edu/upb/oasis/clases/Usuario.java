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
    @Override
    public String toString() {
        return "Usuario [usuario=" + usuario + ", contraseña=" + password + ", id=" + id +"]";
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario1 = (Usuario) o;
        return id == usuario1.id &&
                Objects.equals(usuario, usuario1.usuario) &&
                Objects.equals(password, usuario1.password);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(usuario, password, id);
    }*/

}