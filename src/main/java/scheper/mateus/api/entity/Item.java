package scheper.mateus.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import scheper.mateus.api.enums.ItemType;


@Entity
@Getter
@Setter
@Table(schema = User.BASE_SCHEMA, name = "item")
public class Item {

    @Id
    @GeneratedValue(generator = "item_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = User.BASE_SCHEMA,
            name = "item_id_seq",
            sequenceName = User.BASE_SCHEMA + ".item_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(nullable = false, length = 24)
    private String name;

    @Lob
    @Column(columnDefinition = "text")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ItemType type;

    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer value;
}
