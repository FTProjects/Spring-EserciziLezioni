package repository;

import model.Comment;

// Astrazione (un contratto) per il repository dei commenti
// Definisce cosa deve essere fatto (salvare un commento), ma non COME
public interface CommentRepository {

    void storeComment(Comment comment);


}
