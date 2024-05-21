import java.util.Scanner;

interface Parfum {
    void semprot(String target);
}

class ParfumBadan {
    void semprotBadan(String target) {
        System.out.println("Anda menyemprot " + target + " dengan parfum badan.");
    }
}


class ParfumBaju {
    void semprotBaju(String target) {
        System.out.println("Anda menyemprot " + target + " dengan parfum baju.");
    }
}


class ParfumBadanAdapter implements Parfum {
    private ParfumBadan parfumBadan;

    public ParfumBadanAdapter(ParfumBadan parfumBadan) {
        this.parfumBadan = parfumBadan;
    }

    @Override
    public void semprot(String target) {
        parfumBadan.semprotBadan(target);
    }
}


class ParfumBajuAdapter implements Parfum {
    private ParfumBaju parfumBaju;

    public ParfumBajuAdapter(ParfumBaju parfumBaju) {
        this.parfumBaju = parfumBaju;
    }

    @Override
    public void semprot(String target) {
        parfumBaju.semprotBaju(target);
    }
}

public class Main {
    public static void main(String[] args) {
        
        Parfum parfumBadan = new ParfumBadanAdapter(new ParfumBadan());
        Parfum parfumBaju = new ParfumBajuAdapter(new ParfumBaju());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan target yang ingin disemprot (badan/baju):");
        String target = scanner.nextLine().trim().toLowerCase();
        
        if (target.equals("badan")) {
            parfumBadan.semprot(target);
        } else if (target.equals("baju")) {
            parfumBaju.semprot(target);
        } else {
            System.out.println("Target tidak valid. Masukkan 'badan' atau 'baju'.");
        }
    }
}
