import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Ecosistem {
    private List<EntitateEcosistem> entitati = new ArrayList<>();
    private int dimensiuneHarta;
    private char[][] harta;
    private List<String> speciiCarnivore = new ArrayList<>();
    private List<String> speciiErbivore = new ArrayList<>();
    private List<String> speciiOmnivore = new ArrayList<>();
    private Random rand = new Random();

    public Ecosistem(int dimensiuneHarta) {
        this.dimensiuneHarta = dimensiuneHarta;
        this.harta = new char[dimensiuneHarta][dimensiuneHarta];
        initializeazaHarta();
        citesteSpeciiDinFisier("specii/carnivore.txt", speciiCarnivore);
        citesteSpeciiDinFisier("specii/erbivore.txt", speciiErbivore);
        citesteSpeciiDinFisier("specii/omnivore.txt", speciiOmnivore);
    }

    // Citirea speciilor din fișier
    private void citesteSpeciiDinFisier(String numeFisier, List<String> listaSpecii) {
        try (BufferedReader br = new BufferedReader(new FileReader(numeFisier))) {
            String linie;
            while ((linie = br.readLine()) != null) {
                listaSpecii.add(linie.trim());
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fișierului: " + numeFisier);
        }
    }

        // Inițializarea hărții cu spații libere
    private void initializeazaHarta() {
        for (int i = 0; i < dimensiuneHarta; i++) {
            for (int j = 0; j < dimensiuneHarta; j++) {
                harta[i][j] = '.';
            }
        }
    }


    // Adăugăm entități în ecosistem, alocând specii aleatoriu
    public void populeazaEcosistem(int numarPlante, int numarErbivore, int numarCarnivore, int numarOmnivore) {
        Random rand = new Random();

        for (int i = 0; i < numarPlante; i++) {
            adaugaEntitate(new Planta("Planta" + i, 20, rand.nextInt(dimensiuneHarta), rand.nextInt(dimensiuneHarta)));
        }

        for (int i = 0; i < numarErbivore; i++) {
            String specie = speciiErbivore.get(rand.nextInt(speciiErbivore.size()));
            adaugaEntitate(new Erbivor(specie, 30, rand.nextInt(dimensiuneHarta), rand.nextInt(dimensiuneHarta)));
        }

        for (int i = 0; i < numarCarnivore; i++) {
            String specie = speciiCarnivore.get(rand.nextInt(speciiCarnivore.size()));
            adaugaEntitate(new Carnivor(specie, 40, rand.nextInt(dimensiuneHarta), rand.nextInt(dimensiuneHarta)));
        }

        for (int i = 0; i < numarOmnivore; i++) {
            String specie = speciiOmnivore.get(rand.nextInt(speciiOmnivore.size()));
            adaugaEntitate(new Omnivor(specie, 50, rand.nextInt(dimensiuneHarta), rand.nextInt(dimensiuneHarta)));
        }
    }


    private void evenimenteAleatorii() {
        int sansaEveniment = rand.nextInt(100);

        if (sansaEveniment < 10) { // Secetă (10% șansă)
            System.out.println("\nSecetă! Plantele pierd energie!");
            for (EntitateEcosistem entitate : entitati) {
                if (entitate instanceof Planta) {
                    entitate.energie -= 20;
                }
            }
        } else if (sansaEveniment < 20) { // Furtună (10% șansă)
            System.out.println("\nFurtună! Toate entitățile pierd energie!");
            for (EntitateEcosistem entitate : entitati) {
                entitate.energie -= rand.nextInt(10) + 5; // Pierd între 5 și 15 energie
            }
        } else if (sansaEveniment < 25) { // Apariția de noi entități (5% șansă)
            System.out.println("\nUn nou grup de entități apare!");
            int numarNoiPlante = rand.nextInt(3) + 1;
            int numarNoiAnimale = rand.nextInt(2) + 1;
            populeazaEcosistem(numarNoiPlante, numarNoiAnimale, 0, 0);
        }
    }


    // Adăugarea unei entități pe hartă
    private void adaugaEntitate(EntitateEcosistem entitate) {
        entitati.add(entitate);
        harta[entitate.x][entitate.y] = entitate.getClass().getSimpleName().charAt(0);
    }

    // Actualizarea poziției unei entități
    private void actualizeazaHarta(EntitateEcosistem entitate, int xNou, int yNou) {
        harta[entitate.x][entitate.y] = '.';
        entitate.x = xNou;
        entitate.y = yNou;
        harta[xNou][yNou] = entitate.getClass().getSimpleName().charAt(0);
    }

    // Simularea unui pas
    public void simuleazaPas() {
        List<EntitateEcosistem> consumate = new ArrayList<>();
        Random rand = new Random();

        evenimenteAleatorii();

        for (EntitateEcosistem entitate : entitati) {
            if (entitate instanceof Animal) {
                Animal animal = (Animal) entitate;

                // Mișcare
                int xNou = Math.max(0, Math.min(dimensiuneHarta - 1, animal.x + rand.nextInt(3) - 1)); // (-1, 0, 1)
                int yNou = Math.max(0, Math.min(dimensiuneHarta - 1, animal.y + rand.nextInt(3) - 1));
                actualizeazaHarta(animal, xNou, yNou);
                System.out.println(animal.nume + " (" + animal.getClass().getSimpleName() + ") s-a mutat la (" + xNou + ", " + yNou + ")");
                animal.pierdeEnergieLaMiscare();

                // Detectare și consum de hrană
                EntitateEcosistem hrana = detecteazaHrana(animal);
                if (hrana != null) {
                    animal.mananca(hrana);
                    consumate.add(hrana);
                }
            }
        }

        // Eliminăm entitățile consumate
        entitati.removeAll(consumate);
        entitati.removeIf(entitate -> entitate.energie <= 0);
        for (EntitateEcosistem consumat : consumate) {
            System.out.println(consumat.nume + " a fost consumat.");
        }

        // Eliminăm entitățile fără energie
        entitati.removeIf(entitate -> entitate.energie <= 0);
    }

    // Detectare hrană
    private EntitateEcosistem detecteazaHrana(Animal animal) {
        for (EntitateEcosistem entitate : entitati) {
            if (animal instanceof Erbivor && entitate instanceof Planta) {
                if (distanta(animal, entitate) <= 1) return entitate;
            } else if (animal instanceof Carnivor && entitate instanceof Animal) {
                if (distanta(animal, entitate) <= 1 && !(entitate instanceof Carnivor)) return entitate;
            } else if (animal instanceof Omnivor) {
                if (distanta(animal, entitate) <= 1) return entitate;
            }
        }
        return null;
    }

    // Calculează distanța Manhattan între două entități
    private int distanta(EntitateEcosistem e1, EntitateEcosistem e2) {
        return Math.abs(e1.x - e2.x) + Math.abs(e1.y - e2.y);
    }

    // Afișare stare ecosistem
    public void afiseazaHarta() {
        System.out.println("\nHarta ecosistemului:");
        for (int i = 0; i < dimensiuneHarta; i++) {
            for (int j = 0; j < dimensiuneHarta; j++) {
                System.out.print(harta[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void afiseazaStare() {
        System.out.println("\nStarea ecosistemului:");
        for (EntitateEcosistem entitate : entitati) {
            System.out.println(entitate.nume + " la (" + entitate.x + ", " + entitate.y + "), energie: " + entitate.energie);
        }
    }
}
