package com.kerjox.bloque6rubrica4.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="COMMENT_ID")
	private Long commentId;

	private String text;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TICKET_ID")
	@JsonIgnore
	private Ticket ticket;
}
