package com.regeneration.springboot.servicewebapp.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CreateUser {

        private static final String CHARACTERS_PATTERN = "^[a-zA-Z ]*$";
        private static final String PASSWORD_PATTERN = "^[a-zA-Z0-9@#$%^&]*$";
        private static final int PASSWORD_MIN = 8;
        private static final String MAIL_PATTERN = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,63}$";
        private static final String AFM_PATTERN = "^[0-9]{9}";
        private static final String PLATES_PATTERN = "^[A-Z]{3}[-]{1}[0-9]{4}";


        @Pattern(regexp = CHARACTERS_PATTERN, message = "{register.firstName.invalid}")
        private String firstName;

        @Pattern(regexp = CHARACTERS_PATTERN, message = "{register.lastName.invalid}")
        private String lastName;

        @Pattern(regexp = PASSWORD_PATTERN, message = "{register.password.invalid}")
        @Size(min = PASSWORD_MIN, message = "{register.password.size}")
        private String password;

        @Pattern(regexp = MAIL_PATTERN, message = "{register.email.invalid}")
        private String email;

        @Pattern(regexp = AFM_PATTERN, message = "{register.afm.invalid}")
        private String afm;

        @Pattern(regexp = PLATES_PATTERN, message = "{register.plates.invalid}")
        private String plates;

        @Pattern(regexp = CHARACTERS_PATTERN, message = "{register.role.invalid}")
        private String role;


        private String address;

          private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

        public String getAfm() {
            return afm;
        }

        public void setAfm(String afm) {
            this.afm = afm;
        }

        public String getPlates() {
            return plates;
        }

        public void setPlates(String plates) {
            this.plates = plates;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }


        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "UserRegistration{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", password='" + password + '\'' +
                    ", email='" + email + '\'' +
                    ", afm='" + afm + '\'' +
                    ", plates='" + plates + '\'' +
                    ", address='" + address + '\'' +
                    '}';
        }
    }


