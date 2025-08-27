package scheper.mateus.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(schema = User.BASE_SCHEMA, name = "equipment")
public class Equipment {

    @Id
    @GeneratedValue(generator = "equipment_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(schema = User.BASE_SCHEMA,
            name = "equipment_id_seq",
            sequenceName = User.BASE_SCHEMA + ".equipment_id_seq",
            allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "helmet_id")     // opcional; remova nullable=false se for obrigatório
    private Item helmet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "armor_id")
    private Item armor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "legs_id")
    private Item legs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boots_id")
    private Item boots;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_id")
    private Item weapon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shield_id")
    private Item shield;
}
