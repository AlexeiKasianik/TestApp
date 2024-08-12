package com.itexus.test.useCase

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result

class CreateBankAccountUseCase {

    suspend operator fun invoke(
        publicToken: String,
        id: String,
        name: String
    ): Result<Unit, RuntimeException> {
        return Ok(Unit)
    }
}