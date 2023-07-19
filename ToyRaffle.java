import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyRaffle {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyRaffle() {
        this.toys = new ArrayList<>();
        this.prizeToys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int toyId, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setWeight(weight);
                return;
            }
        }
    }

    public void startRaffle() {
        Random random = new Random();
        
        while (!toys.isEmpty()) {
            int totalWeight = 0;
            
            for (Toy toy : toys) {
                totalWeight += toy.getWeight();
            }
            
            int randomNumber = random.nextInt(totalWeight);
            int currentWeight = 0;
            
            for (int i = 0; i < toys.size(); i++) {
                currentWeight += toys.get(i).getWeight();
                
                if (randomNumber < currentWeight) {
                    Toy prizeToy = toys.remove(i);
                    prizeToys.add(prizeToy);
                    break;
                }
            }
        }
    }

    public void getPrizeToy() {
        if (!prizeToys.isEmpty()) {
            Toy prizeToy = prizeToys.remove(0);
            
            try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
                writer.write(prizeToy.toString() + System.lineSeparator());
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            prizeToy.decreaseQuantity();
        }
    }
}
