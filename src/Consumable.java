public class Consumable extends Object{
	private String name;
	private int effect;
	private int radiationEffect;
	private int price;

	Consumable(){

	}
	Consumable(String _name, int _effect, int _radiationEffect, int _price){
		name = _name;
		effect = _effect;
		radiationEffect = _radiationEffect;
		price = _price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEffect() {
		return effect;
	}
	public void setEffect(int effect) {
		this.effect = effect;
	}
	public int getRadiationEffect() {
		return radiationEffect;
	}
	public void setRadiationEffect(int radiationEffect) {
		this.radiationEffect = radiationEffect;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
