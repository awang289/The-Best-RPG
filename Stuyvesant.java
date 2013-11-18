//Andreas Wang, Kyle Oleksiuk, Cardi Wei
//Pd 8
//HW 26
//2013-11-18

public class Stuyvesant extends Character {

    private String name;

    public Stuyvesant() {
        HP = 300;
        str= 100;
        def= 70;
        crt= 0;
    }
    public Stuyvesant(String n) {
        this();
        name = n;
    }
    public String getName() {
        return name;
    }
    public void specialize(){
        str = 125;
        def = 50;
    }
    public void normalize() {
        str = 100;
        def = 70;
    }
    public String about() {
            String a = "The Stuyvesant Student is very sleepy; he passes out every other turn. \n";
            String b = "Hit Points: " + HP + "\n";
            String c = "Strength: " + str + "\n";
            String d = "Defense: " + def + "\n";
            String e = "Critical Hit Rating: " + crt + "\n";
            return a + b + c + d + e;
    }
    
    public int heal(){
            lowerHP(-25);
            return 25;
    }
}
