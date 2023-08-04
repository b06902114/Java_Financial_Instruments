package Esun.demo.repository;

import Esun.demo.model.FavoriteList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteListRepository extends CrudRepository<FavoriteList, Long> {

    @Query(value = "CALL getListsById(?)", nativeQuery = true)
    public List<FavoriteList> getPersonalList(String id);


    @Query(value = "CALL deleteListBySn(?)", nativeQuery = true)
    public void deleteListBySn(String sn);

}
