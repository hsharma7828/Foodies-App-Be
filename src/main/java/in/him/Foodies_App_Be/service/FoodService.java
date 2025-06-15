package in.him.Foodies_App_Be.service;

import in.him.Foodies_App_Be.io.FoodRequest;
import in.him.Foodies_App_Be.io.FoodResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FoodService {

    String upLoadFile(MultipartFile file);

    FoodResponse addFood(FoodRequest request, MultipartFile file);

    List<FoodResponse> readFoods();

    FoodResponse readFood(String id);

    boolean deleteFile(String filename);

    void deletFood(String id);
}
