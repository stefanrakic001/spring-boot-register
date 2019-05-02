package com.codecool.springbootregister.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "_users")
@Data
@NoArgsConstructor
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "user_id", unique = true)
private long id;

    @NotBlank
    @Size(min = 4,max = 20)
    private String username;

    @NotBlank
    @JsonIgnore
    @Size(min = 8)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User(@NotBlank @Size(min = 4, max = 20) String username, @NotBlank @Size(min = 8) String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }


}
