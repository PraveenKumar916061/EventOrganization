package com.img.Event_organization.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table
public class PlayerImage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_id")
    @SequenceGenerator(name = "seq_id",sequenceName = "seq_id",initialValue = 1)
    private Long imageId;
    private String filename;
    private String filetype;
    private String filepath;
}
