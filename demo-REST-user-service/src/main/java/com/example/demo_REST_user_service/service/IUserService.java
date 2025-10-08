package com.example.demo_REST_user_service.service;

import com.example.demo_REST_user_service.model.dto.User;

import java.util.List;

/**
 * Interfaccia per la gestione delle operazioni CRUD sugli Utenti
 */
public interface IUserService {

    // ***************** Read   -> get

    /**
     * Restituisce tutti gli utenti del sistema
     * @return Una lista di Users
     */
    List<User> getAllUsers();

    /**
     * Restituisce un utente dato il suo indirizzo email
     * @param email L'email dell'utente
     * @return L'utente corrispondente o null se non esiste
     */
    User getUserByEmail(String email);

    // ****************** Create -> post

    /**
     * Crea un nuovo utente
     * @param user L'utente da creare
     * @return L'utente creato o null se esiste già
     */
    User createUser(User user);


    // ****************** Update -> put/patch

    /**
     * Aggiorna utente esistente.
     * @param email L'email dell'utente da aggiornare
     * @param updateUser I dati aggiornati dell'utente
     * @return L'utente aggiornato o null se non esiste
     */
    User updateUser(String email, User updateUser);

    // ****************** Delete -> delete

    /**
     * Elimina un utente dato il suo indirizzo email
     * @param email L'email dell'utente da eliminare
     * @return TRUE se l'utente viene eliminato, FALSE altrimenti
     */
    boolean deleteUser(String email);

}
