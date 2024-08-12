package com.itexus.test.useCase

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result

class UnlinkBankAccountUseCase {

    suspend operator fun invoke(id: String): Result<Unit, RuntimeException> {
        return Ok(Unit)
    }

}