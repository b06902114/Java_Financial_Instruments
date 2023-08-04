package Esun.demo.service;

import Esun.demo.model.FavoriteList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoriteListService {
    public FavoriteList addFavoriteList(FavoriteList favoriteList);

    public FavoriteList getFavoriteListById(Long id);
    public List<FavoriteList> getFavoriteLists();

    public void deleteFavoriteList(Long id);

    public FavoriteList updateFavoriteList(FavoriteList favoriteList);

    public List<FavoriteList> getPersonalList(String id);
}
