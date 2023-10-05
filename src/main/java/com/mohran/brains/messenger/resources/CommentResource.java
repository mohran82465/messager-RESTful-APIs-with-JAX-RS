package com.mohran.brains.messenger.resources;

import java.util.List;

import com.mohran.brains.messenger.model.Comment;
import com.mohran.brains.messenger.service.CommentService;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
	private CommentService commentService= new CommentService();
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId)
	{
		return commentService.getAllComment(messageId);
	}
	@POST
	public Comment addMessage(@PathParam("messageId") long messageId, Comment comment)
	{
		return commentService.addComment(messageId, comment);
	}
	@PUT
	@Path("/{commentId}")
	public Comment updateMessage(@PathParam("messageId")long messageId,@PathParam("commentId") long id,Comment comment)
	{
		comment.setId(id);
		return commentService.updateComment(messageId, comment);
	}
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId)
	{
		commentService.removeComment(messageId, commentId);
	}
}
