class Erbivor extends Animal {

    public Erbivor(String nume, int energie, int x, int y) {
        super(nume, energie, x, y, 0.8, 3, "Plante");
    }
    @Override
    public void mananca(EntitateEcosistem hrana) {
        if (hrana instanceof Planta) {
            this.energie += hrana.energie;
            hrana.energie = 0; // Planta este consumată
            System.out.println(nume + " a mâncat planta " + hrana.nume + " și a câștigat energie: " + energie);
        }
    }


    @Override
    public Erbivor reproduce() {
        return new Erbivor(nume + "_copil", 20, x + 1, y + 1);
    }

    @Override
    public void actioneaza() {

    }
}

