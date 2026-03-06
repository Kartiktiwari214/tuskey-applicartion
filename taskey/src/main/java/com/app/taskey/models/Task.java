package com.app.taskey.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Task {
    @Id
      @GeneratedValue (strategy  = GenerationType.AUTO)
    private  long id;
    private  String title;
    private boolean completed;

}
