package com.regeneration.springboot.servicewebapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "userId")
        private Long userId;


        @Column(name="afm")
        private String afm;

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

        @Column(name="role")
        private String role;

        @Column(name="plates")
        private String plates;

        @OneToMany(targetEntity = Repair.class,mappedBy = "user",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
        private List<Repair> repairs;


        public User() {
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getAfm() {
            return afm;
        }

        public void setAfm(String afm) {
            this.afm = afm;
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

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public List<Repair> getRepairs() {
            return repairs;
        }

        public void setRepairs(List<Repair> repairs) {
            this.repairs = repairs;
        }

        public String getPlates() {
            return plates;
        }

        public void setPlates(String plates) {
            this.plates = plates;
        }

        public void add(Repair repair){


            if(repairs==null){

                repairs=new ArrayList<>();
            }
            repairs.add(repair);
            repair.setUser(this);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + userId +
                    ", afm='" + afm + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", email='" + email + '\'' +
                    ", address='" + address + '\'' +
                    ", password='" + password + '\'' +
                    ", role='" + role + '\'' +
                    ", plates='" + plates + '\'' +
                    ", repairs=" + repairs +
                    '}';
        }
    }
