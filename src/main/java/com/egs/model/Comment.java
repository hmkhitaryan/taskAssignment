package com.egs.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Hayk_Mkhitaryan
 */
@Entity
@Table(name = "COMMENT")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "TASK_ID")
    private Task task;

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;

    private Date dateCreated;

}
