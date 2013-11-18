//Cardy Wei
//Pd8
//Hw25
//11/17/13

public class Gorgon extends Character{
	public String name;

	public Gorgon(){
		name="Gorgon";
		HP = 100;
		str = 75;
		def = 5;
		crt = .2;
	}

    	public void specialize() {}
    	public void normalize() {}
    	public String about() {return name;}
    	public int heal() { return 0;}
}
