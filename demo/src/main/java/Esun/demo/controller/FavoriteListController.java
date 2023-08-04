package Esun.demo.controller;


import Esun.demo.model.FavoriteList;
import Esun.demo.repository.FavoriteListRepository;
import Esun.demo.service.FavoriteListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class FavoriteListController {

    @Autowired
    private FavoriteListService favoriteListService;

    // Add list
    @PostMapping("/add_list")
    public FavoriteList addFavoriteList(@RequestBody FavoriteList favoriteList){
        return favoriteListService.addFavoriteList(favoriteList);
    }

    // Query
    // This variable id is "num" column in table
    @GetMapping("/list/{id}")
    public FavoriteList getFavoriteListById(@PathVariable("id") Long id){
        return favoriteListService.getFavoriteListById(id);
    }

    // Find ALL
    @GetMapping("/lists")
    public List<FavoriteList> getFavoriteLists(){
        return favoriteListService.getFavoriteLists();
    }

    // Update
    @PutMapping("/list_update")
    public FavoriteList updateFavoriteList(@RequestBody FavoriteList favoriteList){
        return favoriteListService.updateFavoriteList(favoriteList);
    }

    // Delete
    @DeleteMapping("/list/{id}")
    public void deleteFavoriteList(@PathVariable("id") Long id){
        favoriteListService.deleteFavoriteList(id);
    }

    // get User's Favorite List By Id. Using Stored Procedure
    // This variable id is "id" column in table
    @RequestMapping("/lists/procedure/{id}")
    public List<FavoriteList> getPersonalList(@PathVariable("id") String id){
        return favoriteListService.getPersonalList(id);
    }

    // Delete List By Sn if ADMIN delete some product
    @DeleteMapping("delete/procedure/{sn}")
    public void deleteListBysn(@PathVariable("sn") String sn){
        favoriteListService.deleteListBySn(sn);
    }

}
