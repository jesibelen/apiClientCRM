package com.company.ada.apiclientcrm.repositories;

import com.company.ada.apiclientcrm.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
/*El servicio va hacer la "magia" con el repositorio.
Porque al ser una interfaz el repositorio, no podemos instanciarla sino que tenemos que
crear un objeto de una clase que implemente esa interfaz*/

//LO TERCERO QUE SE HACE
@Repository
public interface ClienteRepository extends JpaRepository<ClientEntity, Integer> { //extiende a JpaRepository<ENTIDAD, TipoDeDatos de ID>
    //EL REPO UNTILIZA, INCLUYE A LA ENTIDAD PARA COMUNICARSE MEDIANTE JDBC CON LA DB
    //El REPOSITORY es una interfaz que extiende a JpaRepository la cual es una interfaz que define ciertos metodos ya creados en Spring
    //El repo tiene esa magia, la cual me trae la info que necesito para trabajar con la entidad
    //  Aqui se encuentran metodos creados por mi mientras los metodos ya creados se puede usar directo en service
    //(2)
    List<ClientEntity> findClientEntitiesByEmpresa(String empresa);

    //(3)
    List<ClientEntity> findClientEntitiesByNombreContaining(String nombre); //es parecido  al like de sql

    //(5) clase 1-06-21
    /* el jpa o hibernate lo que va hacer despues con Spring crear con inversion de control */
    ClientEntity findClientEntitiesByIdclienteOrNombreEquals(Integer idcliente, String nombre);

    //Mostrar una lista de clientes que pertenezca a la misma empresa y ordenado ascendente por nombre
    List<ClientEntity> findClientEntitiesByEmpresaOrderByNombreAsc(String empresa);

    /*
        Cual es el camino que se tenia que hacer para agregar un nuevo comportamiento o mensaje a mi API ?
        Repository despues controller
     */


    /* List<ClientEntity> findClientEntitiesByNombreStartingWithAndCargoContainingAndEmpresa(String nombre, String cargo, String empresa);
    * O sea va hacer un SELECT ENORME donde va a buscar nombres que inicia con algo y cargo que si contiene algo y por empresa
    * */
}
