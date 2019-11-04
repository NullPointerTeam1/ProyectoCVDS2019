package edu.eci.cvds.authenticator;

import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;

public interface SessionLogger {
    public void login(String correo,String password,boolean hist) throws ExcepcionServiciosBiblioteca;
    
    public boolean isLogged();
}