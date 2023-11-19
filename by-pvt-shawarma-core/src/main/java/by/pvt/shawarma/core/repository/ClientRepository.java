package by.pvt.shawarma.core.repository;

import by.pvt.shawarma.core.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.login=:login and c.password=:password")
    Client authorise(@Param("login") String login, @Param("password") String password);

    @Query("select c from Client c where c.login=:login")
    Client loadUserByUserName(@Param("login") String login);
}
