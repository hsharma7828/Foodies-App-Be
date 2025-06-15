package in.him.Foodies_App_Be.io;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodResponse {
    @Id
    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private double price;
    private String category;
}
