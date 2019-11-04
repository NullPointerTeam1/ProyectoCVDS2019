package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.authenticator.SessionLogger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;

import java.io.IOException;


@SuppressWarnings("deprecation")
@ManagedBean(name="LoginBean")



public class LoginBean extends BasePageBean{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String correo;
    private String password;
    private boolean rememberMe;
    @Inject
    private SessionLogger logger;

   

    public boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void login(String correo,String password,boolean rememberMe){
        try {
            logger.login(correo,password,rememberMe);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/servicios/index.xhtml");
        } catch (ExcepcionServiciosBiblioteca excepcionServiciosBiblioteca) {
            ReservaRecursosBean.setErrorMessage(excepcionServiciosBiblioteca);
        }catch (IOException e) {
        	ReservaRecursosBean.setErrorMessage(e);
        }


    }


    public boolean isLogged(){
        return logger.isLogged();
    }
    
    public void logout() {
    	System.out.println("Ey");
    	if (isLogged()) {
    		System.out.println("Si me desconecté");
    		SecurityUtils.getSubject().logout();
    	}
    }


    

}