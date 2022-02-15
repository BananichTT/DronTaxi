/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.drontaxi.db;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author buldi
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "userrole")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Userrole.findAll", query = "SELECT u FROM Userrole u"),
    @javax.persistence.NamedQuery(name = "Userrole.findByIdRole", query = "SELECT u FROM Userrole u WHERE u.idRole = :idRole"),
    @javax.persistence.NamedQuery(name = "Userrole.findByRoleName", query = "SELECT u FROM Userrole u WHERE u.roleName = :roleName")})
public class Userrole implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "idRole")
    private Integer idRole;
    @javax.persistence.Column(name = "RoleName")
    private String roleName;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "roleId")
    private Collection<User> userCollection;

    public Userrole() {
    }

    public Userrole(Integer idRole) {
        this.idRole = idRole;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRole != null ? idRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Userrole)) {
            return false;
        }
        Userrole other = (Userrole) object;
        if ((this.idRole == null && other.idRole != null) || (this.idRole != null && !this.idRole.equals(other.idRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.drontaxi.db.Userrole[ idRole=" + idRole + " ]";
    }
    
}
