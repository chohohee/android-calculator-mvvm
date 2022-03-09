package edu.nextstep.camp.calculator.data.repository

import edu.nextstep.camp.calculator.data.CalculationMemory

interface CalculatorRepository {

    suspend fun getCalculationMemoryAll(): List<CalculationMemory>

    suspend fun insertCalculationMemory(calculationMemory: CalculationMemory)
}