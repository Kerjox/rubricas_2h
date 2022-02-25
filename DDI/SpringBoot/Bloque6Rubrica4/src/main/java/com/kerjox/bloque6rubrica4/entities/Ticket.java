package com.kerjox.bloque6rubrica4.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="TICKET_ID")
	private Long ticketId;

	private String description;

	@OneToMany(mappedBy="ticket", cascade=CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
}
