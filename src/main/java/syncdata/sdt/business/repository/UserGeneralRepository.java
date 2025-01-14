package syncdata.sdt.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import syncdata.sdt.business.entities.UserGeneral;

import java.util.List;

@Repository
public interface UserGeneralRepository extends JpaRepository<UserGeneral,Long> {

    @Query("SELECT d FROM UserGeneral d WHERE LOWER(d.fullName) LIKE LOWER(CONCAT('%', :keyword,'%'))"
            + " AND  d.flag = 1")
    List<UserGeneral> getByUserName(@Param("keyword") String keyword);

    @Query("SELECT d FROM UserGeneral d WHERE LOWER(d.docIdentity) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<UserGeneral> getByDocIdentity(@Param("keyword") String keyword);

    @Query("SELECT d FROM UserGeneral d WHERE LOWER(d.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<UserGeneral> getByEmail(@Param("keyword") String keyword);


    @Query("SELECT d FROM UserGeneral d WHERE CAST(d.flag AS string) LIKE CONCAT('%', :keyword, '%') ")
    List<UserGeneral> getByFlag(@Param("keyword") String keyword);


}