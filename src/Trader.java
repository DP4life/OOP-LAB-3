import java.util.Scanner;

public class Trader extends Object {
	private Food traderFood;
	private Drinkable traderDrink;
	private Medicine traderMedicine;

	Trader(Food _food, Drinkable _drink, Medicine _medicine){
		traderFood = _food;
		traderDrink = _drink;
		traderMedicine = _medicine;
	}


	public void Meet(Player _player){
		System.out.println("============================================================");
		System.out.println(" > You meet a trader!");
		System.out.println(" [1] Continue on your trail\n [2] Barter ");
		System.out.print(" > ");
		Scanner scanner = new Scanner(System.in);
		byte choice = 0;

		choice = scanner.nextByte();

		switch(choice){
			case 1:
				System.out.println("You continue on your journey");
				break;
			case 2:
				Barter(_player);
				break;
			default:
				break;
		}
	}

	public void Barter(Player _player){
		System.out.println("============================================================");
		System.out.println(" > \"Here's what I have to offer\"");
		System.out.println(" [1] " + traderFood.getName() + " " + ConsoleColors.CYAN + traderFood.getEffect() + " " + ConsoleColors.RED + traderFood.getRadiationEffect() + " " + ConsoleColors.YELLOW + traderFood.getPrice() + ConsoleColors.RESET);
		System.out.println(" [2] " + traderDrink.getName() +  " " +ConsoleColors.BLUE + traderDrink.getEffect() + " " + ConsoleColors.RED + traderDrink.getRadiationEffect() + " " + ConsoleColors.YELLOW + traderDrink.getPrice() + ConsoleColors.RESET);
		System.out.println(" [3] " + traderMedicine.getName() +  " " +ConsoleColors.GREEN + traderMedicine.getEffect() +" " + ConsoleColors.PURPLE + traderMedicine.getRadiationEffect() +" " + ConsoleColors.YELLOW + traderMedicine.getPrice() + ConsoleColors.RESET);
		System.out.println(" [4] Nothing");
		System.out.println(" > You have " + _player.GetMoney() + " caps");
		Scanner scanner = new Scanner(System.in);

		byte choice = 0;
		choice = scanner.nextByte();

		switch (choice){
			case 1:
				_player.StoreFood(traderFood, _player.GetFoodIndex());
				if (_player.GetMoney() - traderFood.getPrice() < 0){
					System.out.println("You don't have enough money");
					break;
				} 
				_player.SetMoney(_player.GetMoney() - traderFood.getPrice());
				break;
			case 2:
				_player.StoreDrink(traderDrink, _player.GetDrinkIndex());
				if (_player.GetMoney() - traderDrink.getPrice() < 0){
					System.out.println("You don't have enough money");
					break;
				} 
				_player.SetMoney(_player.GetMoney() - traderDrink.getPrice());
				break;
			case 3:
				_player.StoreMedicine(traderMedicine, _player.GetMedicineIndex());
				if (_player.GetMoney() - traderMedicine.getPrice() < 0){
					System.out.println("You don't have enough money");
					break;
				} 
				_player.SetMoney(_player.GetMoney() - traderMedicine.getPrice());
				break;
			default:
				break;
		}
	}
}
