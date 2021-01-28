public class Fone {
    String id;
    String number;

    public static boolean validateNumber(String numero) {
        String validos = "0123456789()-";
        for (int i = 0; i < numero.length(); i++) {
            if (validos.indexOf(numero.charAt(i)) == -1)
                return false;
        }
        return true;
    }

    public Fone(String serial) {
        String[] brok = serial.split(":");
        if (!validateNumber(brok[1])) {
            System.out.println("Número invalido");
            return;
        }
        this.id = brok[0];
        this.number = brok[1];
    }

    public Fone(String id, String number) {
        if (!validateNumber(number)) {
            System.out.println("Número invalido");
            return;
        }
        this.id = id;
        this.number = number;
    }

    public String toString() {
        return id + ":" + number;
    }

}
