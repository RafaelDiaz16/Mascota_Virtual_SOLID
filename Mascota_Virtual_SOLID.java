public class Mascota_Virtual_SOLID {

    interface CuidadoMascota {
        void aplicar(Mascota mascota);
    }

    interface Impresor {
        void imprimir(Mascota mascota);
    }

    static class Mascota {
        public String nombre;
        public int energia;
        public int felicidad;
        public int higiene;

        public Mascota(String nombre, int energia, int felicidad, int higiene) {
            this.nombre = nombre;
            this.energia = energia;
            this.felicidad = felicidad;
            this.higiene = higiene;
        }

        public void aplicarCuidado(CuidadoMascota cuidado) {
            cuidado.aplicar(this);
        }
    }

    static class CuidadoAlimentar implements CuidadoMascota {
        @Override
        public void aplicar(Mascota mascota) {
            mascota.energia += 20;
            mascota.felicidad += 5;
        }
    }

    static class CuidadoPasear implements CuidadoMascota {
        @Override
        public void aplicar(Mascota mascota) {
            mascota.felicidad += 15;
            mascota.energia -= 10;
            mascota.higiene -= 5;
        }
    }

    static class CuidadoDormir implements CuidadoMascota {
        @Override
        public void aplicar(Mascota mascota) {
            mascota.energia += 25;
            mascota.felicidad += 5;
            mascota.higiene -= 3;
        }
    }

    static class CuidadoBanar implements CuidadoMascota {
        @Override
        public void aplicar(Mascota mascota) {
            mascota.higiene += 20;
            mascota.felicidad -= 2;
        }
    }
    
    static class CuidadoJugar implements CuidadoMascota {
    @Override
    public void aplicar(Mascota mascota) {
        mascota.felicidad += 10;
        mascota.energia -= 5;
        }
    }

    static class CuidadoComprarAccesorio implements CuidadoMascota {
    @Override
    public void aplicar(Mascota mascota) {
        mascota.felicidad += 8;
        mascota.higiene += 2;  
        }
    }

    static class CuidadoAyudarCrecer implements CuidadoMascota {
    @Override
    public void aplicar(Mascota mascota) {
        mascota.energia += 12;
        mascota.felicidad += 6;
        }
    }

    public static void main(String[] args) {
        Mascota mascota = new Mascota("Firulais", 80, 70, 60);

        CuidadoMascota alimentar = new CuidadoAlimentar();
        CuidadoMascota pasear = new CuidadoPasear();
        CuidadoMascota dormir = new CuidadoDormir();
        CuidadoMascota banar = new CuidadoBanar();

        Impresor impresor = m -> {
            System.out.println("Mascota: " + m.nombre);
            System.out.println("Energía: " + m.energia);
            System.out.println("Felicidad: " + m.felicidad);
            System.out.println("Higiene: " + m.higiene);
            System.out.println("---");
        };

        impresor.imprimir(mascota);
        mascota.aplicarCuidado(alimentar);
        impresor.imprimir(mascota);
        mascota.aplicarCuidado(pasear);
        impresor.imprimir(mascota);
        mascota.aplicarCuidado(dormir);
        impresor.imprimir(mascota);
        mascota.aplicarCuidado(banar);
        impresor.imprimir(mascota);
    }
}