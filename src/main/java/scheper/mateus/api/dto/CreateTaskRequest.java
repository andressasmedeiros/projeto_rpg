package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.TaskType;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class CreateTaskRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Task name is required.")
    @Size(max = 360, message = "Task name must be at most 360 characters.")
    @Schema(description = "The name of the task.", example = "Clean the house")
    private String name;

    @Schema(description = "The description of the task.", example = "Clean the living room and kitchen")
    private String description;

    @NotNull(message = "Task type is required.")
    @Schema(description = "The type of the task.", example = "SIMPLE")
    private TaskType type;
}
