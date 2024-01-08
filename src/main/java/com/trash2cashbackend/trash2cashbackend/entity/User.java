package com.trash2cashbackend.trash2cashbackend.entity;

import com.trash2cashbackend.trash2cashbackend.entity.enums.GenderType;
import com.trash2cashbackend.trash2cashbackend.entity.enums.RoleEnum;
import com.trash2cashbackend.trash2cashbackend.entity.enums.StatusEnum;
import com.trash2cashbackend.trash2cashbackend.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String username;
    private String profile_image;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Date dob;

    //gender ENUM('M', 'F', 'Other'),
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    private int mobile_number;
    private int landline;

    //user_type ENUM('Staff', 'User', ‘Driver’),
    @Enumerated(EnumType.STRING)
    private UserType user_type;

    // role ENUM('admin', 'manager', 'staff', 'user'),
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    // status ENUM('active', 'disabled'),
    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private boolean verified;
    private String created_at;
    private String updated_at;





}
