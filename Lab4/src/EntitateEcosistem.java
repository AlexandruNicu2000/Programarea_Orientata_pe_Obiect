abstract class EntitateEcosistem {
    protected String nume;
    protected int energie;
    protected int x, y; // Poziția pe hartă
    protected double rataSupravietuire;

    public EntitateEcosistem(String nume, int energie, int x, int y, double rataSupravietuire) {
        this.nume = nume;
        this.energie = energie;
        this.x = x;
        this.y = y;
        this.rataSupravietuire = rataSupravietuire;
    }

    public abstract void actioneaza(); // Comportament specific fiecărei entități
}

