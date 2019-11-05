package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.mybatis.*;
import edu.eci.cvds.samples.services.impl.ServiciosReservaImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosReservaFactory {

    private static ServiciosReservaFactory instance = new ServiciosReservaFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
            	setEnvironmentId(env);
            	install(JdbcHelper.PostgreSQL);
            	setClassPathResource(pathResource);
                bind(RecursoDAO.class).to(MyBATISRecursoDAO.class);
                bind(UsuarioDAO.class).to(MyBATISUsuarioDAO.class);
                bind(TipoRecursoDAO.class).to(MyBATISTipoRecursoDAO.class);
                bind(ServiciosReserva.class).to(ServiciosReservaImpl.class);
            }
        });
    }

    private ServiciosReservaFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosReserva getServiciosBiblioteca(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosReserva.class);
    }


    public ServiciosReserva getServiciosBibliotecaTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosReserva.class);
    }


    public static ServiciosReservaFactory getInstance(){
        return instance;
    }

}