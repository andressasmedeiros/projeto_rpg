package scheper.mateus.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.TaskType;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class TaskResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "The unique identifier of the task.", example = "1001")
    private Long id;

    @Schema(description = "The name of the task.", example = "Clean the house")
    private String name;

    @Schema(description = "The description of the task.", example = "Clean the living room and kitchen")
    private String description;

    @Schema(description = "The type of the task.", example = "SIMPLE")
    private TaskType type;

    @Schema(description = "Indicates whether the task is finished.", example = "false")
    private boolean finished;
}
