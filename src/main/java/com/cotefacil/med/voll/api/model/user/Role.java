package com.cotefacil.med.voll.api.model.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Role")
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;
}
