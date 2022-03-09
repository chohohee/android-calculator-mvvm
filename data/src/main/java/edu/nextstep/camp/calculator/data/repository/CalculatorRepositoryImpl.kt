package edu.nextstep.camp.calculator.data.repository

import android.content.Context
import edu.nextstep.camp.calculator.data.CalculationMemory
import edu.nextstep.camp.calculator.data.CalculatorDao
import edu.nextstep.camp.calculator.data.CalculatorDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class CalculatorRepositoryImpl(
    private val calculatorDao: CalculatorDao
) : CalculatorRepository {
    override suspend fun getCalculationMemoryAll(): List<CalculationMemory> {
        return withContext(Dispatchers.IO) {
            calculatorDao.getCalculationMemoryAll()
        }
    }

    override suspend fun insertCalculationMemory(calculationMemory: CalculationMemory) {
        withContext(Dispatchers.IO) {
            calculatorDao.insertCalculationMemory(calculationMemory)
        }
    }
}

object Injector {
    fun provideSampleRepository(context: Context): CalculatorRepository {
        return CalculatorRepositoryImpl(CalculatorDatabase.getInstance(context).calculatorDao())
    }
}
