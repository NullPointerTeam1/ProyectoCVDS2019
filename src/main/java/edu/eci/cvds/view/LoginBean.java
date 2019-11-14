package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;
import edu.eci.cvds.authenticator.SessionLogger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.authz.annotation.RequiresGuest;


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

    public Subject getCurrentUser(){
    	Subject currentUser = SecurityUtils.getSubject();
		return currentUser;
    }
    
  
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
    
    @RequiresGuest
    public void login(String correo,String password,boolean rememberMe) throws ExcepcionServiciosBiblioteca{
        try {
            logger.login(correo,password,rememberMe);
            FacesContext.getCurrentInstance().getExternalContext().redirect("/index.xhtml");
        } catch (ExcepcionServiciosBiblioteca excepcionServiciosBiblioteca) {
            LoginBean.setErrorMessage(excepcionServiciosBiblioteca);
        }catch (IOException e) {
        	LoginBean.setErrorMessage(e);
        }catch(Exception e) {
        	LoginBean.setErrorMessage(e);
        }


    }


    public boolean isLogged(){
        return logger.isLogged();
    }
    
    public void logout() throws IOException {
    	if (isLogged()) {
    		FacesContext.getCurrentInstance().getExternalContext().redirect("/login.xhtml");
    		SecurityUtils.getSubject().logout();
    	}
    }
    
    protected static void setErrorMessage(Exception e) {
		String message = e.getMessage();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}

    

}