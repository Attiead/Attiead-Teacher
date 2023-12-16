package com.attiead.teacher.common.transaction

import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class Tx(
    transactionAdvice: TxAdvice,
) {

    init {
        txAdvice = transactionAdvice
    }

    companion object {
        private lateinit var txAdvice: TxAdvice

        fun <T> readable(function: () -> T): T {
            return txAdvice.read(function)
        }

        fun <T> writeable(function: () -> T): T {
            return txAdvice.write(function)
        }
    }

    @Component
    class TxAdvice {

        @Transactional(readOnly = true)
        fun <T> read(function: () -> T): T {
            return function.invoke()
        }

        @Transactional
        fun <T> write(function: () -> T): T {
            return function.invoke()
        }
    }
}
