package com.chat.domain.model;

import java.util.*;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


@Entity(name = "User")
@Data
@Table(
    name = "users",
    uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
    }
)
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(
        name = "first_name",
        nullable = true,
        columnDefinition = "character varying",
        length = 100
    )
    private String firstname;

    @Column(
        name = "last_name",
        nullable = true,
        columnDefinition = "character varying",
        length = 100
    )
    private String lastname;

    @Column(
        name = "sex",
        columnDefinition = "character varying",
        length = 7
    )
    private String sex;

    @Column(
        name = "birthdate",
        columnDefinition = "date"
    )
    private Date birthdate;

    @Column(
        name = "avatar",
        columnDefinition = "text",
        length = 150
    )
    private String avatar;

    @Column(
        name = "created_at",
        columnDefinition = "timestamp without time zone",
        length = 6
    )
    private Date createdAt;

    @Column(
        name = "updated_at",
        columnDefinition = "timestamp without time zone",
        length = 6
    )
    @Nullable
    private Date updatedAt;
    
    @Column(
        name = "email",
        columnDefinition = "character varying",
        length = 100
    )
    private String email;

    @Column(
        name = "password",
        columnDefinition = "character varying",
        length = 16
    )
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Collection<Role> roles = new ArrayList();

    public User(UUID id, String firstname, String lastname, String sex, Date birthdate, String avatar, Date createdAt, Date updatedAt, String email, String password, Collection<Role> roles) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sex = sex;
        this.birthdate = birthdate;
        this.avatar = avatar;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
