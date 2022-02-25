package com.kerjox.bloque6rubrica4.services;

import com.kerjox.bloque6rubrica4.entities.Comment;
import com.kerjox.bloque6rubrica4.entities.Ticket;
import com.kerjox.bloque6rubrica4.repos.CommentRepository;
import com.kerjox.bloque6rubrica4.repos.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	// --------------------------------------------
	// CRUD OPERATIONS FOR PARENT RECORDS (TICKETS)

	public Ticket createTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	public List findAll() {
		return ticketRepository.findAll();
	}

	public Ticket findTicket(long id) {
		return ticketRepository.getById(id);
	}

	public Ticket updateTicket(long id, Ticket ticket) {
		Ticket updatedTicket = findTicket(id);
		if (!ticket.getDescription().equals(updatedTicket.getDescription())) {
			updatedTicket.setDescription(ticket.getDescription());
			return ticketRepository.save(updatedTicket);
		} else
			return null;
	}

	public void deleteById(long id) {
		Ticket ticket = ticketRepository.getById(id);
		ticketRepository.delete(ticket);
	}

	@Autowired
	private CommentRepository commentRepository;

	// --------------------------------------------
	// CRUD OPERATIONS FOR CHILD RECORDS (COMMENTS)

	public Ticket createComment(long ticketId, Comment comment) {
		Ticket ticket = findTicket(ticketId);
		comment.setTicket(ticket);
		ticket.getComments().add(comment);

		return ticketRepository.save(ticket);
	}

	public List findAllComments(long ticketId) {
		return findTicket(ticketId).getComments();
	}

	public Comment findComment(long id) {
		return commentRepository.getById(id);
	}

	public Comment updateComment(long commentId, Comment comment) {
		Comment savedComment = commentRepository.getById(commentId);
		savedComment.setText(comment.getText());
		commentRepository.save(savedComment);
		return savedComment;
	}

	public void deleteCommentById(long id) {
		Comment comment = commentRepository.getById(id);
		commentRepository.delete(comment);
	}
}
