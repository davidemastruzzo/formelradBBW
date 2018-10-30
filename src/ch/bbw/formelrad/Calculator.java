package ch.bbw.formelrad;

/**
 * Berechnet das Formelrad
 *
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
    private double leistung;
    private double spannung;
    private double strom;
    private double widerstand;

    public Calculator(double leistung, double spannung, double strom, double widerstand) {
        super();
        this.leistung = leistung;
        this.spannung = spannung;
        this.strom = strom;
        this.widerstand = widerstand;
    }

    public double getLeistung() {
        return leistung;
    }

    public double getSpannung() {
        return spannung;
    }

    public double getStrom() {
        return strom;
    }

    public double getWiderstand() {
        return widerstand;
    }

    @Override
    public String toString() {
        return "Calculator [leistung=" + leistung +
                ", spannung=" + spannung +
                ", strom=" + strom +
                ", widerstand=" + widerstand + "]";
    }

    /*
    Leistung = p
    WidersStand = R
    Stromstärke = I
    Spannung = U
     */

    public void calculate() {

        if (spannung != 0 && strom != 0) {
            leistung = pFromUAndI(spannung, strom);
        }

        if (spannung != 0 && widerstand != 0) {
            leistung = pFromUAndR(spannung, widerstand);
        }

        if (widerstand != 0 && strom != 0) {
            leistung = pFromRAndI(widerstand, strom);
            spannung = uFromRandI(widerstand, strom);
        }

    }

    public double pFromUAndI(double u, double i) {
        return u * i;
    }

    public double pFromUAndR(double u, double r) {
        return Math.pow(u, 2) / r;
    }

    public double pFromRAndI(double r, double i) {
        return r * Math.pow(i, 2);
    }

    public double uFromRandI(double r, double i) {
        return r * i;
    }

    public double uFromPandI(double p, double i) {
        return p / i;
    }

    public double uFromPandR(double p, double r) {
        return Math.sqrt(p * r);
    }
}
