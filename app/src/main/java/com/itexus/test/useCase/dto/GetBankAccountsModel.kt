package com.itexus.test.useCase.dto

data class GetBankAccountsModel(
    val id: String = "",
    val name: String = "",
    val lastFourDigits: String = "",
    val status: BankAccountStatus
)