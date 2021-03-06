//Andreas Wang, Kyle Oleksiuk, Cardi Wei
//Pd 8
//HW 26
//2013-11-18

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
            a = a + ". Too bad he's too stupid to heal very well...\n";
            String b = "Hit Points: " + HP + "\n";
            String c = "Strength: " + str + "\n";
            String d = "Defense: " + def + "\n";
            String e = "Critical Hit Rating: " + crt + "\n";
            return a + b + c + d + e;
    }

    public int heal(){
            lowerHP(-5);
            return 5;
    }
}
