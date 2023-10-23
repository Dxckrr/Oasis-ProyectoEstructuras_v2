package co.edu.upb.oasis.clases;

import java.io.Serializable;

/**
 * Class that represents a user.
 * 
 * Clase que representa a un usuario.
 * 
 * @author Juan David Patiño Parra
 */
public class Usuario implements Serializable {
    String usuario;
    String password;
    int id;

    public Usuario(String usuario, String password, int id) {
        this.usuario = usuario;
        this.password = password;
        this.id = id;
    }

    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    /**
     * Get the userType of the user.
     * 
     * @return The 'userType' of the user.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Set the username of the user.
     * 
     * @param usuario The username to set.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Get the password of the user.
     * 
     * @return The 'password' of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user.
     * 
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the user ID.
     * 
     * @return The user 'id'.
     */
    public int getId() {
        return id;
    }

    /**
     * Set the user ID.
     * 
     * @param id The user 'id' to set.
     */
    public void setId(int id) {
        this.id = id;

    @Override
    public String toString() {
        return "Usuario [usuario=" + usuario + ", contraseña=" + password + ", id=" + id +"]";
    }

