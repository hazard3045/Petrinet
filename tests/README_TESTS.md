# Tests du Réseau de Petri

Ce dossier contient l'implémentation complète des tests pour le réseau de Petri selon les spécifications des sections 7.2 et 7.3.

## Structure des Tests

### 1. TestCreationReseau.java
Tests de manipulation des jetons et création d'arcs simples:

**Tests de manipulation des jetons:**
- `CAJ0`: Ajouter jetons avec N négatif
- `CAJ1`: Ajouter jetons cas nominal  
- `CAJ2`: Enlever plus de jetons que disponibles
- `CAJ3`: Enlever jetons cas nominal

**Tests de création d'arcs simples:**
- `CA0`: Créer arc avec poids positif
- `CA1`: Créer arc avec poids négatif ou nul
- `CA2`: Créer arc avec sommet inexistant
- `CA3`: Créer arc entre sommets de même type

### 2. TestArcsSpeciaux.java
Tests des arcs spéciaux et doublés:

**Tests des arcs spéciaux:**
- `CAE0`: Créer arc zéro cas nominal
- `CAE1`: Créer arc zéro entre places
- `CAV0`: Créer arc videur cas nominal  
- `CAV1`: Créer arc videur entre transitions

**Tests des arcs doublés:**
- `CAD0`: Créer arc doublé simple
- `CAD1`: Créer arc zéro sur arc existant
- `UT0`: Transitions tirables avec arcs doublés insuffisants
- `UT1`: Transitions tirables avec arc simple et arc zéro

### 3. TestActivationReseau.java
Tests d'activation du réseau:

**Tests des transitions simples:**
- `RD2`: Transition simple avec arc sortant
- `RD0`: Transition avec arcs entrant et sortant
- `RD1`: Transition avec transformation de jetons
- `RD3`: Transition avec jetons insuffisants

**Tests des transitions à entrées multiples:**
- `RM0`: Transition multiple cas nominal
- `RM1`: Transition multiple jetons insuffisants

## Fichiers de Support

### RunAllTests.java
Lanceur principal qui exécute tous les tests dans l'ordre logique et fournit un rapport final.

### run_tests.sh
Script bash pour compiler et exécuter automatiquement tous les tests.

## Utilisation

### Exécution Automatique
```bash
cd tests/
./run_tests.sh
```

### Exécution Manuelle

1. **Compilation:**
```bash
cd /home/pmar/Documents/DCL/MAPD/filrouge/Petrinet
javac -cp . *.java
cd tests/
javac -cp ".." *.java
```

2. **Exécution de tous les tests:**
```bash
java -cp ".." RunAllTests
```

3. **Exécution de tests individuels:**
```bash
java -cp ".." TestCreationReseau
java -cp ".." TestArcsSpeciaux  
java -cp ".." TestActivationReseau
```

## Résultats Attendus

Chaque test affiche:
- **PASS**: Test réussi selon les spécifications
- **FAIL**: Test échoué, comportement non conforme
- **ATTENTION**: Comportement inattendu mais non bloquant
- **INFO**: Information complémentaire

## Notes sur l'Implémentation

### Programmation Défensive
Les tests vérifient les cas d'erreur et les situations limites. Certains tests mettent en évidence des manques de validation dans le code existant (ex: acceptation de valeurs négatives).

### Arcs Doublés
Le comportement des arcs doublés est testé selon l'interprétation que plusieurs arcs entre les mêmes sommets cumulent leurs poids.

### Arcs Spéciaux
- **Arc zéro**: Ne consomme pas de jetons, tirable uniquement si la place source est vide
- **Arc videur**: Vide complètement la place source lors du tir

### Limitations Identifiées
Les tests peuvent révéler des comportements non conformes aux spécifications, notamment:
- Manque de validation des poids négatifs
- Absence de vérification des types de sommets pour les arcs spéciaux
- Gestion des conflits entre arcs de types différents

## Conformité aux Spécifications

Tous les tests implémentés correspondent exactement aux codes et descriptions fournis dans les sections 7.2 et 7.3 des instructions.