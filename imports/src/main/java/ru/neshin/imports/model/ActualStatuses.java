package ru.neshin.imports.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ActualStatuses {
    @Id
    private Long ActualStatusId;
    private String Name;


    public ActualStatuses(Long actualStatusId, String name) {
        ActualStatusId = actualStatusId;
        Name = name;
    }

    public ActualStatuses() {
    }

    public Long getActualStatusId() {
        return ActualStatusId;
    }

    public void setActualStatusId(Long actualStatusId) {
        ActualStatusId = actualStatusId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
