package service;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proxy.CommentNotificationProxy;
import repository.CommentRepository;

// Annotazione stereotype che indica che questa è una classe di business logic
// permette di fornire un bean di questo tipo al contesto
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    private final CommentNotificationProxy commentNotificationProxy;

    // Iniettiamo le dipendenze di service tramite un costruttore annotato con @Autowired
    @Autowired
    public CommentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy) {

        this.commentNotificationProxy = commentNotificationProxy;
        this.commentRepository = commentRepository;
    }

    public void publishComment(Comment comment) {
        // la logica di business che orchestra le chiamate al repository e al proxy
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendNotification(comment);
    }
}
