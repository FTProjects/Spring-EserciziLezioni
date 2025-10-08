package com.example.demo_REST_user_service.model.dto;

// Un record è una data class di oggetti immutabili

/**
 * Un record è una data class di oggetti immutabili
 *
 * @param name    Il nome dell'utente.
 * @param surname Il cognome dell'utente.
 * @param email   L'email dell'utente.
 */
public record User( // il costruttore del record User
                    String name,    // la proprietà del record user
                    String surname, // la proprietà del record user
                    String email    // la proprietà del record user
) {

    /**
     * Validatore del Costruttore per il record User
     * Valida che i campi non siano nulli o vuoti
     * @throws IllegalArgumentException se uno dei campi è nullo o vuoto
     */
    public User {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null!");
        if (surname == null || surname.isBlank())
            throw new IllegalArgumentException("Surname cannot be null!");
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("Email cannot be null!");
    }
}
