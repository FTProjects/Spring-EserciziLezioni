package proxy;

import model.Comment;

public interface CommentNotificationProxy {

    void sendNotification(Comment comment);

}
