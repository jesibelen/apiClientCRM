package com.company.ada.apiclientcrm.entities;

import javax.persistence.*;//esto es JPA
//LO 2do QUE SE HACE ES LA ENTIDAD MAPEADO

/*
ENTITY (o BEAN) se comunica con la base de datos (db NO pertenece a mi sistema) mediante el protocolo JDBC
que es el controlador que utiliza Mysql
 */

@Entity
@Table(name="clientes") //se mapea contra la tabla cliente, usar table java.persistence
public class ClientEntity {
    //Mapareamos con las cosas que tengo en la base de datos
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcliente;
    private String nombre;
    private String cargo;
    private String empresa;
    private String telefono;
    private String mail;


    //* CONSTRUCTORES *
    //construtor vacio (opcional)
    public ClientEntity() {
    }

    //constructor completo (opcional)
    public ClientEntity(Integer idcliente, String nombre, String cargo, String empresa, String telfono, String mail) {
        this.idcliente = idcliente;
        this.nombre = nombre;
        this.cargo = cargo;
        this.empresa = empresa;
        this.telefono = telfono;
        this.mail = mail;
    }

    //constructor sin ID (opcional)
    public ClientEntity(String nombre, String cargo, String empresa, String telfono, String mail) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.empresa = empresa;
        this.telefono = telfono;
        this.mail = mail;
    }

    //ACCESORS (getter y setter)
    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTelfono() {
        return cargo;
    }

    public void setTelfono(String telfono) {
        this.telefono = telfono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    //----------------------------------
    @Override
    public String toString() {
        return "ClientEntity{" +
                "idcliente=" + idcliente +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", empresa='" + empresa + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
