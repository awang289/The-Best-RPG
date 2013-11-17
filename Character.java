//Andreas Wang
//Pd 8
//HW 25
//2013-11-15

public abstract class Character{
    protected int HP;
    protected int str;
    protected int def;
    protected double crt; // added crt factor
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
        //I changed the attack algorithm from subtraction to division so we don't get so many 0 damages
        //cardy just make sure no monster's defense is above 100
	int damage = (int) (((Math.random() * .15) + .85) * 10 * str * / m.getDefense());
	if (damage > 0) {
	    m.lowerHP(damage);
	    return damage;
	}
	else { return 0; }
    }
    public int crtAttack(Character m) { 
        // to be called in YoRPG with "if (Math.random() < crt)"
        int damage = (int) (((Math.random() * .15) + .85) * 20 * str / m.getDefense());
        if (damage > 0) {
	    m.lowerHP(damage);
	    return damage;
	}
	else { return 0; }
    }
    //healing method is abstract because requirements are for one additional abstract
    public abstract int heal();
    public abstract void specialize();
    public abstract void normalize();
    public abstract void about(); //So I didn't have this for the hw... oops
}
