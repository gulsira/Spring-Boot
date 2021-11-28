package tutorial.springboot.kotlin.datasource

import tutorial.springboot.kotlin.model.Bank

interface BankDataSource {
    fun retrieveBanks(): Collection<Bank>
    fun retrieveBank(accountNumber: String): Bank
}