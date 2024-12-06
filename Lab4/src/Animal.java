abstract class Animal extends EntitateEcosistem {
    protected int viteza;
    protected String tipHrana;

    public Animal(String nume, int energie, int x, int y, double rataSupravietuire, int viteza, String tipHrana) {
        super(nume, energie, x, y, rataSupravietuire);
        this.viteza = viteza;
        this.tipHrana = tipHrana;
    }

    public abstract void mananca(EntitateEcosistem hrana);

    public void deplaseaza() {
        this.x += (int) (Math.random() * viteza - viteza / 2);
        this.y += (int) (Math.random() * viteza - viteza / 2);
        System.out.println(nume + " s-a deplasat la (" + x + ", " + y + ")");
    }

    public void pierdeEnergieLaMiscare() {
        this.energie -= 2;
        if (energie < 0) energie = 0;
    }



    public abstract Animal reproduce();
}



