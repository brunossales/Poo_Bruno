import javax.management.RuntimeErrorException;

class Fone {
    private String label;
    private String number;

    public String getLabel() {
        return label;
    }

    public String getNumber() {
        return number;
    }

    public static boolean validaNum(String number) {
        String valida = "0123456789()-";
        for (int i = 0; i < number.length(); i++) {
            if (valida.indexOf(number.charAt(i)) == -1)
                return false;

        }
        return true;
    }

    public Fone(String serial) {
        String brok[] = serial.split(":");
        if (!validaNum(brok[1])) {
            throw new IndexOutOfBoundsException("Erro, número não é valido");
        }
        this.label = brok[0];
        this.number = brok[1];
    }

    public Fone(String label, String number) {
        if (!validaNum(number)) {
            throw new IndexOutOfBoundsException("Erro, número não é valido");
        }
        this.label = label;
        this.number = number;
    }

    public String toString() {
        return label + " : " + number;
    }

}