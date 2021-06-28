package com.company.ada.apiclientcrm.services;

import com.company.ada.apiclientcrm.entities.ClientEntity;
import com.company.ada.apiclientcrm.entities.ProductoEntity;
import com.company.ada.apiclientcrm.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ProductoService {
    /* ************************************************************ */
    /* El SERVICIO para tener acceso al repositorio debe tener un objeto REPOSITORY constante
    ya que el REPO NO CAMBIA
     */
    private final ProductoRepository productoRepository; /*toda cte debe ser inicializada con algo en nuestro caso
    lo que haremos es agregar en el constructor como parametro y @AUTOWIRED o sea que mi Spring lo genere*/

    @Autowired//ANOTACION DE SPRING (inyeccion de dependencias)
    public ProductoService(ProductoRepository productoRepository) { //RECIBE EL REPOSITORIO GRACIAS AL AUTOWIRED
        this.productoRepository = productoRepository;
    }
    /* *********************************************************** */

    public List<ProductoEntity> getProductos(){
        return productoRepository.findAll();
    }

    public ProductoEntity buscarProducto(Integer id){
        return productoRepository.findById(id).orElse(null);
        //como es clase opcional => puedo decirle que me devuelva el producto o sino NULO
    }

    public void saveProduct(ProductoEntity producto){
        productoRepository.save(producto); //esto es parecido a insert into producto a DB (sql)
    }

    public List<ProductoEntity> buscarProductosPorNombreConteniendo(String nombre){
        return productoRepository.findProductoEntitiesByNombreContaining(nombre);// la  firma del metodo se tuvo que hacer en el repo
    }

    public List<ProductoEntity> buscarProductorPorCategoria(String categoria){
        return productoRepository.findProductoEntitiesByCategoria(categoria);
    }

    /* En caso que me llegue un string
    public ProductoEntity buscarProducto(Integer id){
        Integer numero;
        try{
            numero = Integer.valueof(id_producto);
            return productoRepository.findById(id).orElse(null);

        } catch(NumberFormatException e){
            return null;
        }
    }

    * ***********************************************/
    /* VALIDACION vs EXCEPCION
    para validar usamos condicionales (if/switch)
    mientras el (try_catch) no se puede utilizar para validar o sea no puede ser un control de flujo,
    porq el tryCatch atrapa excepciones
     */

}
