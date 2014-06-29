/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nl.rkk.marktplaats.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Kaj
 */
@Entity
//@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "User.findByCredentials", query = "SELECT u FROM MyUser u WHERE u.email = :email AND u.password = :password"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM MyUser u WHERE u.email = :email")
})
public class MyUser implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String password;
    
    private UserRole type;
    
    @OneToMany()
    private Collection<Ad> ads;
    
    @OneToMany()
    private Collection<Bid> bids;

    public Collection<Ad> getAds() {
        return ads;
    }

    public void setAds(Collection<Ad> ads) {
        this.ads = ads;
    }

    public Collection<Bid> getBids() {
        return bids;
    }

    public void setBids(Collection<Bid> bids) {
        this.bids = bids;
    }
    
    public MyUser() {
        
    }
    
    public MyUser(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
        this.setType(UserRole.User);
    }
    
    public MyUser(String email, String password, UserRole type) {
        this.setEmail(email);
        this.setPassword(password);
        this.setType(type);
    }
    
    public MyUser(String email, String password, UserRole type, String firstName, String lastName) {
        this.setEmail(email);
        this.setPassword(password);
        this.setType(type);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getType() {
        return type;
    }

    public void setType(UserRole type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MyUser)) {
            return false;
        }
        MyUser other = (MyUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nl.rkk.marktplaats.models.MyUser[ id=" + id + " ]";
    }
    
}
