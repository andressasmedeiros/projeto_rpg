package scheper.mateus.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(schema = User.BASE_SCHEMA, name = "rule")
public class Rule {

    @Id
    @GeneratedValue(generator = "rule_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            schema = User.BASE_SCHEMA,
            name = "rule_id_seq",
            sequenceName = User.BASE_SCHEMA + ".rule_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(nullable = false, unique = true, length = 360)
    private String name;
}
