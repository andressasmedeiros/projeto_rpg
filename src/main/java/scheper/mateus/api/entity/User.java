package scheper.mateus.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import scheper.mateus.api.dto.UserResponse;
import scheper.mateus.api.enums.ProviderEnum;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(schema = User.BASE_SCHEMA, name = "users")
public class User {

    public static final String BASE_SCHEMA = "base";

    @Id
    @GeneratedValue(generator = "user_id_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            schema = BASE_SCHEMA,
            name = "user_id_seq",
            sequenceName = BASE_SCHEMA + ".user_id_seq",
            allocationSize = 1
    )
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", unique = true)
    private Character currentCharacter;

    @Column(nullable = false, length = 360)
    private String name;

    @Column(nullable = false)
    private boolean active = true;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserInformation> userInformations = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @SQLRestriction("finished = false")
    private List<Task> currentTasks = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @SQLRestriction("finished = true")
    private List<Task> finishedTasks = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = BASE_SCHEMA, name = "users_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(schema = BASE_SCHEMA, name = "users_rule",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rule_id"))
    private List<Rule> rules = new ArrayList<>();

    public String getLocalEmail() {
        return userInformations
                .stream()
                .filter(provider -> provider.getProvider().equals(ProviderEnum.LOCAL))
                .findFirst()
                .map(UserInformation::getEmail)
                .orElse(null);
    }

    public String getPassword() {
        return userInformations
                .stream()
                .filter(provider -> provider.getProvider().equals(ProviderEnum.LOCAL))
                .findFirst()
                .map(UserInformation::getPassword)
                .orElse(null);
    }

    public boolean hasLocalInformation() {
        return userInformations
                .stream()
                .anyMatch(provider -> provider.getProvider().equals(ProviderEnum.LOCAL));
    }

    public UserResponse asResponse() {
        UserResponse response = new UserResponse();
        response.setId(id);
        response.setName(name);
        response.setActive(active);
        response.setEmail(getLocalEmail());
        response.setRoles(roles.stream().map(Role::getName).toList());
        response.setCurrentCharacterId( currentCharacter != null ? currentCharacter.getId() : null );
        return response;
    }
}
