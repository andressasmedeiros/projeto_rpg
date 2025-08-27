package scheper.mateus.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.StatusType;

@Entity
@Getter
@Setter
@Table(schema = User.BASE_SCHEMA, name = "status")
public class Status {

    @Id
    @GeneratedValue(generator = "status_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = User.BASE_SCHEMA,
            name = "status_id_seq",
            sequenceName = User.BASE_SCHEMA + ".status_id_seq",
            allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", unique = true)
    private Character currentCharacter;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusType type;

    @NotNull
    @Min(0)
    @Column(nullable = false)
    private Integer value;
}
