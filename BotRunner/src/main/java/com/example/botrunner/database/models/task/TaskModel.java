package com.example.botrunner.database.models.task;

import com.example.botrunner.database.models.RoutineModel;
import com.example.botrunner.database.models.enumerations.TaskType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
public abstract class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "routine_id")
    private RoutineModel routine;

    @Transient
    public abstract TaskType getTaskType();
}
