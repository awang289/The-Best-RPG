public class Cyborg extends Character {

    private String name;

    public Cyborg() {
        HP = 600;
        str= 200;
        def= 200;
        crt= 0.1;
    }
    public Cyborg(String n) {
        this();
        name = n;
    }
    public String getName() {
        return name;
    }
    public void specialize(){
        str = 250;
        def = 150;
    }
    public void normalize() {
        str = 200;
        def = 200;
    }
    public String about() {
            String a = "The Cyborg is unstoppable; truly a monster slaying machine. \n";
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
