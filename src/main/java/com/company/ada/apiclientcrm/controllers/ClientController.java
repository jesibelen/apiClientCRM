package com.company.ada.apiclientcrm.controllers;

import com.company.ada.apiclientcrm.entities.ClientEntity;
import com.company.ada.apiclientcrm.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    //Que es lo que necesita el controlador para funcionar?
    // Necesita el clienTServicio

    /* El controller es el que define nuestra API.El controller es la API, es mi interfaz que me permite
    exponer metodos hacia el exterior para que puedan ser llamados. Ademas es el que responde a las solicitudes http
    que se le hagan, se lo puede considerar como servlet (teoria de hibenate), es el que responde JSON, HTML.

    Tambien es el que redirecciona http, cuando por ejemplo el usuario quiere ingresar un sitio y no esta registrado, logeados
    o si ingresaron a una parte de mi sitio que no existe, el lo re direcciona.
         */

    private final ClientService clientService;

    // Y DONDE OBTENGO EL CLIENTSERVICE?
    // Como parametro del controlador

    @Autowired
    public ClientController(ClientService clientService) { //RECIBE EL SERVICIO
        this.clientService = clientService;
    }
    @GetMapping("clientes") //Y HACE UN MAPEADO con URL clientes
    public List<ClientEntity> mostrarClientes(){ //me muestra todos los clientes por json
        return clientService.getClientes();
    }
    //(2)
    @GetMapping("clientes/{empresa}")// lo que esta dentro de las llaves es el parametro que enviare al metodo buscarClientesPorEmpresa
    public List<ClientEntity> buscarClientesPorEmpresa(@PathVariable String empresa){ //es una variable que esta en la URL PATH
        return clientService.buscarClientesPorEmpresas(empresa);
    }
    /*(3) Importante la URL clientes/buscarPor/nombre DEBE SER DISTINTA A LA (2)
    YA QUE SI LA URL fuese clientes/nombre saldra error porque son las mismas y tipo String
     */
    @GetMapping("clientes/buscarPor/{nombre}")
    public List<ClientEntity>buscarClientesPorNombreConteniendo(@PathVariable String nombre){
        return clientService.buscarClientesPorNombreConteniendo(nombre);
    }

    //(4)
    @GetMapping("clientes/id/{id}")
    public ClientEntity buscarPorID(@PathVariable String id){
        Integer unID= 0;
        try {
            if (id != null)
                unID = Integer.valueOf(id);

        }catch (NumberFormatException excep){
            excep.printStackTrace();
        }
        return clientService.buscarPorID(unID);
    }
}
