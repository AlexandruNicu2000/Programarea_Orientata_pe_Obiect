# Simularea Ecosistemului - Proiect Java

Acest proiect simulează un ecosistem complex în care plantele și animalele interacționează între ele. Ecosistemul include plante, animale erbivore, carnivore și omnivore, iar acestea se mișcă pe o hartă, interacționează între ele și pot muri din cauza lipsei de energie. Proiectul folosește principii de programare orientată pe obiecte (OOP) pentru a simula aceste comportamente, incluzând concepte precum moștenirea, polimorfismul și utilizarea de clase abstracte și interfețe.

## Descrierea claselor și ierarhiilor

### 1. **Clasa abstractă `EntitateEcosistem`**
   - Aceasta este clasa de bază pentru toate entitățile din ecosistem (plante și animale).
   - Atribute comune:
     - `nume`: Numele entității.
     - `energie`: Cantitatea de energie a entității.
     - `x`, `y`: Coordonatele pe hartă ale entității.
   - Metode:
     - `actiune()`: Metodă abstractă care va fi implementată de fiecare subclasă pentru a defini comportamentul specific (de exemplu, cum se mișcă sau se hrănește entitatea).

### 2. **Clasa `Planta`**
   - Aceasta este o subclasă a clasei `EntitateEcosistem` și reprezintă plantele din ecosistem.
   - Comportamente:
     - Crește și câștigă energie.

   - Metode:
     - `actiune()`: Crește energia plantei cu o valoare prestabilită (2 unități de energie).

### 3. **Clasa abstractă `Animal`**
   - Este o subclasă a clasei `EntitateEcosistem` și reprezintă animale din ecosistem.
   - Atribute suplimentare:
     - `viteza`: Viteza de mișcare a animalului.
     - `tipHrana`: Tipul de hrană pe care îl consumă animalul (erbivor, carnivor, omnivor).
   - Metode:
     - `mananca(EntitateEcosistem hrana)`: Permite animalului să mănânce o entitate din ecosistem.
     - `actiune()`: Metodă abstractă care va fi implementată de fiecare subclasă pentru a defini comportamentele specifice (mișcare, vânătoare etc.).

### 4. **Subclase ale `Animal`**:
   - **Clasa `Carnivor`**: Reprezintă animalele carnivore care vânează alte animale.
   - **Clasa `Erbivor`**: Reprezintă animalele erbivore care se hrănesc cu plante.
   - **Clasa `Omnivor`**: Reprezintă animalele omnivore care se hrănesc atât cu plante, cât și cu animale.
   - Fiecare subclasă implementează metoda `actiune()` pentru a descrie cum se mișcă și cum interacționează cu alte entități.

### 5. **Clasa `Ecosistem`**
   - Clasa principală care gestionează entitățile din ecosistem și interacțiunile dintre acestea.
   - Atribute:
     - `entitati`: Listă care conține toate entitățile din ecosistem (plante și animale).
     - `dimensiuneHarta`: Dimensiunea hărții ecosistemului.
     - `harta`: Matrice care reprezintă harta ecosistemului.
     - `speciiCarnivore`, `speciiErbivore`, `speciiOmnivore`: Liste de specii citite din fișiere externe.
   - Metode:
     - `initializeazaHarta()`: Inițializează harta cu entitățile corespunzătoare.
     - `citesteSpeciiDinFisier(String numeFisier, List<String> listaSpecii)`: Citește lista de specii dintr-un fișier extern (ex. `carnivore.txt`, `erbivore.txt`).
     - `populeazaEcosistem(int numarPlante, int numarErbivore, int numarCarnivore, int numarOmnivore)`: Populează ecosistemul cu plante și animale (carnivore, erbivore, omnivore) pe baza speciilor citite din fișiere.
     - `adaugaEntitate(EntitateEcosistem entitate)`: Adaugă o entitate pe hartă.
     - `evenimenteAleatorii()`: Simulează evenimente aleatorii (secetă, furtună, apariția de noi entități).
     - `simularePas()`: Simulează un pas al ecosistemului, în care toate entitățile efectuează acțiunile lor (mișcare, hrănire, creștere etc.), iar energia lor este actualizată.
     - `main(String[] args)`: Inițializează ecosistemul și simulează mai multe pași.

## Explicația fiecărei metode

### 1. **Clasa `EntitateEcosistem`**
   - `abstract void actiune()`: Este metoda abstractă care trebuie implementată de fiecare subclasă. Definește comportamentul fiecărei entități din ecosistem.

### 2. **Clasa `Planta`**
   - `void actiune()`: Crește energia plantei cu o valoare prestabilită de 2 unități.

### 3. **Clasa `Animal`**
   - `abstract void actiune()`: Metodă abstractă ce definește comportamentele comune pentru toate animalele (mișcare, vânătoare etc.), dar care trebuie implementată în subclase.
   - `void mananca(EntitateEcosistem hrana)`: Permite animalului să mănânce o entitate din ecosistem. Crește energia animalului dacă acesta mănâncă alt animal sau plantă.

### 4. **Subclasele `Carnivor`, `Erbivor`, `Omnivor`**
   - `void actiune()`: Implementează comportamentul de mișcare specific fiecărui tip de animal:
     - Carnivor: Vânează și se mișcă aleatoriu.
     - Erbivor: Caută plante și se mișcă aleatoriu.
     - Omnivor: Caută atât plante cât și animale, mișcându-se aleatoriu.

### 5. **Clasa `Ecosistem`**
   - `void initializeazaHarta()`: Inițializează harta ecosistemului cu entitățile corespunzătoare.
   - `void citesteSpeciiDinFisier(String numeFisier, List<String> listaSpecii)`: Citește fișiere externe pentru a adăuga specii de animale (carnivore, erbivore, omnivore).
   - `void populeazaEcosistem(int numarPlante, int numarErbivore, int numarCarnivore, int numarOmnivore)`: Creează entități de plante și animale și le plasează aleatoriu pe hartă.
   - `void adaugaEntitate(EntitateEcosistem entitate)`: Plasează o entitate pe hartă.
   - `void evenimenteAleatorii()`: Simulează evenimente aleatorii care afectează ecosistemul, cum ar fi seceta, furtuna sau apariția de noi entități.
   - `void simularePas()`: Simulează un pas al ecosistemului, actualizând pozițiile și energiile entităților și aplicând evenimentele aleatorii.
   - `public static void main(String[] args)`: Initializează ecosistemul și rulează simulările.

## Structura fișierelor

- **Fișiere de specii** (`carnivore.txt`, `erbivore.txt`, `omnivore.txt`):
   - Fiecare fișier conține o listă de specii pentru fiecare tip de animal.
   - Exemplu de conținut pentru `carnivore.txt`:
     ```
     Lup
     Tigru
     Leu
     ```
   - Speciile sunt citite aleatoriu pentru a popula ecosistemul.

## Simulari efectuate

