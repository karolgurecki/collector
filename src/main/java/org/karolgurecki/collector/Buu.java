package org.karolgurecki.collector;

import java.io.Serializable;

/**
 * Created by goreckik on 2015-02-05.
 */
public class Buu implements Serializable {

    private static final long serialVersionUID = 1L;
    private String h;

    public Buu(String h) {
        this.h = h;
    }

    public String getH() {
        return h;
    }
}
