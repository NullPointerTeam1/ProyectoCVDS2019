package edu.eci.cvds.view;

import edu.eci.cvds.sampleprj.dao.PersistenceException;
import edu.eci.cvds.samples.entities.*;


import edu.eci.cvds.samples.services.*;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

@SuppressWarnings("deprecation")
@ManagedBean(name = "ReservaRecursosBean")
@ApplicationScoped
public class ReservaRecursosBean extends BasePageBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ServiciosReserva serviciosReserva;
	private Usuario selectedUsuario;
	private List<Recurso> recursosDisponibles;
	private Recurso recursoActual;
	private Date fechaInicio;
	private List<Recurso> recursosFiltrados;
	private String idRecursoActual;
	
	
	private ScheduleModel eventModel = new DefaultScheduleModel();
    private ScheduleEvent event = new DefaultScheduleEvent("Ey", fechaInicio, fechaInicio);
 
    private boolean showWeekends = true;
    private boolean tooltip = true;
    private boolean allDaySlot = true;
 

 
    public ScheduleModel getEventModel() {
    	eventModel.clear();
    	try {
    		List<RecursoReservado> recursosReservados = serviciosReserva.consultarReserva(recursoActual.getId());
			for (int i= 0;i<recursosReservados.size();i++) {
				DefaultScheduleEvent eventico;
				eventico = new DefaultScheduleEvent();
		    	eventico.setStartDate(Date.from(LocalDateTime.parse(recursosReservados.get(i).getFechaInicioReserva().toString()+"T"+recursosReservados.get(i).getHoraInicioReserva()).toInstant(ZoneOffset.ofHours(0))));
		    	eventico.setEndDate(Date.from(LocalDateTime.parse(recursosReservados.get(i).getFechaFinReserva().toString()+"T"+recursosReservados.get(i).getHoraFinReserva()).toInstant(ZoneOffset.ofHours(0))));
		    	eventico.setTitle("Reservado");
		    	eventico.setId(Integer.toString(recursosReservados.get(i).getId()));
		    	eventModel.addEvent(eventico);
			}
		} catch (ExcepcionServiciosBiblioteca e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }
    
    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }
     
    public void addEvent(String recurrencia) throws ExcepcionServiciosBiblioteca {
        
 
        /*if(event.getId() == null) {
            eventModel.addEvent(event);
        }else {
            eventModel.updateEvent(event);
        }*/
    	Usuario superUsuarioActual = serviciosReserva.consultarUsuarioPorCorreo((String) SecurityUtils.getSubject().getSession().getAttribute("Correo"));
    	ZoneId defaultZoneId = ZoneId.systemDefault();
    	LocalDateTime fechaInicioTemp = event.getStartDate().toInstant().atZone(defaultZoneId).toLocalDateTime();
    	LocalDateTime fechaFinTemp = event.getEndDate().toInstant().atZone(defaultZoneId).toLocalDateTime(); 
    	RecursoReservado recursoReservado = new RecursoReservado(1, fechaInicioTemp.toLocalDate(), fechaFinTemp.toLocalDate(), fechaInicioTemp.toLocalTime(), fechaFinTemp.toLocalTime(), recursoActual, superUsuarioActual);
    	serviciosReserva.registrarReserva(recursoReservado, recurrencia);
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent();
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
 
    public boolean isShowWeekends() {
        return showWeekends;
    }
 
    public void setShowWeekends(boolean showWeekends) {
        this.showWeekends = showWeekends;
    }
 
    public boolean isTooltip() {
        return tooltip;
    }
 
    public void setTooltip(boolean tooltip) {
        this.tooltip = tooltip;
    }
 
    public boolean isAllDaySlot() {
        return allDaySlot;
    }
 
    public void setAllDaySlot(boolean allDaySlot) {
        this.allDaySlot = allDaySlot;
    }
 


	public void registrarUsuario(String nombre, long carnet, String carrera, String rol, String correo) {
		try {
			serviciosReserva.registrarUsuario(new Usuario(nombre, carnet, carrera, rol, correo));
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}

	}

	public Recurso getRecursoActual() {
		return recursoActual;
	}

	public void setRecursoActual(Recurso recursoActual) {
		this.recursoActual = recursoActual;
	}

	public List<Recurso> getRecursosDisponibles(){
		return recursosDisponibles;
	}

	public Usuario consultarUsuario(long documento) {
		Usuario usuario = null;
		try {
			usuario = serviciosReserva.consultarUsuario(documento);
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return usuario;
	}

	public List<Usuario> consultarUsuarios() {
		List<Usuario> usuarios = null;
		try {
			usuarios = serviciosReserva.consultarUsuarios();
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return usuarios;
	}

	public void registrarRecurso(String tipo, String nombre, String ubicacion, String capacidad, Date FechaI, Date FechaF) {
		try {
			TipoRecurso tipoRecurso = null;
			switch(tipo) {
				case "1":{
					tipoRecurso = new TipoRecurso(1,"Equipo de Computo");
					capacidad = "0";
					break;
				} case "2":{
					tipoRecurso = new TipoRecurso(2,"Sala de Estudio");					
					break;
				} case "3":{
					tipoRecurso = new TipoRecurso(3,"Equipo de Multimedia");
					capacidad = "0";
					break;
				}
			}
			serviciosReserva
					.registrarRecurso(new Recurso(tipoRecurso, 1, nombre, ubicacion, Integer.parseInt(capacidad), FechaI.toInstant().atZone(ZoneId.systemDefault()).toLocalTime(), FechaF.toInstant().atZone(ZoneId.systemDefault()).toLocalTime(), "Disponible"));
			setErrorMessage("El registro de "+ nombre +" se hizo correctamente");
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		} catch(NumberFormatException e) {
			if (capacidad == null || capacidad.equals("")) {
				setErrorMessage("La capacidad no puede estar vacia");
			} else {
				setErrorMessage("La capacidad no tiene un valor númerico válido.");
			}
		} catch(Exception e) {
			setErrorMessage("Debe rellenar todos los campos.");
		}

	}

	public Recurso consultarRecurso(String id) {
		Recurso recurso = null;
		try {
			recurso = serviciosReserva.consultarRecurso(Long.parseLong(id));
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return recurso;
	}

	public List<Recurso> consultarRecursos() {
		List<Recurso> recursos = null;
		
		try {
			recursos = serviciosReserva.consultarRecursos();
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return recursos;
	}
	
	public List<Recurso> consultarRecursosDisponibles() {
		List<Recurso> recursos = new ArrayList<Recurso>();
		try {
			recursos = serviciosReserva.consultarRecursos();
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		List<Recurso> disponibles = new ArrayList<Recurso>();
		for (Recurso r: recursos) {
			if (r.getDisponibilidad().equals("Disponible")) {
				disponibles.add(r);
			}
		}

		recursosDisponibles = disponibles;
		return disponibles;
	}
	
	public void actualizarEstadoRecurso(String id, String estado) {
		try {
			
			serviciosReserva.actualizarEstadoRecurso(Long.parseLong(id), estado);
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
	}

	public void registrarTipoRecurso(int id, String descripcion) {
		try {
			serviciosReserva.registrarTipoRecurso(new TipoRecurso(id, descripcion));
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}

	}

	public TipoRecurso consultarTipoRecurso(long id) {
		TipoRecurso tipoRecurso = null;
		try {
			tipoRecurso = serviciosReserva.consultarTipoRecurso(id);
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return tipoRecurso;
	}

	public List<TipoRecurso> consultarTiposRecursos() {
		List<TipoRecurso> tipoRecursos = null;
		try {
			tipoRecursos = serviciosReserva.consultarTiposRecurso();
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		}
		return tipoRecursos;
	}
	
	public void registrarRecursoReservado(int id, LocalDateTime iniTime, LocalDateTime finTime, Recurso recurso, String correo, String recurrencia) {
		try {
			LocalDate iniDate = iniTime.toLocalDate();
			LocalDate finDate = finTime.toLocalDate();
			LocalTime iniHour = iniTime.toLocalTime();
			LocalTime finHour = finTime.toLocalTime();
			Usuario usuario = serviciosReserva.consultarUsuarioPorCorreo(correo);
			RecursoReservado recursoReservado = new RecursoReservado(id, iniDate, finDate, iniHour, finHour, recurso, usuario);			
			serviciosReserva.registrarReserva(recursoReservado, recurrencia);	
			setErrorMessage("El registro de la reserva se hizo correctamente");
		} catch (ExcepcionServiciosBiblioteca e) {
			setErrorMessage(e);
		} catch(Exception e) {
			setErrorMessage("Debe rellenar todos los campos.");
		}
	}

	public void setSelectedUsuario(Usuario usuario) {
		this.selectedUsuario = usuario;
	}

	public Usuario getSelectedUsuario() {
		return selectedUsuario;
	}

	protected static void setErrorMessage(Exception e) {
		String message = e.getMessage();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}
	
	protected static void setErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, null));
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public List<Recurso> getRecursosFiltrados() {
		return recursosFiltrados;
	}

	public void setRecursosFiltrados(List<Recurso> recursosFiltrados) {
		this.recursosFiltrados = recursosFiltrados;
	}

	public String getIdRecursoActual() {
		return idRecursoActual;
	}

	public void setIdRecursoActual(String idRecursoActual) {
		recursoActual = consultarRecurso(idRecursoActual);
		this.idRecursoActual = idRecursoActual;
	}



}

