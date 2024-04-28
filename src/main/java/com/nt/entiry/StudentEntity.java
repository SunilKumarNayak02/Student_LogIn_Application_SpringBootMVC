package com.nt.entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentEntity {
	@Id
	@GeneratedValue
  private Integer sid;
  private String name;
  private String email;
  private String gender;
  private String course;
  private String timings; 
}
