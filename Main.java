public class Main {
    public static void main(String[] args) {
        ToyRaffle toyRaffle = new ToyRaffle();

        // Добавление игрушек
        toyRaffle.addToy(new Toy(1, "Doll", 10, 20));
        toyRaffle.addToy(new Toy(2, "Car", 5, 30));
        toyRaffle.addToy(new Toy(3, "Puzzle", 8, 15));

        // Изменение веса игрушки
        toyRaffle.updateToyWeight(2, 40);

        // Запуск розыгрыша
        toyRaffle.startRaffle();

        // Получение призовой игрушки
        toyRaffle.getPrizeToy();
    }
}