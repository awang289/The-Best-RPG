//Andreas Wang
//Pd 8
//HW 25
//2013-11-15

public abstract class Character{
    protected int HP;
    protected int str;
    protected int def;
    protected double crt; // added crt factor
    protected double heal; //added heal factor
    public boolean isAlive(){
	return (HP > 0);
    }
    public int getDefense(){
	return def;
    }
    //Crt accessor method
    public double getCrt() {
        return crt;
    }
    public int lowerHP(int num) {
	HP -= num;
	return HP;
    }
    public int attack(Character m) { 
        //incorporated randomness 
	int damage = (int) (((Math.random() * .15) + .85) * str - m.getDefense());
	if (damage > 0) {
	    m.lowerHP(damage);
	    return damage;
	}
	else { return 0; }
    }
    public int crtAttack(Character m) { 
        // to be called in YoRPG with "if (Math.random() < crt)"
        int damage = (int) ((Math.random() * .85) * str - m.getDefense());
        damage *= 2;
        if (damage > 0) {
	    m.lowerHP(damage);
	    return damage;
	}
	else { return 0; }
    }
    //healing method, also with a random factor
    public int heal(Character m) {
        amt = (int) (Math.random() * .85);
        amt *= -1;
        m.lowerHP(amt);
        return amt;
    }
    public abstract void specialize();
    public abstract void normalize();
    public abstract void description(); //So I didn't have this for the hw... oops
}
