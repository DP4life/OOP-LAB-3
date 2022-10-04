import java.util.Scanner;

public class Player extends Object{
	private int maxHealth;
	private int health;

	private int attack;

	private int thirst;
	private int maxThirst = 100;

	private int hunger;
	private int maxHunger = 100;

	private int radiation = 0;
	private int maxRadiation = 100;

	private int money = 0;


	Player(int _health, int _money, int _attack){
		attack = _attack;
		health = _health;
		money = _money;
		hunger = maxHunger;
		thirst = maxThirst;
	}

	//Inventory
	private Drinkable[] playerInventoryDrinkable = new Drinkable[100];
	private int inventoryFoodIndex = 0;
	private Food[] playerInventoryFood = new Food[100];
	private int inventoryDrinkIndex = 0;
	private Medicine[] playerInventoryMedicine = new Medicine[100];
	private int inventoryMedicineIndex = 0;

	public int PlayerAttack(){
		return attack;
	}

	//Inventory methods

	public void SetMoney(int newMoney){
		money = newMoney;
	}

	public void DisplayInventory(){
		System.out.println("============================================================");
		System.out.println("Caps: " + money);
		System.out.println("> What bag would you like to check? \n [1] The Food Sack\n [2] The Drinks Sack\n [3] The Medicine Bag\n [4] Back");
		System.out.print(" > ");
		Scanner playerScanner = new Scanner(System.in);
		byte choice = 0; 
		choice = playerScanner.nextByte();
		 
		switch (choice) {
			case 1:
				for (int i = 0; i < inventoryFoodIndex; i++){
					System.out.println("["+i+"] "+ playerInventoryFood[i].getName() + " HUNGER: " + playerInventoryFood[i].getEffect() + " RAD: " + playerInventoryFood[i].getRadiationEffect());
				}
				System.out.println("["+(inventoryFoodIndex)+"] Nothing" );
				System.out.println("What would you like to consume ?");
				choice = playerScanner.nextByte();
				if (choice != inventoryFoodIndex)
					ConsumeFood(choice);
					else DisplayInventory();
				break;
	
			case 2:
				for (int i = 0; i < inventoryDrinkIndex; i++){
					System.out.println("["+i+"] "+ playerInventoryDrinkable[i].getName() + " THIRST: " + playerInventoryDrinkable[i].getEffect() + " RAD: " + playerInventoryDrinkable[i].getRadiationEffect());
				}
				System.out.println("["+(inventoryDrinkIndex)+"] Nothing" );
				System.out.println("What would you like to consume ?");
				choice = playerScanner.nextByte();
				if (choice != inventoryDrinkIndex)
					ConsumeDrinkable(choice);
					else DisplayInventory();
				break; 
			
			case 3:
				for (int i = 0; i < inventoryMedicineIndex; i++){
					System.out.println("["+i+"] "+ playerInventoryMedicine[i].getName() + " HP: +" + playerInventoryMedicine[i].getEffect() + " RAD: -" + playerInventoryMedicine[i].getRadiationEffect());
				}
				System.out.println("["+(inventoryMedicineIndex)+"] Nothing" );
				System.out.println("What would you like to consume ?");
				choice = playerScanner.nextByte();
				if (choice != inventoryMedicineIndex)
					ConsumeMedicine(choice);
					else DisplayInventory();
				break; 
				
			case 4: 
				TakeBreak();
			default:
				
				break;
		}
	}

		//Food
	public void StoreFood(Food _food, int n){
		playerInventoryFood[n] = _food;
		System.out.println("============================================================");
		System.out.println("You stored " + _food.getName() + " HG = " + _food.getEffect() + " RAD = " + _food.getRadiationEffect());
		inventoryFoodIndex++;
	}

