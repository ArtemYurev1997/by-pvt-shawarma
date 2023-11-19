package by.pvt.shawarma.core.repository;

import by.pvt.shawarma.core.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    @Query("select a from Admin a where a.login=:login and a.password=:password")
    Admin authorise(@Param("login") String login, @Param("password") String password);

    @Query("select a from Admin a where a.login=:login")
    Admin loadUserByUserName(@Param("login") String login);
}