### Simularea 1- 10 plante, 6 erbivore, 4 carnovore, 3 omnivore
```
Pas 1:
Zebră (Erbivor) s-a mutat la (19, 12)
Elefant (Erbivor) s-a mutat la (7, 17)
Girafă (Erbivor) s-a mutat la (17, 16)
Girafă (Erbivor) s-a mutat la (5, 7)
Zebră (Erbivor) s-a mutat la (12, 17)
Bizon (Erbivor) s-a mutat la (2, 12)
Vulpe (Carnivor) s-a mutat la (7, 15)
Lup (Carnivor) s-a mutat la (0, 1)
Lup (Carnivor) s-a mutat la (17, 14)
Leu (Carnivor) s-a mutat la (18, 6)
Urs (Omnivor) s-a mutat la (5, 17)
Urs a mâncat Planta2 și a câștigat energie: 58
Om (Omnivor) s-a mutat la (2, 0)
Om a mâncat Om și a câștigat energie: 0
Porc Mistret (Omnivor) s-a mutat la (2, 4)
Porc Mistret a mâncat Porc Mistret și a câștigat energie: 0
Planta2 a fost consumat.
Om a fost consumat.
Porc Mistret a fost consumat.

Harta ecosistemului:
. C . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . . E . . . . . . . 
. . . . . . . P . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . P . . 
. . . . . . . E . . . . . . . . . O P . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . P . . . C . E . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . . . . . . . . . . . . . . . . E . . 
. . . . . . . . . . . . . . . . . . . . 
P . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . P P . . . . . 
. . . . . . . . . . . . . . C . E . . . 
. . . . . . C . . . . . . . . . . . . . 
. . . . . . . . . . . . E . . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 20
Planta1 la (16, 14), energie: 20
Planta3 la (4, 17), energie: 20
Planta4 la (16, 13), energie: 20
Planta5 la (10, 14), energie: 20
Planta6 la (14, 0), energie: 20
Planta7 la (3, 7), energie: 20
Planta8 la (7, 11), energie: 20
Planta9 la (11, 15), energie: 20
Zebră la (19, 12), energie: 28
Elefant la (7, 17), energie: 28
Girafă la (17, 16), energie: 28
Girafă la (5, 7), energie: 28
Zebră la (12, 17), energie: 28
Bizon la (2, 12), energie: 28
Vulpe la (7, 15), energie: 38
Lup la (0, 1), energie: 38
Lup la (17, 14), energie: 38
Leu la (18, 6), energie: 38
Urs la (5, 17), energie: 58

Pas 2:

Un nou grup de entități apare!
Zebră (Erbivor) s-a mutat la (19, 13)
Elefant (Erbivor) s-a mutat la (6, 17)
Girafă (Erbivor) s-a mutat la (18, 16)
Girafă (Erbivor) s-a mutat la (4, 7)
Girafă a mâncat planta Planta7 și a câștigat energie: 46
Zebră (Erbivor) s-a mutat la (13, 18)
Bizon (Erbivor) s-a mutat la (3, 11)
Vulpe (Carnivor) s-a mutat la (6, 16)
Vulpe a vânat Elefant și a câștigat energie: 49
Lup (Carnivor) s-a mutat la (0, 0)
Lup (Carnivor) s-a mutat la (18, 15)
Lup a vânat Girafă și a câștigat energie: 49
Leu (Carnivor) s-a mutat la (18, 5)
Urs (Omnivor) s-a mutat la (4, 18)
Urs a mâncat Planta3 și a câștigat energie: 66
Căprioară (Erbivor) s-a mutat la (7, 18)
Planta7 a fost consumat.
Elefant a fost consumat.
Girafă a fost consumat.
Planta3 a fost consumat.

Harta ecosistemului:
C . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . . . . . . . . . . 
. . . . . . . P . . . E . . . . . . . . 
. . . . . . . E . . . . . . . . . P O . 
. . . . . . . . . . . . . . . . . . P . 
P . . . . . . . . . . . . . . . C E . . 
. . . . . . . . . . . P . . . . . . E . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . E . 
P . . . . . . . P . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . P P . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . C . . . . . . . . . C E . . . 
. . . . . . . . . . . . . E . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 20
Planta1 la (16, 14), energie: 20
Planta4 la (16, 13), energie: 20
Planta5 la (10, 14), energie: 20
Planta6 la (14, 0), energie: 20
Planta8 la (7, 11), energie: 20
Planta9 la (11, 15), energie: 20
Zebră la (19, 13), energie: 26
Girafă la (4, 7), energie: 46
Zebră la (13, 18), energie: 26
Bizon la (3, 11), energie: 26
Vulpe la (6, 16), energie: 49
Lup la (0, 0), energie: 36
Lup la (18, 15), energie: 49
Leu la (18, 5), energie: 36
Urs la (4, 18), energie: 66
Planta0 la (14, 8), energie: 20
Planta1 la (6, 0), energie: 20
Căprioară la (7, 18), energie: 28

Pas 3:
Zebră (Erbivor) s-a mutat la (19, 13)
Girafă (Erbivor) s-a mutat la (3, 7)
Zebră (Erbivor) s-a mutat la (14, 18)
Bizon (Erbivor) s-a mutat la (4, 10)
Vulpe (Carnivor) s-a mutat la (5, 15)
Lup (Carnivor) s-a mutat la (0, 0)
Lup (Carnivor) s-a mutat la (18, 15)
Leu (Carnivor) s-a mutat la (18, 6)
Urs (Omnivor) s-a mutat la (5, 18)
Urs a mâncat Urs și a câștigat energie: 0
Căprioară (Erbivor) s-a mutat la (8, 18)
Urs a fost consumat.

Harta ecosistemului:
C . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . . . . . . . . . . 
. . . . . . . E . . . . . . . . . . . . 
. . . . . . . . . . E . . . . . . P . . 
. . . . . . . . . . . . . . . C . . O . 
P . . . . . . . . . . . . . . . . E . . 
. . . . . . . . . . . P . . . . . . . . 
. . . . . . . . . . . . . . . . . . E . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
P . . . . . . . P . . . . . . . . . E . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . P P . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . C . . . . . . . . C E . . . 
. . . . . . . . . . . . . E . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 20
Planta1 la (16, 14), energie: 20
Planta4 la (16, 13), energie: 20
Planta5 la (10, 14), energie: 20
Planta6 la (14, 0), energie: 20
Planta8 la (7, 11), energie: 20
Planta9 la (11, 15), energie: 20
Zebră la (19, 13), energie: 24
Girafă la (3, 7), energie: 44
Zebră la (14, 18), energie: 24
Bizon la (4, 10), energie: 24
Vulpe la (5, 15), energie: 47
Lup la (0, 0), energie: 34
Lup la (18, 15), energie: 47
Leu la (18, 6), energie: 34
Planta0 la (14, 8), energie: 20
Planta1 la (6, 0), energie: 20
Căprioară la (8, 18), energie: 26

Pas 4:
Zebră (Erbivor) s-a mutat la (18, 14)
Girafă (Erbivor) s-a mutat la (4, 6)
Zebră (Erbivor) s-a mutat la (15, 19)
Bizon (Erbivor) s-a mutat la (3, 10)
Vulpe (Carnivor) s-a mutat la (6, 16)
Lup (Carnivor) s-a mutat la (1, 0)
Lup (Carnivor) s-a mutat la (17, 14)
Lup a vânat Zebră și a câștigat energie: 56
Leu (Carnivor) s-a mutat la (17, 7)
Căprioară (Erbivor) s-a mutat la (9, 17)
Zebră a fost consumat.

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
C . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . . . . . . . . . . 
. . . . . . . . . . E . . . . . . . . . 
. . . . . . E . . . . . . . . . . P . . 
. . . . . . . . . . . . . . . . . . O . 
P . . . . . . . . . . . . . . . C E . . 
. . . . . . . . . . . P . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . E . . 
. . . . . . . . . . . . . . P . . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
P . . . . . . . P . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . E 
. . . . . . . . . . . . . P P . . . . . 
. . . . . . . C . . . . . . C . . . . . 
. . . . . . . . . . . . . . E . E . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 20
Planta1 la (16, 14), energie: 20
Planta4 la (16, 13), energie: 20
Planta5 la (10, 14), energie: 20
Planta6 la (14, 0), energie: 20
Planta8 la (7, 11), energie: 20
Planta9 la (11, 15), energie: 20
Girafă la (4, 6), energie: 42
Zebră la (15, 19), energie: 22
Bizon la (3, 10), energie: 22
Vulpe la (6, 16), energie: 45
Lup la (1, 0), energie: 32
Lup la (17, 14), energie: 56
Leu la (17, 7), energie: 32
Planta0 la (14, 8), energie: 20
Planta1 la (6, 0), energie: 20
Căprioară la (9, 17), energie: 24

Pas 5:
Girafă (Erbivor) s-a mutat la (3, 7)
Zebră (Erbivor) s-a mutat la (15, 18)
Bizon (Erbivor) s-a mutat la (3, 10)
Vulpe (Carnivor) s-a mutat la (7, 17)
Lup (Carnivor) s-a mutat la (0, 0)
Lup (Carnivor) s-a mutat la (18, 13)
Leu (Carnivor) s-a mutat la (16, 7)
Căprioară (Erbivor) s-a mutat la (9, 16)

Harta ecosistemului:
C . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . . . . . . . . . . 
. . . . . . . E . . E . . . . . . . . . 
. . . . . . . . . . . . . . . . . P . . 
. . . . . . . . . . . . . . . . . . O . 
P . . . . . . . . . . . . . . . . E . . 
. . . . . . . . . . . P . . . . . C . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . E . . . 
. . . . . . . . . . . . . . P . . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
P . . . . . . . P . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . E . 
. . . . . . . C . . . . . P P . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . C E . E . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 20
Planta1 la (16, 14), energie: 20
Planta4 la (16, 13), energie: 20
Planta5 la (10, 14), energie: 20
Planta6 la (14, 0), energie: 20
Planta8 la (7, 11), energie: 20
Planta9 la (11, 15), energie: 20
Girafă la (3, 7), energie: 40
Zebră la (15, 18), energie: 20
Bizon la (3, 10), energie: 20
Vulpe la (7, 17), energie: 43
Lup la (0, 0), energie: 30
Lup la (18, 13), energie: 54
Leu la (16, 7), energie: 30
Planta0 la (14, 8), energie: 20
Planta1 la (6, 0), energie: 20
Căprioară la (9, 16), energie: 22

Pas 6:

Un nou grup de entități apare!
Girafă (Erbivor) s-a mutat la (3, 8)
Zebră (Erbivor) s-a mutat la (15, 18)
Bizon (Erbivor) s-a mutat la (3, 10)
Vulpe (Carnivor) s-a mutat la (6, 18)
Lup (Carnivor) s-a mutat la (0, 0)
Lup (Carnivor) s-a mutat la (17, 13)
Leu (Carnivor) s-a mutat la (17, 7)
Căprioară (Erbivor) s-a mutat la (8, 16)
Bizon (Erbivor) s-a mutat la (5, 10)
Căprioară (Erbivor) s-a mutat la (14, 5)

Harta ecosistemului:
C . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . P . . . . . . . . 
. . . . . . . . E . E . . . . . . . . . 
. . . . . . . . . . . . . . . . . P . . 
. . . . . . . . . . E . . . . . . . O . 
P . . . . . . . . . . . . . . . . E C . 
. . . . . . . . . . . P . . . . . . . . 
. . . . . . . . . . . . . . . . E . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . P . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
P . . . . E . . P . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . E . 
. . . . . P . . . . . . . P P . . . . . 
. . . . . . . C . . . . . C . . . . . . 
. . . . . . . . . . . . . . E . E . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 20
Planta1 la (16, 14), energie: 20
Planta4 la (16, 13), energie: 20
Planta5 la (10, 14), energie: 20
Planta6 la (14, 0), energie: 20
Planta8 la (7, 11), energie: 20
Planta9 la (11, 15), energie: 20
Girafă la (3, 8), energie: 38
Zebră la (15, 18), energie: 18
Bizon la (3, 10), energie: 18
Vulpe la (6, 18), energie: 41
Lup la (0, 0), energie: 28
Lup la (17, 13), energie: 52
Leu la (17, 7), energie: 28
Planta0 la (14, 8), energie: 20
Planta1 la (6, 0), energie: 20
Căprioară la (8, 16), energie: 20
Planta0 la (12, 2), energie: 20
Planta1 la (16, 5), energie: 20
Planta2 la (2, 11), energie: 20
Bizon la (5, 10), energie: 28
Căprioară la (14, 5), energie: 28

Pas 7:
Girafă (Erbivor) s-a mutat la (4, 9)
Zebră (Erbivor) s-a mutat la (15, 19)
Bizon (Erbivor) s-a mutat la (2, 11)
Bizon a mâncat planta Planta2 și a câștigat energie: 36
Vulpe (Carnivor) s-a mutat la (6, 18)
Lup (Carnivor) s-a mutat la (0, 0)
Lup (Carnivor) s-a mutat la (17, 13)
Leu (Carnivor) s-a mutat la (17, 6)
Căprioară (Erbivor) s-a mutat la (7, 16)
Bizon (Erbivor) s-a mutat la (4, 10)
Căprioară (Erbivor) s-a mutat la (15, 5)
Căprioară a mâncat planta Planta1 și a câștigat energie: 46
Planta2 a fost consumat.
Planta1 a fost consumat.

Harta ecosistemului:
C . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . E . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . E E . . . . . . P . . 
. . . . . . . . . . . . . . . . . . O . 
P . . . . . . . . . . . . . . . . E C . 
. . . . . . . . . . . P . . . . E . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . P . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
P . . . . . . . P . . . . . . . . . . . 
. . . . . E . . . . . . . . . . . . . E 
. . . . . P . . . . . . . P P . . . . . 
. . . . . . C . . . . . . C . . . . . . 
. . . . . . . . . . . . . . E . E . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 20
Planta1 la (16, 14), energie: 20
Planta4 la (16, 13), energie: 20
Planta5 la (10, 14), energie: 20
Planta6 la (14, 0), energie: 20
Planta8 la (7, 11), energie: 20
Planta9 la (11, 15), energie: 20
Girafă la (4, 9), energie: 36
Zebră la (15, 19), energie: 16
Bizon la (2, 11), energie: 36
Vulpe la (6, 18), energie: 39
Lup la (0, 0), energie: 26
Lup la (17, 13), energie: 50
Leu la (17, 6), energie: 26
Planta0 la (14, 8), energie: 20
Planta1 la (6, 0), energie: 20
Căprioară la (7, 16), energie: 18
Planta0 la (12, 2), energie: 20
Bizon la (4, 10), energie: 26
Căprioară la (15, 5), energie: 46

Pas 8:

Secetă! Plantele pierd energie!
Girafă (Erbivor) s-a mutat la (3, 8)
Zebră (Erbivor) s-a mutat la (16, 18)
Bizon (Erbivor) s-a mutat la (3, 11)
Vulpe (Carnivor) s-a mutat la (5, 17)
Lup (Carnivor) s-a mutat la (0, 0)
Lup (Carnivor) s-a mutat la (18, 13)
Leu (Carnivor) s-a mutat la (16, 7)
Căprioară (Erbivor) s-a mutat la (8, 16)
Bizon (Erbivor) s-a mutat la (5, 9)
Căprioară (Erbivor) s-a mutat la (14, 5)

Harta ecosistemului:
C . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . . . . . . . . . . 
. . . . . . . . E . . E . . . . . . . . 
. . . . . . . . . . . . . . . . . P . . 
. . . . . . . . . E . . . . . . . C O . 
P . . . . . . . . . . . . . . . . E . . 
. . . . . . . . . . . P . . . . . . . . 
. . . . . . . . . . . . . . . . E . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . P . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
P . . . . E . . P . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . P . C . . . . . P P . . . E . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . C E . E . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 10
Planta1 la (16, 14), energie: 10
Planta4 la (16, 13), energie: 10
Planta5 la (10, 14), energie: 10
Planta6 la (14, 0), energie: 10
Planta8 la (7, 11), energie: 10
Planta9 la (11, 15), energie: 10
Girafă la (3, 8), energie: 34
Zebră la (16, 18), energie: 14
Bizon la (3, 11), energie: 34
Vulpe la (5, 17), energie: 37
Lup la (0, 0), energie: 24
Lup la (18, 13), energie: 48
Leu la (16, 7), energie: 24
Planta0 la (14, 8), energie: 10
Planta1 la (6, 0), energie: 10
Căprioară la (8, 16), energie: 16
Planta0 la (12, 2), energie: 10
Bizon la (5, 9), energie: 24
Căprioară la (14, 5), energie: 44

Pas 9:
Girafă (Erbivor) s-a mutat la (4, 9)
Zebră (Erbivor) s-a mutat la (15, 19)
Bizon (Erbivor) s-a mutat la (2, 11)
Vulpe (Carnivor) s-a mutat la (6, 18)
Lup (Carnivor) s-a mutat la (1, 0)
Lup (Carnivor) s-a mutat la (18, 14)
Leu (Carnivor) s-a mutat la (17, 6)
Căprioară (Erbivor) s-a mutat la (9, 16)
Bizon (Erbivor) s-a mutat la (4, 8)
Căprioară (Erbivor) s-a mutat la (14, 6)

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
C . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . E . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . E E . . . . . . . P . . 
. . . . . . . . . . . . . . . . . . O . 
P . . . . . . . . . . . . . . . . E C . 
. . . . . . . . . . . P . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . E . . . 
. . . . . . . . . . . . . . P . . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . P . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
P . . . . . E . P . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . E 
. . . . . P . . . . . . . P P . . . . . 
. . . . . . C . . . . . . . . . . . . . 
. . . . . . . . . . . . . . C . E . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 10
Planta1 la (16, 14), energie: 10
Planta4 la (16, 13), energie: 10
Planta5 la (10, 14), energie: 10
Planta6 la (14, 0), energie: 10
Planta8 la (7, 11), energie: 10
Planta9 la (11, 15), energie: 10
Girafă la (4, 9), energie: 32
Zebră la (15, 19), energie: 12
Bizon la (2, 11), energie: 32
Vulpe la (6, 18), energie: 35
Lup la (1, 0), energie: 22
Lup la (18, 14), energie: 46
Leu la (17, 6), energie: 22
Planta0 la (14, 8), energie: 10
Planta1 la (6, 0), energie: 10
Căprioară la (9, 16), energie: 14
Planta0 la (12, 2), energie: 10
Bizon la (4, 8), energie: 22
Căprioară la (14, 6), energie: 42

Pas 10:
Girafă (Erbivor) s-a mutat la (4, 8)
Zebră (Erbivor) s-a mutat la (16, 19)
Bizon (Erbivor) s-a mutat la (3, 11)
Vulpe (Carnivor) s-a mutat la (6, 18)
Lup (Carnivor) s-a mutat la (0, 0)
Lup (Carnivor) s-a mutat la (17, 13)
Leu (Carnivor) s-a mutat la (17, 5)
Căprioară (Erbivor) s-a mutat la (10, 15)
Căprioară a mâncat planta Planta5 și a câștigat energie: 22
Bizon (Erbivor) s-a mutat la (3, 7)
Căprioară (Erbivor) s-a mutat la (13, 5)
Planta5 a fost consumat.

Harta ecosistemului:
C . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . P . 
O . . . O . . . . . . . . . . . . . . . 
. . . . . . . E . . . E . . . . . . . . 
. . . . . . . . . . . . . . . . . P . . 
. . . . . . . . . . . . . . . . . . O . 
P . . . . . . . . . . . . . . . . E C . 
. . . . . . . . . . . P . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P E . . . . 
. . . . . . . . . . . . . . . P . . . . 
. . P . . . . . . . . . . . . . . . . . 
. . . . . E . . . . . . . . . . . . . . 
P . . . . . . . P . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . P . . . . . . . P P . . . . E 
. . . . . C . . . . . . . C . . . . . . 
. . . . . . . . . . . . . . . . E . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (1, 18), energie: 10
Planta1 la (16, 14), energie: 10
Planta4 la (16, 13), energie: 10
Planta6 la (14, 0), energie: 10
Planta8 la (7, 11), energie: 10
Planta9 la (11, 15), energie: 10
Girafă la (4, 8), energie: 30
Zebră la (16, 19), energie: 10
Bizon la (3, 11), energie: 30
Vulpe la (6, 18), energie: 33
Lup la (0, 0), energie: 20
Lup la (17, 13), energie: 44
Leu la (17, 5), energie: 20
Planta0 la (14, 8), energie: 10
Planta1 la (6, 0), energie: 10
Căprioară la (10, 15), energie: 22
Planta0 la (12, 2), energie: 10
Bizon la (3, 7), energie: 20
Căprioară la (13, 5), energie: 40
```

