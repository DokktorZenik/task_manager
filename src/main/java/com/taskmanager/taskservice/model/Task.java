package com.taskmanager.taskservice.model;


import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Date;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long organisation_id;

    private Long project_id;

    private String title;

    private String priority;

    private String status;

    private String estimate;

    @JdbcTypeCode(SqlTypes.JSON)
    private List<JsonNode> tags;

    private Integer progress;

    private Long timestamp;

    private Date start_date;

    private Date end_date;

    private Long assignee_id;

    private Long created_by;

}
