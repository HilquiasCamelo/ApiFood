package com.hilquiascamelo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hilquiascamelo.models.enums.Profile;
import com.hilquiascamelo.models.enums.UserType;
import jdk.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.io.Serializable;
import java.text.FieldPosition;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.addAll;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsers;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="FONE_USER")
    private List<String> foneUser = new ArrayList<String>();
    @JsonIgnore
    private String password;

    private String email;

    private Integer type;

    private boolean situation;

     @ElementCollection(fetch = FetchType.EAGER)  
     @CollectionTable(name="PROFILE")
     private Set<Integer> profiles = new HashSet<>();

    public Users() {
        addProfile(Profile.CLIENT);
    }

    public Users(Integer idUsers, String name, List<String> foneUser, String password, String email, UserType type, boolean situation) {
        this.idUsers = idUsers;
        this.name = name;
        this.foneUser = foneUser;
        this.password = password;
        this.email = email;
        this.type = (type == null) ? null : type.getCod();
        this.situation = situation;
        addProfile(Profile.CLIENT);
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Set<Profile> getProfile(){
        return profiles.stream().map(x -> Profile.toEnum(x)).collect(Collectors.toSet());
    }
    
    public void addProfile(Profile Profile) {
		profiles.add(Profile.getCod());
	}

    public boolean getSituation() {
        return situation;
    }

    public void setSituation(boolean situation) {
        this.situation = situation;
    }


    public List<String> getFoneUser() {
        return foneUser;
    }

    public void setFoneUser(List<String> foneUser) {
        this.foneUser = foneUser;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Users)) return false;
        if (!super.equals(object)) return false;
        Users users = (Users) object;
        return idUsers.equals(users.idUsers);
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), idUsers);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Users{" +
                "idUsers=" + idUsers +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                ", situation=" + situation +
                '}';
    }
}
   