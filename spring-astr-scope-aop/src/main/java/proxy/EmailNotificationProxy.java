package proxy;

import model.Comment;
import org.springframework.stereotype.Component;

// Implementazione della interfaccia CommentNotificationProxy
@Component // L'annotazione per componenti generica, per quando non ce n'è una specifica
public class EmailNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendNotification(Comment comment) {
        // fingiamo di mandare una email
        System.out.println("% Invio email con il commento: " + comment.getText());
    }
}
