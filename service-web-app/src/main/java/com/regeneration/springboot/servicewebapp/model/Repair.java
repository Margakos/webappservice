package com.regeneration.springboot.servicewebapp.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="repair")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="type")
    private String type;

    @Column(name="description")
    private String description;

    @Column(name="cost")
    private float cost;

    @Column(name="dateOfArrive")
    private Date arriveDate;

    @Column(name="status")
    private String status;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,
                CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User user;

    public Repair() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", arriveDate=" + arriveDate +
                ", status='" + status + '\'' +
                '}';
    }
}
