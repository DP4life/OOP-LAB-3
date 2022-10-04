public class Drinkable extends Consumable {
	Drinkable(String _drinkableName, int _quenchValue, int _drinkableRadiationValue, int _price){
		setName(_drinkableName);
		setEffect(_price);
		setRadiationEffect(_drinkableRadiationValue);
		setPrice(_price);
	}
}