### Simularea 1- 10 plante, 6 erbivore, 4 carnovore, 3 omnivore
  
```
Pas 1:
Zebră (Erbivor) s-a mutat la (12, 17)
Elefant (Erbivor) s-a mutat la (5, 9)
Elefant (Erbivor) s-a mutat la (15, 14)
Elefant (Erbivor) s-a mutat la (12, 12)
Căprioară (Erbivor) s-a mutat la (15, 16)
Căprioară (Erbivor) s-a mutat la (13, 4)
Tigru (Carnivor) s-a mutat la (8, 16)
Lup (Carnivor) s-a mutat la (14, 8)
Pisică Sălbatică (Carnivor) s-a mutat la (8, 19)
Pisică Sălbatică (Carnivor) s-a mutat la (11, 2)
Corb (Omnivor) s-a mutat la (9, 2)
Corb a mâncat Corb și a câștigat energie: 0
Corb (Omnivor) s-a mutat la (1, 1)
Corb a mâncat Corb și a câștigat energie: 0
Corb (Omnivor) s-a mutat la (16, 1)
Corb a mâncat Corb și a câștigat energie: 0
Corb a fost consumat.
Corb a fost consumat.
Corb a fost consumat.

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . E . . . . . . . . . . 
. . P . P . . . . . . . . . . . P . . . 
. . . . . . . P . . . . . . P . . . . . 
. . . . . . . . . . . P . . . . C . . C 
. . O . . . . . . . . . . . . . . . . . 
. . . . . . . . . . P . . . . . . . . . 
. . C . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . E . . . . E . . 
. . . . E . . . . . . . . . . . . . . . 
. . . . . . . . C . . . . . . . . . . . 
. . . . . . . . . . . . . . E . E . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (6, 16), energie: 20
Planta1 la (7, 14), energie: 20
Planta2 la (18, 13), energie: 20
Planta3 la (6, 4), energie: 20
Planta4 la (7, 7), energie: 20
Planta5 la (8, 11), energie: 20
Planta6 la (10, 10), energie: 20
Planta7 la (6, 2), energie: 20
Planta8 la (18, 2), energie: 20
Planta9 la (18, 13), energie: 20
Zebră la (12, 17), energie: 28
Elefant la (5, 9), energie: 28
Elefant la (15, 14), energie: 28
Elefant la (12, 12), energie: 28
Căprioară la (15, 16), energie: 28
Căprioară la (13, 4), energie: 28
Tigru la (8, 16), energie: 38
Lup la (14, 8), energie: 38
Pisică Sălbatică la (8, 19), energie: 38
Pisică Sălbatică la (11, 2), energie: 38

Pas 2:
Zebră (Erbivor) s-a mutat la (11, 18)
Elefant (Erbivor) s-a mutat la (6, 9)
Elefant (Erbivor) s-a mutat la (15, 15)
Elefant (Erbivor) s-a mutat la (12, 11)
Căprioară (Erbivor) s-a mutat la (15, 15)
Căprioară (Erbivor) s-a mutat la (13, 4)
Tigru (Carnivor) s-a mutat la (7, 16)
Lup (Carnivor) s-a mutat la (14, 8)
Pisică Sălbatică (Carnivor) s-a mutat la (7, 19)
Pisică Sălbatică (Carnivor) s-a mutat la (11, 2)

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . P . . . . E . . . . . . P . . . 
. . . . . . . P . . . . . . P . C . . C 
. . . . . . . . . . . P . . . . . . . . 
. . O . . . . . . . . . . . . . . . . . 
. . . . . . . . . . P . . . . . . . . . 
. . C . . . . . . . . . . . . . . . E . 
. . . . . . . . . . . E . . . . . . . . 
. . . . E . . . . . . . . . . . . . . . 
. . . . . . . . C . . . . . . . . . . . 
. . . . . . . . . . . . . . . E . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (6, 16), energie: 20
Planta1 la (7, 14), energie: 20
Planta2 la (18, 13), energie: 20
Planta3 la (6, 4), energie: 20
Planta4 la (7, 7), energie: 20
Planta5 la (8, 11), energie: 20
Planta6 la (10, 10), energie: 20
Planta7 la (6, 2), energie: 20
Planta8 la (18, 2), energie: 20
Planta9 la (18, 13), energie: 20
Zebră la (11, 18), energie: 26
Elefant la (6, 9), energie: 26
Elefant la (15, 15), energie: 26
Elefant la (12, 11), energie: 26
Căprioară la (15, 15), energie: 26
Căprioară la (13, 4), energie: 26
Tigru la (7, 16), energie: 36
Lup la (14, 8), energie: 36
Pisică Sălbatică la (7, 19), energie: 36
Pisică Sălbatică la (11, 2), energie: 36

Pas 3:
Zebră (Erbivor) s-a mutat la (10, 19)
Elefant (Erbivor) s-a mutat la (6, 8)
Elefant (Erbivor) s-a mutat la (15, 16)
Elefant (Erbivor) s-a mutat la (13, 10)
Căprioară (Erbivor) s-a mutat la (15, 16)
Căprioară (Erbivor) s-a mutat la (13, 4)
Tigru (Carnivor) s-a mutat la (8, 17)
Lup (Carnivor) s-a mutat la (15, 9)
Pisică Sălbatică (Carnivor) s-a mutat la (7, 19)
Pisică Sălbatică (Carnivor) s-a mutat la (10, 3)

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . P . . . E . . . . . . . P . . . 
. . . . . . . P . . . . . . P . . . . C 
. . . . . . . . . . . P . . . . . C . . 
. . O . . . . . . . . . . . . . . . . . 
. . . C . . . . . . P . . . . . . . . E 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . E . . . . . E . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . C . . . . . . E . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (6, 16), energie: 20
Planta1 la (7, 14), energie: 20
Planta2 la (18, 13), energie: 20
Planta3 la (6, 4), energie: 20
Planta4 la (7, 7), energie: 20
Planta5 la (8, 11), energie: 20
Planta6 la (10, 10), energie: 20
Planta7 la (6, 2), energie: 20
Planta8 la (18, 2), energie: 20
Planta9 la (18, 13), energie: 20
Zebră la (10, 19), energie: 24
Elefant la (6, 8), energie: 24
Elefant la (15, 16), energie: 24
Elefant la (13, 10), energie: 24
Căprioară la (15, 16), energie: 24
Căprioară la (13, 4), energie: 24
Tigru la (8, 17), energie: 34
Lup la (15, 9), energie: 34
Pisică Sălbatică la (7, 19), energie: 34
Pisică Sălbatică la (10, 3), energie: 34

Pas 4:
Zebră (Erbivor) s-a mutat la (9, 19)
Elefant (Erbivor) s-a mutat la (5, 7)
Elefant (Erbivor) s-a mutat la (15, 16)
Elefant (Erbivor) s-a mutat la (13, 10)
Căprioară (Erbivor) s-a mutat la (14, 15)
Căprioară (Erbivor) s-a mutat la (14, 3)
Tigru (Carnivor) s-a mutat la (8, 17)
Lup (Carnivor) s-a mutat la (14, 10)
Lup a vânat Elefant și a câștigat energie: 43
Pisică Sălbatică (Carnivor) s-a mutat la (7, 18)
Pisică Sălbatică (Carnivor) s-a mutat la (9, 3)
Elefant a fost consumat.

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . E . . . . . . . . . . . . 
. . P . P . . . . . . . . . . . P . . . 
. . . . . . . P . . . . . . P . . . C . 
. . . . . . . . . . . P . . . . . C . . 
. . O C . . . . . . . . . . . . . . . E 
. . . . . . . . . . P . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . E . . . . . . . . . 
. . . E . . . . . . C . . . . E . . . . 
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (6, 16), energie: 20
Planta1 la (7, 14), energie: 20
Planta2 la (18, 13), energie: 20
Planta3 la (6, 4), energie: 20
Planta4 la (7, 7), energie: 20
Planta5 la (8, 11), energie: 20
Planta6 la (10, 10), energie: 20
Planta7 la (6, 2), energie: 20
Planta8 la (18, 2), energie: 20
Planta9 la (18, 13), energie: 20
Zebră la (9, 19), energie: 22
Elefant la (5, 7), energie: 22
Elefant la (15, 16), energie: 22
Căprioară la (14, 15), energie: 22
Căprioară la (14, 3), energie: 22
Tigru la (8, 17), energie: 32
Lup la (14, 10), energie: 43
Pisică Sălbatică la (7, 18), energie: 32
Pisică Sălbatică la (9, 3), energie: 32

Pas 5:
Zebră (Erbivor) s-a mutat la (8, 19)
Elefant (Erbivor) s-a mutat la (5, 6)
Elefant (Erbivor) s-a mutat la (14, 17)
Căprioară (Erbivor) s-a mutat la (14, 16)
Căprioară (Erbivor) s-a mutat la (14, 3)
Tigru (Carnivor) s-a mutat la (7, 17)
Lup (Carnivor) s-a mutat la (14, 11)
Pisică Sălbatică (Carnivor) s-a mutat la (7, 17)
Pisică Sălbatică (Carnivor) s-a mutat la (10, 2)

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . E . . . . . . . . . . . . . 
. . P . P . . . . . . . . . . . P . . . 
. . . . . . . P . . . . . . P . . C . . 
. . . . . . . . . . . P . . . . . . . E 
. . O . . . . . . . . . . . . . . . . . 
. . C . . . . . . . P . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . E . . . . . . . . . 
. . . E . . . . . . . C . . . . E E . . 
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (6, 16), energie: 20
Planta1 la (7, 14), energie: 20
Planta2 la (18, 13), energie: 20
Planta3 la (6, 4), energie: 20
Planta4 la (7, 7), energie: 20
Planta5 la (8, 11), energie: 20
Planta6 la (10, 10), energie: 20
Planta7 la (6, 2), energie: 20
Planta8 la (18, 2), energie: 20
Planta9 la (18, 13), energie: 20
Zebră la (8, 19), energie: 20
Elefant la (5, 6), energie: 20
Elefant la (14, 17), energie: 20
Căprioară la (14, 16), energie: 20
Căprioară la (14, 3), energie: 20
Tigru la (7, 17), energie: 30
Lup la (14, 11), energie: 41
Pisică Sălbatică la (7, 17), energie: 30
Pisică Sălbatică la (10, 2), energie: 30

Pas 6:
Zebră (Erbivor) s-a mutat la (7, 19)
Elefant (Erbivor) s-a mutat la (6, 6)
Elefant (Erbivor) s-a mutat la (13, 16)
Căprioară (Erbivor) s-a mutat la (14, 16)
Căprioară (Erbivor) s-a mutat la (13, 2)
Tigru (Carnivor) s-a mutat la (6, 16)
Lup (Carnivor) s-a mutat la (15, 11)
Pisică Sălbatică (Carnivor) s-a mutat la (8, 18)
Pisică Sălbatică (Carnivor) s-a mutat la (10, 2)

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . P . E . . . . . . . . . C . . . 
. . . . . . . P . . . . . . P . . . . E 
. . . . . . . . . . . P . . . . . . C . 
. . O . . . . . . . . . . . . . . . . . 
. . C . . . . . . . P . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . E . . . . . . . E . . . . . E . . . 
. . . . . . . . . . . . . . . . E . . . 
. . . . . . . . . . . C . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (6, 16), energie: 20
Planta1 la (7, 14), energie: 20
Planta2 la (18, 13), energie: 20
Planta3 la (6, 4), energie: 20
Planta4 la (7, 7), energie: 20
Planta5 la (8, 11), energie: 20
Planta6 la (10, 10), energie: 20
Planta7 la (6, 2), energie: 20
Planta8 la (18, 2), energie: 20
Planta9 la (18, 13), energie: 20
Zebră la (7, 19), energie: 18
Elefant la (6, 6), energie: 18
Elefant la (13, 16), energie: 18
Căprioară la (14, 16), energie: 18
Căprioară la (13, 2), energie: 18
Tigru la (6, 16), energie: 28
Lup la (15, 11), energie: 39
Pisică Sălbatică la (8, 18), energie: 28
Pisică Sălbatică la (10, 2), energie: 28

Pas 7:

Furtună! Toate entitățile pierd energie!
Zebră (Erbivor) s-a mutat la (7, 19)
Elefant (Erbivor) s-a mutat la (7, 5)
Elefant (Erbivor) s-a mutat la (14, 16)
Căprioară (Erbivor) s-a mutat la (15, 17)
Căprioară (Erbivor) s-a mutat la (13, 2)
Tigru (Carnivor) s-a mutat la (7, 15)
Lup (Carnivor) s-a mutat la (16, 12)
Pisică Sălbatică (Carnivor) s-a mutat la (9, 18)
Pisică Sălbatică (Carnivor) s-a mutat la (11, 1)

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . P . . . . . . . . . . . . . . . 
. . . . . E . P . . . . . . P C . . . E 
. . . . . . . . . . . P . . . . . . . . 
. . O . . . . . . . . . . . . . . . C . 
. . . . . . . . . . P . . . . . . . . . 
. C . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . E . . . . . . . E . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . E . . 
. O . . . . . . . . . . C . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (6, 16), energie: 14
Planta1 la (7, 14), energie: 8
Planta2 la (18, 13), energie: 9
Planta3 la (6, 4), energie: 9
Planta4 la (7, 7), energie: 11
Planta5 la (8, 11), energie: 9
Planta6 la (10, 10), energie: 7
Planta7 la (6, 2), energie: 10
Planta8 la (18, 2), energie: 14
Planta9 la (18, 13), energie: 7
Zebră la (7, 19), energie: 9
Elefant la (7, 5), energie: 2
Elefant la (14, 16), energie: 7
Căprioară la (15, 17), energie: 6
Căprioară la (13, 2), energie: 6
Tigru la (7, 15), energie: 19
Lup la (16, 12), energie: 23
Pisică Sălbatică la (9, 18), energie: 19
Pisică Sălbatică la (11, 1), energie: 15

Pas 8:
Zebră (Erbivor) s-a mutat la (7, 18)
Elefant (Erbivor) s-a mutat la (7, 6)
Elefant a mâncat planta Planta4 și a câștigat energie: 11
Elefant (Erbivor) s-a mutat la (13, 15)
Căprioară (Erbivor) s-a mutat la (14, 16)
Căprioară (Erbivor) s-a mutat la (12, 2)
Tigru (Carnivor) s-a mutat la (8, 15)
Lup (Carnivor) s-a mutat la (15, 12)
Pisică Sălbatică (Carnivor) s-a mutat la (10, 19)
Pisică Sălbatică (Carnivor) s-a mutat la (12, 0)
Planta4 a fost consumat.

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . P . . . . . . . . . . . . . . . 
. . . . . . E P . . . . . . P . . . E . 
. . . . . . . . . . . P . . . C . . . . 
. . O . . . . . . . . . . . . . . . . . 
. . . . . . . . . . P . . . . . . . . C 
. . . . . . . . . . . . . . . . . . . . 
C . E . . . . . . . . . . . . . . . . . 
. . . . . . . . . . E . . . . E . . . . 
. . . . . . . . . . . . . . . . E . . . 
. . . . . . . . . . . . C . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (6, 16), energie: 14
Planta1 la (7, 14), energie: 8
Planta2 la (18, 13), energie: 9
Planta3 la (6, 4), energie: 9
Planta5 la (8, 11), energie: 9
Planta6 la (10, 10), energie: 7
Planta7 la (6, 2), energie: 10
Planta8 la (18, 2), energie: 14
Planta9 la (18, 13), energie: 7
Zebră la (7, 18), energie: 7
Elefant la (7, 6), energie: 11
Elefant la (13, 15), energie: 5
Căprioară la (14, 16), energie: 4
Căprioară la (12, 2), energie: 4
Tigru la (8, 15), energie: 17
Lup la (15, 12), energie: 21
Pisică Sălbatică la (10, 19), energie: 17
Pisică Sălbatică la (12, 0), energie: 13

Pas 9:
Zebră (Erbivor) s-a mutat la (6, 17)
Zebră a mâncat planta Planta0 și a câștigat energie: 19
Elefant (Erbivor) s-a mutat la (6, 7)
Elefant (Erbivor) s-a mutat la (12, 15)
Căprioară (Erbivor) s-a mutat la (14, 17)
Căprioară (Erbivor) s-a mutat la (13, 1)
Tigru (Carnivor) s-a mutat la (7, 15)
Lup (Carnivor) s-a mutat la (16, 13)
Pisică Sălbatică (Carnivor) s-a mutat la (11, 19)
Pisică Sălbatică (Carnivor) s-a mutat la (12, 0)
Planta0 a fost consumat.

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . P . . E . . . . . . . . . E . . 
. . . . . . . P . . . . . . P C . . . . 
. . . . . . . . . . . P . . . . . . . . 
. . O . . . . . . . . . . . . . . . . . 
. . . . . . . . . . P . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . C 
C . . . . . . . . . . . . . . E . . . . 
. E . . . . . . . . E . . . . . . . . . 
. . . . . . . . . . . . . . . . . E . . 
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . C . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta1 la (7, 14), energie: 8
Planta2 la (18, 13), energie: 9
Planta3 la (6, 4), energie: 9
Planta5 la (8, 11), energie: 9
Planta6 la (10, 10), energie: 7
Planta7 la (6, 2), energie: 10
Planta8 la (18, 2), energie: 14
Planta9 la (18, 13), energie: 7
Zebră la (6, 17), energie: 19
Elefant la (6, 7), energie: 9
Elefant la (12, 15), energie: 3
Căprioară la (14, 17), energie: 2
Căprioară la (13, 1), energie: 2
Tigru la (7, 15), energie: 15
Lup la (16, 13), energie: 19
Pisică Sălbatică la (11, 19), energie: 15
Pisică Sălbatică la (12, 0), energie: 11

Pas 10:

Un nou grup de entități apare!
Zebră (Erbivor) s-a mutat la (6, 18)
Elefant (Erbivor) s-a mutat la (5, 7)
Elefant (Erbivor) s-a mutat la (12, 14)
Căprioară (Erbivor) s-a mutat la (13, 17)
Căprioară (Erbivor) s-a mutat la (12, 1)
Tigru (Carnivor) s-a mutat la (8, 14)
Lup (Carnivor) s-a mutat la (16, 12)
Pisică Sălbatică (Carnivor) s-a mutat la (10, 18)
Pisică Sălbatică (Carnivor) s-a mutat la (12, 1)
Pisică Sălbatică a vânat Căprioară și a câștigat energie: 9
Căprioară (Erbivor) s-a mutat la (5, 14)
Căprioară a fost consumat.

Harta ecosistemului:
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . E . . . . . . E . . . . . 
. . P . P . . . . . . . . . . . P . E . 
. . . . . . . P . . . . . . P . . . . . 
. . . . . . . . . . . P . . C . . . . . 
. . O . . . . . . . . . . . . . . . . . 
. . . . . . . . . . P . . . . . . . C . 
. . . . . . . . . . . . . . . . . . . . 
. C . . . . . . . . . . . . E . . . . . 
. . . P . . . . . . E . . . . . . E . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. O . . . . . . . . . . C . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . P . . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta1 la (7, 14), energie: 8
Planta2 la (18, 13), energie: 9
Planta3 la (6, 4), energie: 9
Planta5 la (8, 11), energie: 9
Planta6 la (10, 10), energie: 7
Planta7 la (6, 2), energie: 10
Planta8 la (18, 2), energie: 14
Planta9 la (18, 13), energie: 7
Zebră la (6, 18), energie: 17
Elefant la (5, 7), energie: 7
Elefant la (12, 14), energie: 1
Tigru la (8, 14), energie: 13
Lup la (16, 12), energie: 17
Pisică Sălbatică la (10, 18), energie: 13
Pisică Sălbatică la (12, 1), energie: 9
Planta0 la (6, 16), energie: 20
Planta1 la (13, 3), energie: 20
Căprioară la (5, 14), energie: 28
```

