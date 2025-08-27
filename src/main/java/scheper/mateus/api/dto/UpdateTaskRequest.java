package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.TaskType;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class UpdateTaskRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Size(max = 360, message = "Task name must be at most 360 characters.")
    @Schema(description = "The updated name of the task.", example = "Clean the house")
    private String name;

    @Schema(description = "The updated description of the task.", example = "Clean the living room and kitchen")
    private String description;

    @Schema(description = "The updated type of the task.", example = "MULTIPLE")
    private TaskType type;

    @Schema(description = "Indicates whether the task is finished.", example = "true")
    private Boolean finished;
}
