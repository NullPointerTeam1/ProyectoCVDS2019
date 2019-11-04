package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.mybatis.*;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.impl.ServiciosAlquilerImpl;

public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				install(JdbcHelper.MySQL);
				setEnvironmentId("development");
				setClassPathResource("mybatis-config.xml");

				// TODO Add service class associated to Stub implementation
				bind(ServiciosAlquiler.class).to(ServiciosAlquilerImpl.class);
				bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
				bind(RecursoDAO.class).to(MyBATISRecursoDAO.class);
				bind(TipoRecursoDAO.class).to(MyBATISTipoRecursoDAO.class);

			}
		});

		servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
	}
}