package com.aweb.todo_list.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
//import lombok.ToString;

@NoArgsConstructor 
@AllArgsConstructor 
@Entity 
@Data 
//@EqualsAndHashCode(of = "id")
//@ToString 
public class Todo {
    
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column (length = 100, nullable = false)
    private String title;

    @Column(nullable= false)
    private LocalDateTime createAt = LocalDateTime.now();

    @Column(nullable= false)
    private LocalDateTime deadline;
    
    @Column(nullable= true)
    private LocalDateTime finiishedAt;

}
