package com.mpesa.main.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Column(name = "firstname")
    @Size(min = 3, max = 14, message = "Should be a minimum of 3 and a maximum of 14")
    @NotNull(message = "Must contain a value")
    private String firstName;

    @Column(name = "secondname")
    @Size(min = 3, max = 14, message = "Should be a minimum of 3 and a maximum of 14")
    @NotNull(message = "Must contain a value")
    private String secondName;

    @Column(name = "thirdname")
    @Size(min = 3, max = 14, message = "Should be a minimum of 3 and a maximum of 14")
    @NotNull(message = "Must contain a value")
    private String thirdName;

    @NotNull(message = "Must contain a value")
    @Column(name = "id_number")
    @Digits(integer = 8, fraction = 0)
    @Id
    private int idNumber;

    @Column(name = "phone", length = 10)
    @NotNull(message = "Must contain a value")
    private int phoneNumber;

    @Column(name = "password")
    @NotNull(message = "Must contain a value")
    @Size(min = 4, max = 255)
    private String password;

    @Transient
    private String confirmPassword;

    @JsonBackReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Role> role;

    public User(String firstName, String secondName, String thirdName, int idNumber, int phoneNumber, String password, List<Role> role) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.idNumber = idNumber;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public User() {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

}
