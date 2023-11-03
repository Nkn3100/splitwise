package com.scaler.splitwise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "SPLITWISE_USER")
@Builder
public class User extends BaseModel{
    private String name;
    private String email;
    private String phoneNumber;
    @ManyToMany
    private List<Group> groups;
}
