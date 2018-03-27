package com.practicals.chris.guessinggame;

import java.io.Serializable;

/**
 * Created by Chris on 26/02/2018.
 */

class minMax implements Serializable {
    Integer _min;
    Integer _max;

    minMax(int min, int max) {
        _min = min;
        _max = max;
    }

    boolean isEmpty() {
        return _min == null && _max == null;
    }
}
