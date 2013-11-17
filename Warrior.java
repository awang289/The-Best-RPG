//Andreas Wang
//Pd 8
//HW 25
//2013-11-15

public class Warrior extends Character {
    private String name;
    public Warrior() {
	HP = 125;
	str= 100;
	def= 40;
	att= 0.4;
    }
    public Warrior(String n) {
	this();
	name = n;
    }
    public String getName() {
	return name;
    }
    public void specialize(){
	att = .8;
	def = 20;
    }
    public void normalize() {
	att = 0.4;
	def = 40;
    }
}
