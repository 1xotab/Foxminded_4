package com.Foxminded.Devision;

public class Step {

    int elementaryDevident;
    int subtrahend;
    int remainder;

    public Step(int elementaryDevident,int subtrahend,int remainder) {

        this.elementaryDevident = elementaryDevident;
        this.remainder = remainder;
        this.subtrahend = subtrahend;

    }

    @Override
    public String toString() {
        return "Step{" +
                "elementaryDevident=" + elementaryDevident +
                ", subtrahend=" + subtrahend +
                ", remainder=" + remainder +
                '}';
    }
}
