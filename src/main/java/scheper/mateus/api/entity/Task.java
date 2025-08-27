package scheper.mateus.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.TaskType;

@Entity
@Getter
@Setter
@Table(schema = Task.BASE_SCHEMA, name = "task")
public class Task {

    public static final String BASE_SCHEMA = "base";

    @Id
    @GeneratedValue(generator = "task_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            schema = BASE_SCHEMA,
            name = "task_id_seq",
            sequenceName = BASE_SCHEMA + ".task_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 360)
    private String name;

    @Lob
    @Column(columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TaskType type;

    @Column(nullable = false)
    private boolean finished = false;
}