### Simularea 1- 20 plante, 10 erbivore, 0 carnovore, 5 omnivore
```
Pas 1:
Girafă (Erbivor) s-a mutat la (5, 5)
Zebră (Erbivor) s-a mutat la (14, 0)
Zebră a mâncat planta Planta15 și a câștigat energie: 48
Elefant (Erbivor) s-a mutat la (3, 7)
Căprioară (Erbivor) s-a mutat la (18, 16)
Căprioară a mâncat planta Planta11 și a câștigat energie: 48
Bizon (Erbivor) s-a mutat la (9, 8)
Căprioară (Erbivor) s-a mutat la (4, 19)
Căprioară (Erbivor) s-a mutat la (18, 0)
Căprioară (Erbivor) s-a mutat la (7, 14)
Girafă (Erbivor) s-a mutat la (11, 8)
Iepure (Erbivor) s-a mutat la (19, 19)
Porc Mistret (Omnivor) s-a mutat la (17, 12)
Porc Mistret a mâncat Planta5 și a câștigat energie: 58
Corb (Omnivor) s-a mutat la (6, 11)
Corb a mâncat Corb și a câștigat energie: 0
Corb (Omnivor) s-a mutat la (16, 0)
Corb a mâncat Planta15 și a câștigat energie: 48
Porc Mistret (Omnivor) s-a mutat la (0, 12)
Porc Mistret a mâncat Porc Mistret și a câștigat energie: 0
Porc Mistret (Omnivor) s-a mutat la (8, 6)
Porc Mistret a mâncat Porc Mistret și a câștigat energie: 0
Planta15 a fost consumat.
Planta11 a fost consumat.
Planta5 a fost consumat.
Corb a fost consumat.
Planta15 a fost consumat.
Porc Mistret a fost consumat.
Porc Mistret a fost consumat.

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . P . . E . . . . . . P . . . . . 
. P P . . . P . . . . . . . . . . . . E 
. . . . . E . . . . . . . . . . . . . . 
. . . . . . P . . . . O . . . . . . . . 
. . . . . P . . . . . . . . E . . . . . 
. . . . . . O . . . . . . . . . . . . . 
. . . . . . . . E . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . E . P . P . . . . . P . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
E . . P . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
O . . . . . . P . . . . . . . . . . . . 
. . . . . . . . . . . . O . . P . . . . 
E . . . . . . . P . P . . . . P E . . . 
. . . . . . . . . . . . . . . . . . . E 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta1 la (3, 4), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta7 la (4, 6), energie: 20
Planta8 la (11, 10), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta12 la (0, 6), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Planta19 la (3, 14), energie: 20
Girafă la (5, 5), energie: 28
Zebră la (14, 0), energie: 48
Elefant la (3, 7), energie: 28
Căprioară la (18, 16), energie: 48
Bizon la (9, 8), energie: 28
Căprioară la (4, 19), energie: 28
Căprioară la (18, 0), energie: 28
Căprioară la (7, 14), energie: 28
Girafă la (11, 8), energie: 28
Iepure la (19, 19), energie: 28
Porc Mistret la (17, 12), energie: 58
Corb la (16, 0), energie: 48

Pas 2:
Girafă (Erbivor) s-a mutat la (5, 4)
Zebră (Erbivor) s-a mutat la (13, 0)
Elefant (Erbivor) s-a mutat la (4, 7)
Elefant a mâncat planta Planta7 și a câștigat energie: 46
Căprioară (Erbivor) s-a mutat la (17, 17)
Bizon (Erbivor) s-a mutat la (10, 8)
Căprioară (Erbivor) s-a mutat la (3, 19)
Căprioară (Erbivor) s-a mutat la (18, 0)
Căprioară (Erbivor) s-a mutat la (7, 15)
Girafă (Erbivor) s-a mutat la (10, 7)
Iepure (Erbivor) s-a mutat la (18, 19)
Porc Mistret (Omnivor) s-a mutat la (17, 11)
Porc Mistret a mâncat Porc Mistret și a câștigat energie: 0
Corb (Omnivor) s-a mutat la (16, 0)
Corb a mâncat Corb și a câștigat energie: 0
Planta7 a fost consumat.
Porc Mistret a fost consumat.
Corb a fost consumat.

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . P . . . . . . . . . P . . . . E 
. P P . . . P E . . . . . . . . . . . . 
. . . . E . . . . . . . . . . . . . . . 
. . . . . . P . . . . O . . . . . . . . 
. . . . . P . . . . . . . . . E . . . . 
. . . . . . O . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . E E . . . . . . . . . . . 
. . . . . . . . . . P . P . . . . . P . 
. . . . . . . . . . . . . . . . . . . . 
E . . . . . . . . . . . . . . . . . . . 
. . . P . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
O . . . . . . P . . . . . . . . . . . . 
. . . . . . . . . . . O . . . P . E . . 
E . . . . . . . P . P . . . . P . . . E 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta1 la (3, 4), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta8 la (11, 10), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta12 la (0, 6), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Planta19 la (3, 14), energie: 20
Girafă la (5, 4), energie: 26
Zebră la (13, 0), energie: 46
Elefant la (4, 7), energie: 46
Căprioară la (17, 17), energie: 46
Bizon la (10, 8), energie: 26
Căprioară la (3, 19), energie: 26
Căprioară la (18, 0), energie: 26
Căprioară la (7, 15), energie: 26
Girafă la (10, 7), energie: 26
Iepure la (18, 19), energie: 26

Pas 3:
Girafă (Erbivor) s-a mutat la (4, 5)
Zebră (Erbivor) s-a mutat la (13, 1)
Elefant (Erbivor) s-a mutat la (3, 7)
Căprioară (Erbivor) s-a mutat la (17, 18)
Bizon (Erbivor) s-a mutat la (10, 7)
Căprioară (Erbivor) s-a mutat la (2, 18)
Căprioară (Erbivor) s-a mutat la (18, 0)
Căprioară (Erbivor) s-a mutat la (6, 14)
Girafă (Erbivor) s-a mutat la (11, 8)
Iepure (Erbivor) s-a mutat la (18, 18)

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . E . 
. . . . P . . E . . . . . . P . . . . . 
. P P . . E P . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . P . . . . O . . E . . . . . 
. . . . . P . . . . . . . . . . . . . . 
. . . . . . O . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . E . P . P . . . . . P . 
. . . . . . . . . . . . . . . . . . . . 
. E . . . . . . . . . . . . . . . . . . 
. . . P . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
O . . . . . . P . . . . . . . . . . . . 
. . . . . . . . . . . O . . . P . . E . 
E . . . . . . . P . P . . . . P . . E . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta1 la (3, 4), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta8 la (11, 10), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta12 la (0, 6), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Planta19 la (3, 14), energie: 20
Girafă la (4, 5), energie: 24
Zebră la (13, 1), energie: 44
Elefant la (3, 7), energie: 44
Căprioară la (17, 18), energie: 44
Bizon la (10, 7), energie: 24
Căprioară la (2, 18), energie: 24
Căprioară la (18, 0), energie: 24
Căprioară la (6, 14), energie: 24
Girafă la (11, 8), energie: 24
Iepure la (18, 18), energie: 24

Pas 4:
Girafă (Erbivor) s-a mutat la (4, 4)
Girafă a mâncat planta Planta1 și a câștigat energie: 42
Zebră (Erbivor) s-a mutat la (14, 1)
Elefant (Erbivor) s-a mutat la (4, 7)
Căprioară (Erbivor) s-a mutat la (18, 17)
Bizon (Erbivor) s-a mutat la (9, 7)
Căprioară (Erbivor) s-a mutat la (1, 18)
Căprioară (Erbivor) s-a mutat la (17, 0)
Căprioară (Erbivor) s-a mutat la (5, 15)
Girafă (Erbivor) s-a mutat la (11, 9)
Girafă a mâncat planta Planta8 și a câștigat energie: 42
Iepure (Erbivor) s-a mutat la (19, 19)
Planta1 a fost consumat.
Planta8 a fost consumat.

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . . . 
. . . . . . . . . . . . . . . . . . E . 
. . . . . . . . . . . . . . . . . . . . 
. . . . P . . . . . . . . . P . . . . . 
. P P . E . P E . . . . . . . . . . . . 
. . . . . . . . . . . . . . . E . . . . 
. . . . . . P . . . . O . . . . . . . . 
. . . . . P . . . . . . . . . . . . . . 
. . . . . . O . . . . . . . . . . . . . 
. . . . . . . E . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . E P . P . . . . . P . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. E . P . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
O . . . . . . P . . . . . . . . . . . . 
E . . . . . . . . . . O . . . P . . . . 
. . . . . . . . P . P . . . . P . E . . 
. . . . . . . . . . . . . . . . . . . E 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta12 la (0, 6), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Planta19 la (3, 14), energie: 20
Girafă la (4, 4), energie: 42
Zebră la (14, 1), energie: 42
Elefant la (4, 7), energie: 42
Căprioară la (18, 17), energie: 42
Bizon la (9, 7), energie: 22
Căprioară la (1, 18), energie: 22
Căprioară la (17, 0), energie: 22
Căprioară la (5, 15), energie: 22
Girafă la (11, 9), energie: 42
Iepure la (19, 19), energie: 22

Pas 5:
Girafă (Erbivor) s-a mutat la (3, 4)
Zebră (Erbivor) s-a mutat la (13, 0)
Elefant (Erbivor) s-a mutat la (5, 8)
Căprioară (Erbivor) s-a mutat la (17, 17)
Bizon (Erbivor) s-a mutat la (10, 8)
Căprioară (Erbivor) s-a mutat la (0, 19)
Căprioară (Erbivor) s-a mutat la (16, 1)
Căprioară (Erbivor) s-a mutat la (4, 14)
Căprioară a mâncat planta Planta19 și a câștigat energie: 40
Girafă (Erbivor) s-a mutat la (12, 8)
Iepure (Erbivor) s-a mutat la (18, 19)
Planta19 a fost consumat.

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . . E 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . E . . . . . . . . . P . . . . . 
. P P . . . P . . . . . . . E . . . . . 
. . . . . . . . E . . . . . . . . . . . 
. . . . . . P . . . . O . . . . . . . . 
. . . . . P . . . . . . . . . . . . . . 
. . . . . . O . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . E . . . . . . . . . . . 
. . . . . . . . . . P . P . . . . . P . 
. . . . . . . . E . . . . . . . . . . . 
E . . . . . . . . . . . . . . . . . . . 
. . . P . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
O E . . . . . P . . . . . . . . . . . . 
. . . . . . . . . . . O . . . P . E . . 
. . . . . . . . P . P . . . . P . . . E 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta12 la (0, 6), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Girafă la (3, 4), energie: 40
Zebră la (13, 0), energie: 40
Elefant la (5, 8), energie: 40
Căprioară la (17, 17), energie: 40
Bizon la (10, 8), energie: 20
Căprioară la (0, 19), energie: 20
Căprioară la (16, 1), energie: 20
Căprioară la (4, 14), energie: 40
Girafă la (12, 8), energie: 40
Iepure la (18, 19), energie: 20

Pas 6:
Girafă (Erbivor) s-a mutat la (2, 5)
Zebră (Erbivor) s-a mutat la (14, 0)
Elefant (Erbivor) s-a mutat la (5, 9)
Căprioară (Erbivor) s-a mutat la (18, 18)
Bizon (Erbivor) s-a mutat la (10, 8)
Căprioară (Erbivor) s-a mutat la (0, 19)
Căprioară (Erbivor) s-a mutat la (17, 1)
Căprioară (Erbivor) s-a mutat la (5, 14)
Girafă (Erbivor) s-a mutat la (11, 9)
Iepure (Erbivor) s-a mutat la (17, 19)

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . . E 
. . . . . . . . . . . . . . . . . . . . 
. . . . . E . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. P P . . . P . . . . . . . . . . . . . 
. . . . . . . . . E . . . . E . . . . . 
. . . . . . P . . . . O . . . . . . . . 
. . . . . P . . . . . . . . . . . . . . 
. . . . . . O . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . E . . . . . . . . . . . 
. . . . . . . . . E P . P . . . . . P . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
E . . P . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
O . . . . . . P . . . . . . . . . . . . 
. E . . . . . . . . . O . . . P . . . E 
. . . . . . . . P . P . . . . P . . E . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta12 la (0, 6), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Girafă la (2, 5), energie: 38
Zebră la (14, 0), energie: 38
Elefant la (5, 9), energie: 38
Căprioară la (18, 18), energie: 38
Bizon la (10, 8), energie: 18
Căprioară la (0, 19), energie: 18
Căprioară la (17, 1), energie: 18
Căprioară la (5, 14), energie: 38
Girafă la (11, 9), energie: 38
Iepure la (17, 19), energie: 18

Pas 7:
Girafă (Erbivor) s-a mutat la (2, 6)
Zebră (Erbivor) s-a mutat la (14, 0)
Elefant (Erbivor) s-a mutat la (6, 9)
Căprioară (Erbivor) s-a mutat la (18, 18)
Bizon (Erbivor) s-a mutat la (9, 9)
Căprioară (Erbivor) s-a mutat la (0, 18)
Căprioară (Erbivor) s-a mutat la (16, 0)
Căprioară (Erbivor) s-a mutat la (6, 15)
Girafă (Erbivor) s-a mutat la (12, 9)
Iepure (Erbivor) s-a mutat la (18, 18)

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . E . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . E . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. P P . . . P . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . P . . E . O . . . E . . . . 
. . . . . P . . . . . . . . . . . . . . 
. . . . . . O . . . . . . . . . . . . . 
. . . . . . . . . E . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . P . P . . . . . P . 
. . . . . . . . . E . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
E . . P . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
E . . . . . . P . . . . . . . . . . . . 
. . . . . . . . . . . O . . . P . . . . 
. . . . . . . . P . P . . . . P . . E . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta12 la (0, 6), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Girafă la (2, 6), energie: 36
Zebră la (14, 0), energie: 36
Elefant la (6, 9), energie: 36
Căprioară la (18, 18), energie: 36
Bizon la (9, 9), energie: 16
Căprioară la (0, 18), energie: 16
Căprioară la (16, 0), energie: 16
Căprioară la (6, 15), energie: 36
Girafă la (12, 9), energie: 36
Iepure la (18, 18), energie: 16

Pas 8:
Girafă (Erbivor) s-a mutat la (2, 5)
Zebră (Erbivor) s-a mutat la (13, 0)
Elefant (Erbivor) s-a mutat la (5, 10)
Căprioară (Erbivor) s-a mutat la (18, 17)
Bizon (Erbivor) s-a mutat la (8, 9)
Căprioară (Erbivor) s-a mutat la (1, 19)
Căprioară (Erbivor) s-a mutat la (15, 0)
Căprioară (Erbivor) s-a mutat la (6, 16)
Girafă (Erbivor) s-a mutat la (11, 8)
Iepure (Erbivor) s-a mutat la (17, 18)

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . . . 
. . . . . . . . . . . . . . . . . . . E 
. . . . . E . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. P P . . . P . . . . . . . . . . . . . 
. . . . . . . . . . E . . . . . . . . . 
. . . . . . P . . . . O . . . . E . . . 
. . . . . P . . . . . . . . . . . . . . 
. . . . . . O . . E . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . E . P . P . . . . . P . 
. . . . . . . . . . . . . . . . . . . . 
E . . . . . . . . . . . . . . . . . . . 
. . . P . . . . . . . . . P . . . . . . 
E . . . . . . . . . . . . . . . . . . . 
. . . . . . . P . . . . . . . . . . . . 
. . . . . . . . . . . O . . . P . . E . 
. . . . . . . . P . P . . . . P . E . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta12 la (0, 6), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Girafă la (2, 5), energie: 34
Zebră la (13, 0), energie: 34
Elefant la (5, 10), energie: 34
Căprioară la (18, 17), energie: 34
Bizon la (8, 9), energie: 14
Căprioară la (1, 19), energie: 14
Căprioară la (15, 0), energie: 14
Căprioară la (6, 16), energie: 34
Girafă la (11, 8), energie: 34
Iepure la (17, 18), energie: 14

Pas 9:
Girafă (Erbivor) s-a mutat la (1, 6)
Girafă a mâncat planta Planta12 și a câștigat energie: 52
Zebră (Erbivor) s-a mutat la (12, 0)
Elefant (Erbivor) s-a mutat la (4, 10)
Căprioară (Erbivor) s-a mutat la (18, 16)
Bizon (Erbivor) s-a mutat la (9, 9)
Căprioară (Erbivor) s-a mutat la (0, 19)
Căprioară (Erbivor) s-a mutat la (14, 1)
Căprioară (Erbivor) s-a mutat la (7, 16)
Girafă (Erbivor) s-a mutat la (12, 8)
Iepure (Erbivor) s-a mutat la (17, 17)
Planta12 a fost consumat.

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . . E 
. . . . . . E . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. P P . . . P . . . E . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . P . . . . O . . . . . . . . 
. . . . . P . . . . . . . . . . E . . . 
. . . . . . O . . . . . . . . . . . . . 
. . . . . . . . . E . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . P . P . . . . . P . 
E . . . . . . . E . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. E . P . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . P . . . . . . . . . . . . 
. . . . . . . . . . . O . . . P . E . . 
. . . . . . . . P . P . . . . P E . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Girafă la (1, 6), energie: 52
Zebră la (12, 0), energie: 32
Elefant la (4, 10), energie: 32
Căprioară la (18, 16), energie: 32
Bizon la (9, 9), energie: 12
Căprioară la (0, 19), energie: 12
Căprioară la (14, 1), energie: 12
Căprioară la (7, 16), energie: 32
Girafă la (12, 8), energie: 32
Iepure la (17, 17), energie: 12

Pas 10:
Girafă (Erbivor) s-a mutat la (1, 7)
Zebră (Erbivor) s-a mutat la (11, 1)
Elefant (Erbivor) s-a mutat la (4, 9)
Căprioară (Erbivor) s-a mutat la (17, 17)
Bizon (Erbivor) s-a mutat la (9, 9)
Căprioară (Erbivor) s-a mutat la (0, 19)
Căprioară (Erbivor) s-a mutat la (14, 1)
Căprioară (Erbivor) s-a mutat la (8, 17)
Girafă (Erbivor) s-a mutat la (11, 9)
Iepure (Erbivor) s-a mutat la (17, 17)

Harta ecosistemului:
. . . . . . P . . . . . O . . . . . . E 
. . . . . . . E . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . P . . . . . 
. P P . . . P . . E . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . P . . . . O . . . . . . . . 
. . . . . P . . . . . . . . . . . . . . 
. . . . . . O . . . . . . . . . . E . . 
. . . . . . . . . E . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. E . . . . . . . E P . P . . . . . P . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. E . P . . . . . . . . . P . . . . . . 
. . . . . . . . . . . . . . . . . . . . 
. . . . . . . P . . . . . . . . . . . . 
. . . . . . . . . . . O . . . P . E . . 
. . . . . . . . P . P . . . . P . . . . 
. . . . . . . . . . . . . . . . . . . . 

Starea ecosistemului:
Planta0 la (14, 13), energie: 20
Planta2 la (16, 7), energie: 20
Planta3 la (18, 8), energie: 20
Planta4 la (6, 6), energie: 20
Planta6 la (11, 18), energie: 20
Planta9 la (11, 12), energie: 20
Planta10 la (14, 3), energie: 20
Planta13 la (4, 2), energie: 20
Planta14 la (7, 5), energie: 20
Planta16 la (4, 1), energie: 20
Planta17 la (18, 10), energie: 20
Planta18 la (17, 15), energie: 20
Girafă la (1, 7), energie: 50
Zebră la (11, 1), energie: 30
Elefant la (4, 9), energie: 30
Căprioară la (17, 17), energie: 30
Bizon la (9, 9), energie: 10
Căprioară la (0, 19), energie: 10
Căprioară la (14, 1), energie: 10
Căprioară la (8, 17), energie: 30
Girafă la (11, 9), energie: 30
Iepure la (17, 17), energie: 10
```

