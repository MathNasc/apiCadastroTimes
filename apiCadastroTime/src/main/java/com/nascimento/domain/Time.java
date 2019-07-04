package com.nascimento.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Time {
	
	@Id
	private Integer teamId;
	private String name;
	private String color;
	private Integer fundation_year;
	private String stadium;
	private String coach;
	private String twisted_organized;
	
	
	public Integer getTeamId() {
		return teamId;
	}
	
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Integer getFundation_year() {
		return fundation_year;
	}
	
	public void setFundation_year(Integer fundation_year) {
		this.fundation_year = fundation_year;
	}
	
	public String getStadium() {
		return stadium;
	}
	
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	
	public String getCoach() {
		return coach;
	}
	
	public void setCoach(String coach) {
		this.coach = coach;
	}
	
	public String getTwisted_organized() {
		return twisted_organized;
	}
	
	public void setTwisted_organized(String twisted_organized) {
		this.twisted_organized = twisted_organized;
	}
}
