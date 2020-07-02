package com.fadilahone.myunittesting

class MainViewModel(private val cubouy :CuboyModel) {
    fun getVolume() :Double {
        return cubouy.getVolume()
    }

    fun getSurfaceArea() :Double {
        return cubouy.getSurfaceArea()
    }

    fun getCircumPreferen() :Double {
        return cubouy.getCircumFerence()
    }

    fun save(l :Double, w :Double, h :Double) {
        cubouy.save(l, w, h)
    }
}