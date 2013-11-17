//Andreas Wang
//Pd 8
//HW 25
//2013-11-15

public class Warrior extends Character {
    private String name;
    public Warrior() {
	HP = 125;
	str= 60;
	def= 40;
	crt= 0.2;
    }
    public Warrior(String n) {
	this();
	name = n;
    }
    public String getName() {
	return name;
    }
    public void specialize(){
	str = 120;
	def = 20;
    }
    public void normalize() {
	str = 60;
	def = 40;
    }
    public String about() {
    	String a = "The strong and mighty warrior is strong and mighty. He does impressive amounts of damage";
    	a = a + ". Too bad he's too stupid to heal very well...";
    	return a;
    }
    public int heal(){
    	lowerHP(-5);
    	return 5;
    }
}
