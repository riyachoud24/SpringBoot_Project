import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

@Service //defines the class as a Spring service component
public class ClothingService {

    //Logger for logging messages
    private static final Logger logger = LoggerFactory.getLogger(ClothingService.class);
    private final ClothingRepository clothingRepository;

    //Constructor injection of the ClothingRepository dependency
    public ClothingService(ClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
    }

    //Service methods for performing CRUD operations on clothing items
    public List<ClothingItem> getAllClothingItems() {
        logger.info("Fetching all clothing items");
        return clothingRepository.findAll();
    }

    public ClothingItem addClothingItem(ClothingItem clothingItem) {
        logger.info("Adding clothing item: {}", clothingItem);
        return clothingRepository.save(clothingItem);
    }

    public ClothingItem updateClothingItem(Long id, ClothingItem clothingItem) {
        logger.info("Updating clothing item with id: {}", id);
        ClothingItem existingItem = clothingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        existingItem.setName(clothingItem.getName());
        existingItem.setSize(clothingItem.getSize());
        existingItem.setPrice(clothingItem.getPrice());
        return clothingRepository.save(existingItem);
    }

    public void deleteClothingItem(Long id) {
        logger.info("Deleting clothing item with id: {}", id);
        ClothingItem existingItem = clothingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        clothingRepository.delete(existingItem);
    }
}
