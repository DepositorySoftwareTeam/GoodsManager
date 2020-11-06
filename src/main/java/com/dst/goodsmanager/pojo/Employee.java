package com.dst.goodsmanager.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    private int id;
    private String lastNAme;
    private String email;
    private int gender;
    private Department department;
    private Data birth;
}
