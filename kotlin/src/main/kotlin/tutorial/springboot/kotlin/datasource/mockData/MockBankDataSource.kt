package tutorial.springboot.kotlin.datasource.mockData

import org.springframework.stereotype.Repository
import tutorial.springboot.kotlin.datasource.BankDataSource
import tutorial.springboot.kotlin.model.Bank

@Repository
class MockBankDataSource: BankDataSource {
    val banks = listOf(Bank("abc", 0.9,1 ), Bank("123", 0.6,2), Bank("sdfsd", 2.4,4))

    override fun retrieveBanks(): Collection<Bank>  = banks
}