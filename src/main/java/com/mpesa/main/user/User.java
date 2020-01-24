package com.mpesa.main.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
    
    @Column(name="firstname")
    @Size(min=3,max=14)
    @NotNull
    private String firstName;
    
    @Column(name = "secondname")
    @Size(min = 3,max = 14)
    @NotNull
    private String secondName;
    
    @Column(name = "thirdname")
    @Size(min = 3,max = 14)
    @NotNull
    private String thirdName;
    
    @Column(name = "id")
    @Size(min = 7,max = 8)
    @Id
    private int idNumber;
    
    @Column(name = "phone", length = 10)
    @NotNull
    @NotBlank
    private int phoneNumber;
    
    @Column(name = "password")
    @NotNull
    @Size(min = 4, max = 255)
    private String password;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Role role;

    public User(String firstName, String secondName, String thirdName, int idNumber, int phoneNumber, String password, Role role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public User(int idNumber, String password) {
        this.idNumber = idNumber;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
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
