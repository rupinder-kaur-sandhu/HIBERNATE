package com.uttara.hib;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_song")
public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	private double duration;
	private int rating;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dor;
	
	public Song() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Song(String title, double duration, int rating, Date dor) {
		super();
		this.title = title;
		this.duration = duration;
		this.rating = rating;
		this.dor = new Date(dor.getTime());
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getDor() {
		return new Date(dor.getTime());
	}

	public void setDor(Date dor) {
		this.dor = new Date(dor.getTime());
	}

	


	public Long getId() {
		return id;
	}



	private void setId(Long id) {
		this.id = id;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dor == null) ? 0 : dor.hashCode());
		long temp;
		temp = Double.doubleToLongBits(duration);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rating;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (dor == null) {
			if (other.dor != null)
				return false;
		} else if (!dor.equals(other.dor))
			return false;
		if (Double.doubleToLongBits(duration) != Double.doubleToLongBits(other.duration))
			return false;
		if (rating != other.rating)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Song [title=" + title + ", duration=" + duration + ", rating=" + rating + ", dor=" + dor + "]";
	}
	
	

}
