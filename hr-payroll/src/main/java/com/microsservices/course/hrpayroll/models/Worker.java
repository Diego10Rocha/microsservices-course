package com.microsservices.course.hrpayroll.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Worker implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Double dailyIncome;
	@Override
	public int hashCode() {
		return Objects.hash(dailyIncome, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(dailyIncome, other.dailyIncome) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	

}
