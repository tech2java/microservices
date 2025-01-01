package com.tech2java.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
public class BaseEntity {

    //while updating ignore these fields
    @Column(updatable = false)
    private LocalDateTime createdAt;
    private String createdBy;

    //while inserting ignore these fields
    @Column(insertable = false)
    private LocalDateTime updatedAt;
    private String updatedBy;


}
