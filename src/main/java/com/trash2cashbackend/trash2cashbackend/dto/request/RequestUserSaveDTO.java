package com.trash2cashbackend.trash2cashbackend.dto.request;

import com.trash2cashbackend.trash2cashbackend.entity.enums.GenderType;
import com.trash2cashbackend.trash2cashbackend.entity.enums.RoleEnum;
import com.trash2cashbackend.trash2cashbackend.entity.enums.StatusEnum;
import com.trash2cashbackend.trash2cashbackend.entity.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestUserSaveDTO {
    private int user_id;
    private String username;
    private String profile_image;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private Date dob;
    private GenderType gender;   //gender ENUM('M', 'F', 'Other'),
    private int mobile_number;
    private int landline;
    private UserType user_type;    //user_type ENUM('Staff', 'User', ‘Driver’),
    private RoleEnum role;         // role ENUM('admin', 'manager', 'staff', 'user'),
    private StatusEnum status;        // status ENUM('active', 'disabled'),
    private boolean verified;
    private String created_at;
    private String updated_at;
}
