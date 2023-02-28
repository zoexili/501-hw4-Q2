package com.bignerdranch.android.criminalintent

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class CrimeListViewModelTest {
    private lateinit var viewModel: CrimeListViewModel

    @Before
    fun setUp() {
        viewModel = CrimeListViewModel()
    }

    @Test
    fun testCrimesListSize() {
        val expectedSize = 100
        val actualSize = viewModel.crimes.size
        Assert.assertEquals(expectedSize, actualSize)
    }

    @Test
    fun testCrimeListContent() {
        val expectedTitle = "Crime #3"
        val expectedIsSolved = false
        val expectedRequiresPolice = false

        val crime = viewModel.crimes[3]

        Assert.assertEquals(expectedTitle, crime.title)
        Assert.assertEquals(expectedIsSolved, crime.isSolved)
        Assert.assertEquals(expectedRequiresPolice, crime.requiresPolice)
    }
}