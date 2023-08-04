package Esun.demo.service.Impl;

import Esun.demo.model.FavoriteList;
import Esun.demo.model.User;
import Esun.demo.repository.FavoriteListRepository;
import Esun.demo.service.FavoriteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteListServiceImpl implements FavoriteListService {


    @Autowired
    private FavoriteListRepository favoriteListRepository;

    // Add List
    @Override
    public FavoriteList addFavoriteList(FavoriteList favoriteList) {
            return favoriteListRepository.save(favoriteList);
    }

    // Query By ID
    @Override
    public FavoriteList getFavoriteListById(Long id) {
        return favoriteListRepository.findById(id).get();
    }


    // Find All
    @Override
    public List<FavoriteList> getFavoriteLists() {
        return (List<FavoriteList>) favoriteListRepository.findAll();
    }

    // Delete List
    @Override
    public void deleteFavoriteList(Long id) {
        favoriteListRepository.deleteById(id);
    }


    // Update List
    @Override
    public FavoriteList updateFavoriteList(FavoriteList favoriteList) {
        return favoriteListRepository.save(favoriteList);
    }

    @Override
    public List<FavoriteList> getPersonalList(String id){
        return favoriteListRepository.getPersonalList(id);
    }
}
