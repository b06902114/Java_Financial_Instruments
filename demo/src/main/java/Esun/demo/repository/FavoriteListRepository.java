package Esun.demo.repository;

import Esun.demo.model.FavoriteList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteListRepository extends CrudRepository<FavoriteList, Long> {
}
