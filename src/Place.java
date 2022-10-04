import java.util.Scanner;

public class Place extends Object{
	private String placeName;
	private Raider placeRaider;
	private Food placeFoodStash;
	private Drinkable placeDrinkStash;
	private Medicine placeMedicineStash;


	Place(String _name, Raider _raider, Food _food, Drinkable _drink, Medicine _medicine){
		placeName = _name;
		placeRaider = _raider;
		placeFoodStash = _food;
		placeDrinkStash = _drink;
		placeMedicineStash = _medicine;

	}
	public String GetName(){
		return placeName;
	}
	public void Discover(Player _player){
		Scanner scanner = new Scanner(System.in);
		System.out.println("============================================================");
		System.out.println("You have discovered " + placeName);
		System.out.println("What do you want to do?");
		System.out.println(" [1] Look around \n [2] Keep going");
		
		byte choice = scanner.nextByte();
		switch (choice) {
			case 1:
			if (placeRaider != null){
				placeRaider.Combat(_player);
			}		
			System.out.println("> In " + placeName + " You see " + placeFoodStash.getName() + ", " + placeDrinkStash.getName() + ", " + placeMedicineStash.getName());
			_player.StoreFood(placeFoodStash, 0);
			_player.StoreDrink(placeDrinkStash, 0);
			_player.StoreMedicine(placeMedicineStash, 0);
				break;
			case 2:
				System.out.println("You go past the " + placeName + " and continue on your trail");
				break;
			default:
				break;
		}
	}
}
