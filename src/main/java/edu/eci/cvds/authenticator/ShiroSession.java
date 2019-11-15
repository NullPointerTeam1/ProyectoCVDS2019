package edu.eci.cvds.authenticator;

import edu.eci.cvds.samples.services.ExcepcionServiciosBiblioteca;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

public class ShiroSession implements SessionLogger {
    @Override
    public void login(String correo,String password,boolean hist) throws ExcepcionServiciosBiblioteca {
        try{

            Subject currentUser = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(correo, new Sha256Hash(password).toHex(),hist);
            System.out.println(new Sha256Hash(password));
            currentUser.getSession().setAttribute("Correo",correo);
            
            currentUser.login( token ); 
        } catch ( UnknownAccountException a ) {
            throw new ExcepcionServiciosBiblioteca("Usuario o contraseña incorrectos",a);
        } catch ( IncorrectCredentialsException b ) {
            throw new ExcepcionServiciosBiblioteca("Usuario o contraseña incorrectos",b);
        }
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }
}
