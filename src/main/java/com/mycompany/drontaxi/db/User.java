/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.drontaxi.db;

import java.io.Serializable;

/**
 *
 * @author buldi
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "user")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @javax.persistence.NamedQuery(name = "User.findByIduser", query = "SELECT u FROM User u WHERE u.iduser = :iduser"),
    @javax.persistence.NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
    @javax.persistence.NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "iduser")
    private Integer iduser;
    @javax.persistence.Column(name = "login")
    private String login;
    @javax.persistence.Column(name = "password")
    private String password;
    @javax.persistence.JoinColumn(name = "RoleId", referencedColumnName = "idRole")
    @javax.persistence.ManyToOne(optional = false)
    private Userrole roleId;

    public User() {
    }

    public User(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Userrole getRoleId() {
        return roleId;
    }

    public void setRoleId(Userrole roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduser != null ? iduser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.iduser == null && other.iduser != null) || (this.iduser != null && !this.iduser.equals(other.iduser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.drontaxi.db.User[ iduser=" + iduser + " ]";
    }
    
}
