package com.fadilahone.myunittesting

import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.Before
import org.mockito.Mockito.*

class MainViewModelTest {

    private lateinit var mainViewModel :MainViewModel
    private lateinit var cuboyModel :CuboyModel
    private val dummyLength = 5.0
    private val dummyHeigth = 10.0
    private val dummyWidth = 6.0

    private val dummyVolume = 300.0
    private val dummySurfaceArea = 280.0
    private val dummyCircumPerence = 84.0

    @Before
    fun before() {
        cuboyModel = mock(CuboyModel::class.java)
        mainViewModel = MainViewModel(cuboyModel)
    }

    @Test
    fun testVolume() {
        cuboyModel = CuboyModel()
        mainViewModel = MainViewModel(cuboyModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeigth)
        val volume = mainViewModel.getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testSurfaceArea() {
        cuboyModel = CuboyModel()
        mainViewModel = MainViewModel(cuboyModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeigth)
        val surfaceArea = mainViewModel.getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun getCircumPreferen() {
        cuboyModel = CuboyModel()
        mainViewModel = MainViewModel(cuboyModel)
        mainViewModel.save(dummyLength, dummyWidth, dummyHeigth)
        val circumFerence = mainViewModel.getCircumPreferen()
        assertEquals(dummyCircumPerence, circumFerence, 0.0001)
    }

    @Test
    fun testMockVolume() {
        `when` (mainViewModel.getVolume()).thenReturn(dummyVolume)
        val volume = mainViewModel.getVolume()
        verify(cuboyModel).getVolume()
        assertEquals(dummyVolume, volume, 0.0001)
    }

    @Test
    fun testMockSurfaceArea() {
        `when` (mainViewModel.getSurfaceArea()).thenReturn(dummySurfaceArea)
        val surfaceArea = mainViewModel.getSurfaceArea()
        verify(cuboyModel).getSurfaceArea()
        assertEquals(dummySurfaceArea, surfaceArea, 0.0001)
    }

    @Test
    fun testMockCircumPreferen() {
        `when` (mainViewModel.getCircumPreferen()).thenReturn(dummyCircumPerence)
        val circumPreferen = mainViewModel.getCircumPreferen()
        verify(cuboyModel).getCircumFerence()
        assertEquals(dummyCircumPerence, circumPreferen, 0.0001)
    }

    @Test
    fun save() {
    }
}