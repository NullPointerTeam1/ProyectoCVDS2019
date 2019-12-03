# Biblioteca ECI
## Proyecto final de Ciclos de Vida Del Desarrollo de Software. 
## Periodo 2019-2
## Escuela Colombiana de Ingeniería Julio Garavito

### Integrantes:
|     Nombre    |     Rol         |
|:--------------:|:-------------: |
|**Julián Velasco**|Product Owner    |
|**Orlando Antonio Gelves Kerguelen** |Team Developer       |
|**Johann Sebastian Páez Campos** |Team Developer       |
|**Johan Sebastian Arias Amador** |Team Developer  |
|**Jose Luis Gomez Camacho** |Team Developer    |

### Profesor:
* Julián Velasco


## Descripción del producto

#### Descripción General
La Plataforma Gestión de Recursos Biblioteca, es una herramienta donde el personal de la biblioteca pertenecientes a la Escuela Colombiana de Ingeniería Julio Garavito, pueden registrar las salas de estudio, equipos de cómputo y demás recursos con los que cuenta la biblioteca, junto con los horarios de disponibilidad y demás información importante. El sistema, brinda a los estudiantes de la escuela una posibilida más fácil para asegurar los espacios y recursos necesarios, en aquellos momentos donde más las necesitan (realizando reservas previamente) así como ofrecer al personal de la biblioteca, generar reportes y registros que les permita tener el control de estos recursos, así como saber la ocupación que están teniendo los mismos para poder saber en qué momento se requieren nuevas adquicisiones de equipos.

#### Manual de Usuario 
Para ingresar a los servicios de nuestra aplicación deberá ingresar como administrador o como usuario

Usuario de administrador:

   **Usurio** jose.gomez-ca@mail.escuelaing.edu.co 
   **Contraseña** 123456789

Para ingresar como usuario es:

   **Usurio** prueba.2019@mail.escuelaing.edu.co
   **Contraseña** 123456789
   
**Nota:** un recurso es un elemento de la biblioteca que puede ser (Sala de estudio, Equipo de computo, Equipo de multimedia) el cual tiene un horario para poder ser reservado.
Una reserva no puede ser realizada sobre una activa del mismo recurso.

   
### Funcionalidades

Para poder ingresar nos encontramos con esta diseño de alta calidad y con las últimas tendencias. 

![](img/Funcionalidad1.PNG)

Para visualizar todos los recursos disponibles en  la biblioteca diseñamos una vista que mostramos a continuación

![](img/Funcionalidad2.PNG)

Para el administrador es posible registrar un Nuevo recurso  llenando el formulario mostrado a continuación

![](img/Funcionalidad3.PNG)

También el administrador podrá cambiar el estado de un recurso el cual indicara si el recurso está disponible, ocupado o dañado *(No disponible)*

![](img/Funcionalidad4.PNG)

Para poder reservar un recurso tendremos la siguiente vista en la cual podrá ver cuáles son las reservas que tiene ese recurso y también podrá reservarlo, desde que cumpla con el horario del recurso y no se cruce con alguna otra reserva. 

![](img/Funcionalidad5.PNG)

También podrá programar una reserva para que todos los días se realice a la misma hora (Diario), cada semana el mismo día a la misma hora (semanal) o cada mes el mismo día a la misma hora (mensual)

![](img/Funcionalid6.PNG)

después de esto el usuario podrá ver los detalles del recurso que reservo.

![](img/Funcionalidad7.PNG)

El usuario podrá cancelar esta reserva si se llegó a equivocar o si desea cancelar el recuso por algún otro motivo.

![](img/Funcionalidad8.PNG)

## Arquitectura y diseño detallado


### Modelo E-R (Entidad-Relación)
![](img/MODEL.png)


### Diagrama de clases
![](img/DIAGRAMAPROJECTCVDS.png)

### Enlace de la aplicación en Heroku
[Servicios Biblioteca Heroku](https://biblioteca-eci.herokuapp.com)

### Integración continua
[![CircleCI](https://circleci.com/gh/NullPointerTeam1/ProyectoCVDS2019.svg?style=svg)](https://circleci.com/gh/NullPointerTeam1/ProyectoCVDS2019)

### Calidad del código
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/48a154668669463aae0098daa9ab056d)](https://www.codacy.com/manual/orlandoagk/ProyectoCVDS2019?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=NullPointerTeam1/ProyectoCVDS2019&amp;utm_campaign=Badge_Grade)

### Stack de Tecnología Utilizado

   * [PrimeFaces (Framework)](https://www.primefaces.org/)
   * [JUnit (Property Based Testing)](https://junit.org/junit5/)
   * [Guice (Inyección de Dependencias)](https://github.com/google/guice)
   * [PostgreSQL (DataBase Management)](https://www.postgresql.org)
   
 
 ### Metodologia usada
    Utilizamos la metodología Scrum, dividimos el trabajo por roles durante el desarrollo de la aplicacion, Orlando Gelves se encargó de la parte de Front-End, Johann Paez Back-end, Johan Arias testing, Jose Goméz data base manager.
   
## Sprint 1


![Grafica](img/GraficaSprint1.PNG)

![Issues](img/sprint1issues.PNG)

### Retrospectiva

El primer  sprint se completó  todas las tareas planteadas. Cada integrante del equipo cumplió con los estándares de calidad necesarios y en el tiempo planteado. La página visualmente se ve muy bien, se puede ingresar como administrador o como usuario, se pueden visualizar os recursos disponibles de la biblioteca. Tenemos que corregir fallas pequeñas  en la experiencia de usuario y esperamos para el próximo sprint solucionarlos

## Sprint 2

![Grafica](img/GraficaSprint2.PNG)

![Issues](img/sprint3issues.PNG)

### Retrospectiva

En le segundo sprint nos tomo mas tiempo de lo esperado las correcciones del sprint uno, aunque tuvimos estos inconvenientes logramos terminar todas las tareas propuesta para el mismo, al final la grafica presenta un progreso insuperado debido a que agregamos el caso de uso “Sprint uno issues” a parte de esto nos olvidamos de mover las tareas al finalizarlas.

## Sprint 3

![Grafica](img/GraficaSprint3.PNG)



### Retrospectiva

En el tercer sprint no alcanzamos a terminar la historia de uso numero nueve, se arreglaron los issues y se terminaron las demás historias. el trabajo en equipo fue fudamental durante este proyecto, ya que todos  trabajaron en conjuntó para sacar este proyecto adelante.

**Conexion POSTGRESQL**

**Host** :ec2-174-129-252-211.compute-1.amazonaws.com

**Database** :dfbcbm8f7kkrpu

**User**: iwwkuojbaoqwrw

**Port** :5432

**Password** :df11b9bf00cf66130fc0f5c3b9b0f1c7196cdfaef488270da6446830145c41fe

**URI** :postgres://iwwkuojbaoqwrw:df11b9bf00cf66130fc0f5c3b9b0f1c7196cdfaef488270da6446830145c41fe@ec2-17

**GIT config** git config --global user.name "Juan Perez"

**GIT config** git config --global user.email juan.perez@escuelaing.edu.co
