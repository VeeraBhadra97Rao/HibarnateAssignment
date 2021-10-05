package com.technoelevate.CruddOperation;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student implements Serializable {
	@Id
private Integer rollno;
private String name;
private Long phno;
private String standard;
}
