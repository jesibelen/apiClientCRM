package com.company.ada.apiclientcrm.services;

import com.company.ada.apiclientcrm.entities.ClientEntity;
import com.company.ada.apiclientcrm.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.PushBuilder;
import java.util.List;

@Service
public class ClientService {
    private final ClienteRepository clienteRepo; //CONSTANTE
    //El servico es la capa que nos permite interactuar internamente con todos los repositorios que vayamos a utilizar
    /*Este paso es super importante porque al servicio se le va a llegar datos
    y a esos datos hay que validarlos o convertirlos, por ej que me envie un id en string y yo tenga que convertirlo en int,
    hay cosas que se hace en el servicio antes de ir al repo y conectarnos con la db.
    */

    @Autowired
    public ClientService(ClienteRepository clienteRepo) { //RECIBE EL REPOSITORIO GRACIAS AL AUTOWIRED
        this.clienteRepo = clienteRepo;
    }

    public List<ClientEntity> getClientes(){
        return clienteRepo.findAll();//PIDO QUE TRAIGA TODOS LOS CLIENTES DEL REPO EN UNA LISTA
    }
    //(2)
    public List<ClientEntity> buscarClientesPorEmpresas(String empresa){
        return clienteRepo.findClientEntitiesByEmpresa(empresa); //LLamo al metodo que puse en el interfaz
    }

    //(3)
    public List<ClientEntity> buscarClientesPorNombreConteniendo(String nombre){
        return clienteRepo.findClientEntitiesByNombreContaining(nombre);
    }

    //(4) Este metodo ya esta en spring y no es necesario escribir el nombre del metodo en mi repositorio
    public ClientEntity buscarPorID(Integer id){
        //return clienteRepo.findById(id).get(); no me cumple para excepciones
        return clienteRepo.findById(id).orElse(null);//NOSOTROS DEVOLVEMOS NULO PORQUE NO ES NUESTRA TAREA DE DAR MSJ AL USUARIO EN ESE CASO SERIA DEL FRONTEND
    }


}
