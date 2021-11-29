package tutorial.springboot.kotlin.datasource.mockData

import org.springframework.stereotype.Repository
import tutorial.springboot.kotlin.datasource.BankDataSource
import tutorial.springboot.kotlin.model.Bank

@Repository
class MockBankDataSource: BankDataSource {
    val banks = mutableListOf(Bank("abc", 0.9,1 ), Bank("123", 0.6,2), Bank("sdfsd", 2.4,4))

    override fun retrieveBanks(): Collection<Bank>  = banks

    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number ${accountNumber}")

    override fun createBank(bank: Bank): Bank {
        if(banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank already exists")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
       val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
           ?: throw NoSuchElementException("Could not find a bank with account number ${bank.accountNumber}")

        banks.remove(currentBank)
        banks.add(bank)
        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number ${accountNumber}")

        banks.remove(currentBank)
    }


}