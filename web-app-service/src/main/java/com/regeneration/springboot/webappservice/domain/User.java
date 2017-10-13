package com.regeneration.springboot.webappservice.domain;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private String password;


    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name="vehiclePlates")
    private Vehicle vehicle;


    public User() {
    }

    public User( String firstName, String lastName, String email, String address, String password, Vehicle vehiclePlates) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.password = password;
        this.vehicle = vehiclePlates;
    }


    public Long getId() {
        return id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Vehicle getVehiclePlates() {
        return vehicle;
    }

    public void setVehiclePlates(Vehicle vehiclePlates) {
        this.vehicle = vehiclePlates;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", vehiclePlates='" + vehicle + '\'' +
                '}';
    }
}
