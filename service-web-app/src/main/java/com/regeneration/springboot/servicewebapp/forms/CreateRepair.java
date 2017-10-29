package com.regeneration.springboot.servicewebapp.forms;

import com.regeneration.springboot.servicewebapp.model.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.Date;

public class CreateRepair {


    private static final String TYPE_PATTERN="^[a-zA-Z ]*$";
    private static final String DESCRIPTION_PATTERN="^[a-zA-Z ]*$";
    private static final String STATUS_PATTERN="^[a-zA-Z ]*$";


    private Long userId;

    private Long id;

    @Pattern(regexp = TYPE_PATTERN, message="{register.type.invalid}")
    private String type;

    @Pattern(regexp = DESCRIPTION_PATTERN, message="{register.description.invalid}")
    private String description;

    private double cost;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime arriveDate;

    @Pattern(regexp = STATUS_PATTERN, message="{register.status.invalid}")
    private String status;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public LocalDateTime getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(LocalDateTime arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserRegistration{" +
                "type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", cost='" + cost + '\'' +
                ", arriveDate='" + arriveDate + '\'' +
                '}';
    }


}




