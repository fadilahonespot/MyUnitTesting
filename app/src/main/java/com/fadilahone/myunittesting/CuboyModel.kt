package com.fadilahone.myunittesting

class CuboyModel {
    private var width :Double = 0.0
    private var length :Double = 0.0
    private var heigth :Double = 0.0

    fun getVolume() :Double {
        return width *length*heigth
    }

    fun getSurfaceArea() :Double {
        var r1 = width * length
        var r2 = width * heigth
        var r3 = length * heigth

        return 2 * (r1 + r2 + r3)
    }

    fun getCircumFerence() :Double {
        return 4 * (width + length + heigth)
    }

    fun save (length :Double, width :Double, heigth :Double) {
        this.width = width
        this.length = length
        this.heigth = heigth
    }
}