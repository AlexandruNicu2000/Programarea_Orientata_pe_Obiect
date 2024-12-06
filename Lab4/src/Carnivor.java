class Carnivor extends Animal {

    public Carnivor(String nume, int energie, int x, int y) {
        super(nume, energie, x, y, 0.7, 4, "Animale");
    }

    @Override
    public void mananca(EntitateEcosistem hrana) {
        if (hrana instanceof Animal) {
            this.energie += hrana.energie / 2;
            hrana.energie = 0; // Animalul prădat este consumat
            System.out.println(nume + " a vânat " + hrana.nume + " și a câștigat energie: " + energie);
        }
    }


    @Override
    public Carnivor reproduce() {
        return new Carnivor(nume + "_copil", 30, x + 1, y + 1);
    }

    @Override
    public void actioneaza() {

    }
}

