package com.example;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.binary.Base64;

class RettangoloBase {
    double base;
    double altezza;

    public RettangoloBase(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }
    public double getAltezza() {
        return altezza;
    }
    public void setBase(double base) {
        this.base = base;
    }
    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double calcolaArea() {
        return base * altezza;
    }

    public double calcolaPerimetro() {
        return base * 2 + altezza * 2;
    }

    @Override
    public boolean equals(Object obj) {
        // Se this e obj sono lo stesso oggetto in memoria
        if (this == obj) {
            return true;
        }
        if (obj instanceof RettangoloBase) {
            RettangoloBase toCompare = (RettangoloBase) obj;
            return this.calcolaArea() == toCompare.calcolaArea();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Sono un rettangolo che copre un'area di " + this.calcolaArea() + "mq";
    }

    public String hashClass() {
        return DigestUtils.sha3_512Hex(toString());
    }

    public String serializza() {
        return Base64.encodeBase64String(toString().getBytes());
    }
}