package com.aequalis.company.teamleader.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Team_Leater")
public class TlDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer teamLeadeId;
    @Column(name = "team_leader_name")
    private String teamLeaderName;
    @Column(name = "email_id")
    private String emailId;
    @Column(name = "age")
    private Integer age;
    @Column(name = "office_name")
    private String officeName;
    @Column(name = "country")
    private String country;
    @Column(name = "state")
    private String state;
    @Column(name = "district")
    private String district;
    @Column(name = "village")
    private String village;
    @Column(name = "pin_code")
    private Integer pincode;


}
