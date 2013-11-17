//Andreas Wang
//Pd 8
//HW 25
//2013-11-15

public class Monster extends Character {
    public Monster() {
	HP = 150;
	str= (int) ((Math.random() * 45) + 20);
	def= 20;
	att= 1;
    }
    public void specialize() {}
    public void normalize() {}
}
