package main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.CommentService;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        // creo contesto di spring
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Recuperiamo dal context un bean di tipo Servizio

        CommentService cs1 = context.getBean(CommentService.class);
        CommentService cs2 = context.getBean(CommentService.class);
        System.out.println("Gli oggetti cs1 e cs2 sono uguali? " + (cs2 == cs1));

        // recuperiamo il bean UserService, che è un prototype
        UserService us1 = context.getBean((UserService.class));
        UserService us2 = context.getBean((UserService.class));
        System.out.println("Gli oggetti us1 e us2 sono uguali? " + (us2 == us1));

        // utilizziamo il servizio dei commenti
        Comment comment = new Comment();
        comment.setAuthor("Pippo");
        comment.setText("Questo è il commento di pippo");

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
