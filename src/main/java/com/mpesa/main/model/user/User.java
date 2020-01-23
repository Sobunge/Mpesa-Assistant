package com.mpesa.main.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(name = "user")
@Entity
public class User {
    
    @NotNull
    @Size(min=3, max=14, message = "First name should contain atleast 3 to 14 characters")
    @Column(name = "firstname")
    private String firstname;
    
    @NotNull
    @Size(min=3, max=14, message = "Second name should contain atleast 3 to 14 characters")
    @Column(name = "secondname")
    private String secondname;
    
    @NotNull
    @Size(min=3, max=14, message = "Third name should contain atleast 3 to 14 characters")
    @Column(name = "thirdname")
    private String thirdname;
    
    @Id
    @Size(min=7, max=8, message = "Id number should contain atleast 3 to 14 characters")
    @Column(name = "id")
    private int idNumber;
    
    @NotNull
    @Column(name = "phonenumber", length = 10)
    private int phoneNumber;
    
    @NotNull
    @Size(min=3, max=22, message = "Password should contain atleast 3 to 22 characters")
    @Column(name = "password")
    private String password;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Role role;

    public User(int idNumber, String password) {
        this.idNumber = idNumber;
        this.password = password;
    }

    public User(String firstname, String secondname, String thirdname, int idNumber, int phoneNumber, String password, Role role) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.thirdname = thirdname;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    
    
}