	public void ConsumeFood(int n){
		hunger += playerInventoryFood[n].getEffect();
		if (hunger > maxHunger) {
			hunger = maxHunger;
		}
		radiation += playerInventoryFood[n].getRadiationEffect();
		if (radiation > maxRadiation){
			Die();
		}
		System.out.println("============================================================");
		System.out.println("You ate " + playerInventoryFood[n].getName());
		System.out.println("Hunger + " + playerInventoryFood[n].getName());
		System.out.println("Radiation + " + playerInventoryFood[n].getRadiationEffect());
	}
	public int GetFoodIndex(){
		return inventoryFoodIndex;
	}
		//Drinks
	public void StoreDrink(Drinkable _drink, int n){
		System.out.println("============================================================");
		playerInventoryDrinkable[n] = _drink;
		System.out.println("You stored " + _drink.getName() + " HG = " + _drink.getEffect() + " RAD = " + _drink.getRadiationEffect());
		inventoryDrinkIndex++;
	}
	
	public void ConsumeDrinkable(int n){
		thirst += playerInventoryDrinkable[n].getEffect();
		if (thirst > maxThirst){
			thirst = maxThirst;
		}
		radiation += playerInventoryDrinkable[n].getRadiationEffect();
		if (radiation > maxRadiation){
			Die();
		}
		System.out.println("============================================================");
		System.out.println("You drank " + playerInventoryDrinkable[n].getName());
		System.out.println("Thirst + " + playerInventoryDrinkable[n].getEffect());
		System.out.println("Radiation + " + playerInventoryDrinkable[n].getRadiationEffect());
	}
	
	public int GetDrinkIndex(){
		return inventoryDrinkIndex;
	}

		//Medicine
	public void StoreMedicine(Medicine _medicine, int n){
		System.out.println("============================================================");
		playerInventoryMedicine[n] = _medicine;
		System.out.println("You stored " + _medicine.getName() + " HP = " + _medicine.getEffect() + " RAD = " + _medicine.getRadiationEffect());
		inventoryMedicineIndex++;
	}
	
	public void ConsumeMedicine(int n){
		health += playerInventoryMedicine[n].getEffect();
		radiation -= playerInventoryMedicine[n].getRadiationEffect();
		if (health > maxHealth) health = maxHealth;
		if (radiation < 0) radiation = 0;

		System.out.println("============================================================");
		System.out.println("You injected " + playerInventoryMedicine[n].getName());
		System.out.println("Health + " + playerInventoryMedicine[n].getEffect());
		System.out.println("Radiation - " + playerInventoryMedicine[n].getEffect());
	}	

	public int GetMedicineIndex(){
		return inventoryMedicineIndex;
	}


	//gameplay
	public void TakeBreak(){
		Scanner scanner = new Scanner(System.in);
        byte mainChoice = 0;
        
		System.out.println("============================================================");
		System.out.println(" > What would you like to do?\n [1] Continue on the trail\n [2] Open Inventory \n [3] Check Stats");
		System.out.print(" > ");
		mainChoice = scanner.nextByte();

		switch (mainChoice) {
			case 1:
				System.out.println("You continue your jorney");
				break;
			case 2:
			DisplayInventory();
				break;
			case 3:
			DisplayStats();
				break;
		
			default:
				break;
		}

	}

	//stats
	public void DisplayStats(){
		System.out.println("============================================================");
		System.out.println("HP: " + health+"/"+maxHealth);
		System.out.println("RAD: " + radiation+"/"+maxRadiation);	
		System.out.println("Thirst: " + thirst+"/"+maxThirst);
		System.out.println("Hunger: " + hunger+"/"+maxHunger);
		TakeBreak();
	}
	public int GetMoney(){
		return money;
	}
	public int GetHunger(){
		return hunger;
	}
	public int GetHealth(){
		return health;
	}
	public int GetMaxHealth(){
		return maxHealth;
	}
	public int GetThirst(){
		return thirst;
	}
	public void TakeDamage(int damage){
		health -= damage;
	}
	public void TakeRadiation(int damage){
		radiation += damage;
	}
	public void Die(){
		System.out.println("You are dead lol");
	}

}
