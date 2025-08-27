package scheper.mateus.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(schema = User.BASE_SCHEMA, name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(generator = "inventory_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = User.BASE_SCHEMA,
            name = "inventory_id_seq",
            sequenceName = User.BASE_SCHEMA + ".inventory_id_seq",
            allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private Integer slots = 24;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            schema = "base",
            name = "inventory_item",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items = new ArrayList<>();
}
