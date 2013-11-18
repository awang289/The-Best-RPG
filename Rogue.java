//Andreas Wang, Kyle Oleksiuk, Cardi Wei
//Pd 8
//HW 26
//2013-11-18

public class Rogue extends Character {

    private String name;

    public Rogue() {
        HP = 100;
        str= 45;
        def= 50;
        crt= .45;
    }
    public Rogue(String n) {
        this();
        name = n;
    }
    public String getName() {
        return name;
    }
    public void specialize(){
        crt = .95;
        def = 30;
    }
    public void normalize() {
        crt = .45;
        def = 50;
    }
    public String about() {
            String a = "Rogue is super sketchy.\n";
            String b = "Hit Points: " + HP + "\n";
            String c = "Strength: " + str + "\n";
            String d = "Defense: " + def + "\n";
            String e = "Critical Hit Rating: " + crt + "\n";
	    String f = "Rogue's special will hit critical almost every time!";
            return a + b + c + d + e + f;
    }
    public int heal(){
            lowerHP(-25);
            return 25;
    }
}
