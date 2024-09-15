package com.dulfinne.library_service.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "book_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames = true)
public class Book {
	
	@Id
	private Long id;
	
	@Column(name = "status")
    @Enumerated(EnumType.STRING)  
	private Status status;
	
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<BookRental> rentals;
}
