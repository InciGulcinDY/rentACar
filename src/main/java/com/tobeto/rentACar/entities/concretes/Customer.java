package com.tobeto.rentACar.entities.concretes;

import com.tobeto.rentACar.entities.abstracts.Person;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.cert.CertPathBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customers")
@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@Builder

public class Customer implements UserDetails {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "licence_issue_date")
    private LocalDateTime licenceIssueDate;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "driver_licence_type_id")
    private DriverLicenceType driverLicenceType;

    @OneToMany(mappedBy = "customer")
    private List<Rent> rents;

    @Enumerated(EnumType.STRING)
    private  Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Column(name = "birthday")
    private LocalDateTime birthday;
    @Column(name = "international_id")
    private String internationalId;

    @Transient
    private transient Integer age = getAge(birthday);

    public  Integer getAge(LocalDateTime birthday){
        if (birthday == null){
            return null;
        }
        LocalDate currentDate = LocalDate.now();
        return Period.between(LocalDate.from(birthday), currentDate).getYears();
    }
}
