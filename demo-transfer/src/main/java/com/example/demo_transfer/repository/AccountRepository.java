package com.example.demo_transfer.repository;

import com.example.demo_transfer.model.entity.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

// estendendo CrudRepository chiediamo al framework di
// costruirci dei metodi di base (pronti per l'uso) per le
// operazioni di CRUD classiche

// CRUDRepository<T, U>
//dove T è il tipo di entity che il repo gestisce
// e U è il tipo dell'id (primary key) di questa entity
public interface AccountRepository extends CrudRepository<Account, Long> {

    // none serve implementare l'interfaccia, basta solo dichiarare i metodi
    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findAccountsByName(String name);

    @Modifying // fa usare update a jdbc. Senza, userebbe query.
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void changeAmount(long id, BigDecimal amount);
}
