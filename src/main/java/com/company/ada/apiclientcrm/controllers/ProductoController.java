package com.company.ada.apiclientcrm.controllers;

import com.company.ada.apiclientcrm.entities.ProductoEntity;
import com.company.ada.apiclientcrm.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductoController {
    /*
    Cuando hago un @restcontroller estoy haciendo por un lado un controlador, o sea va mapear direcciones o path
    dentro de mi proyecto y lo va a tomar con get y post y la salida (return) de los metoddos sera el cuerpo de la respuesta

    La diferencia con un @Controller es que cuando se mapea se necesitara un template
    resources -> templates -> una-prueba.html

    -ESTE CONTROLADOR QUE RESPONDEN LAS SOLICITUDES ES UNA IDEA DE MICROSERVICIO, TENGO PEQUENIOS  MICROSERVICIOS,
    EN ESTE CASO TENGO UNO DEDICADO A PRODUCTOS QUE RESPONDEN SOLICITUDES EXTERNAS O INTERNAS Y GESTIONAR DE FORMA ATOMICA
    ALL lo que tenga relacion a productos

    El controlador es el que interactua con el usuario y usa al servicio para acceder al modelo (MVC), mostrar o cambiarlo
     */

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("productos")
    public List<ProductoEntity> getProductos(){
        return productoService.getProductos();
    }

    @GetMapping("/productos/nombre/{nombre}")
    public List<ProductoEntity> findProductosByNombreContainig(@PathVariable String nombre) {
        return productoService.buscarProductosPorNombreConteniendo(nombre);
    }
    @GetMapping("/productos/categoria/{categoria}")
    public List<ProductoEntity> findProductosPorCategoria(@PathVariable String categoria){
        return productoService.buscarProductorPorCategoria(categoria);
    }
    /* ******************************************************************************************** */
    @GetMapping("nuevo-producto")
    public String nuevoProductoForm(Model modelo){
        modelo.addAttribute("producto", new ProductoEntity());
        return "guardar-producto";
    }

    @PostMapping("nuevo-productor")
    public String nuevoProductoSubmit(@ModelAttribute ProductoEntity producto, Model modelo){
        modelo.addAttribute("producto", producto);
        productoService.saveProduct(producto);
        return "ver-producto";
    }
    /* ************************************************************************************** */
    @PostMapping("productos/guardarDificil")
    public String guardarProductosGet(
            @RequestParam String codigo_producto,
            @RequestParam String categoria,
            @RequestParam String nombre,
            @RequestParam String descripcion,
            @RequestParam Double precio_unitario,
            @RequestParam Integer stock){
        ProductoEntity producto = new ProductoEntity(
                codigo_producto, categoria, nombre, descripcion, precio_unitario, stock
        );
        return producto.toString();
    }
    @GetMapping("unaPrueba")
    public String unaPrueba(){
        return "una-prueba";
        //no funciona con @Controller si no tiene un templete (en resources) que se llame igual al string de salida
    }
    /* ********Combinacion de html lindo y back ***************
    @GetMapping("holamundo")
    public String unMetodoCualquiera(){
        return "<i style = 'color:red'>hola</i> <b>mundo<b/>";
    }
     ************************************************
    url es el LOCALIZADOR DE RECURSOS EN LA RED
    path es el "camino" desde el dominio hasta el recurso
    EJ:
    1) google.com/clientes/id/1
    google.com = DOMINIO
    /clientes/id/1= PATH
    ____________________________________________________
    2) https://5ta-backend-online.adaitw.org/docs/00-intro

    * Protocolo= https
    * Dominio= adaitw.org
    * subdominio= 5ta-backend-online
    * path = /docs/00-intro

    ***************************************************** */
}
