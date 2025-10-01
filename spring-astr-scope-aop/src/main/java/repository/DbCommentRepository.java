package repository;

import model.Comment;
import org.springframework.stereotype.Repository;

@Repository // Indica a spring che questo è un repository e un bean di questo tipo verrà registrato nel context
public class DbCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        // facciamo finta di salvare un commento sul db
        System.out.println("> Salvataggio del commento: " + comment.getText());
    }
}
