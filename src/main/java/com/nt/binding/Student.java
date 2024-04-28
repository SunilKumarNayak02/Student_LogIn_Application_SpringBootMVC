package com.nt.binding;

import lombok.Data;

@Data
public class Student {

	  private Integer sid;
	  private String name;
	  private String email;
	  private String gender;
	  private String course;
		/*
		 * timing is a array coz user can select multiple timings(morning as well as
		 * Evening) so to represent more than one value for one field we are going to
		 * use String array concept
		 */
	  private String[] timings;  // save more than select one value
	  
		/* we can print the data by using toString method  i am using Lombok Api so no need to write it is automatically taken*/
}
