package tutorial.springboot.kotlin.service

import org.springframework.stereotype.Service
import tutorial.springboot.kotlin.datasource.BankDataSource
import tutorial.springboot.kotlin.model.Bank

@Service
class BankService(private val dataSource: BankDataSource) {

    fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)

}