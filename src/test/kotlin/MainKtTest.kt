import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    class MainKtTest {

        @Test
        fun count_of_commission_right() {
            val type_of_cards = VISA
            val monthAmount: Long = 1000
            val sumOfTransaction: Long = 100

            val result = commissionCount(
                card_type = type_of_cards,
                previousAmountMonthly = monthAmount,
                transactionAmount = sumOfTransaction
            )

            assertEquals("Комиссия составялет 35 руб.", result)
        }

        @Test
        fun count_of_commission_right_VK_PAY() {
            val type_of_cards = VK_PAY
            val monthAmount: Long = 80000
            val sumOfTransaction: Long = 800

            val result = commissionCount(
                card_type = type_of_cards,
                previousAmountMonthly = monthAmount,
                transactionAmount = sumOfTransaction
            )

            assertEquals("Комиссия составляет 0 коп.", result)
        }

        @Test
        fun count_of_commission_right_MAESTRO() {
            val type_of_cards = MAESTRO
            val monthAmount: Long = 50000
            val sumOfTransaction: Long = 8000000

            val result = commissionCount(
                card_type = type_of_cards,
                previousAmountMonthly = monthAmount,
                transactionAmount = sumOfTransaction
            )

            assertEquals("Комиссия составляет 50000 коп.", result)
        }

        @Test
        fun count_of_commission_right_MASTERCARD() {
            val type_of_cards = MASTERCARD
            val monthAmount: Long = 50000
            val sumOfTransaction: Long = 8000000

            val result = commissionCount(
                card_type = type_of_cards,
                previousAmountMonthly = monthAmount,
                transactionAmount = sumOfTransaction
            )

            assertEquals("Комиссия составляет 50000 коп.", result)
        }

        @Test
        fun count_of_commission_right_MIR() {
            val type_of_cards = MIR
            val monthAmount: Long = 1000
            val sumOfTransaction: Long = 100

            val result = commissionCount(
                card_type = type_of_cards,
                previousAmountMonthly = monthAmount,
                transactionAmount = sumOfTransaction
            )

            assertEquals("Комиссия составялет 35 руб.", result)
        }

    @Test
    fun count_of_commission_wrong() {
        val type_of_cards = VISA
        val monthAmount: Long = 1000
        val sumOfTransaction: Long = 100

        val result = commissionCount(
            card_type = type_of_cards,
            previousAmountMonthly = monthAmount,
            transactionAmount = sumOfTransaction
        )
        assertEquals("Комиссия составялет 66 руб.", result)
    }

        @Test
        fun VK_PAY_Commission() {
            val monthAmount: Long = 1000
            val sumOfTransaction: Long = 100

            val result = commissionVkPay(
                transactionAmount = sumOfTransaction,
                previousAmountMonthly = monthAmount
            )
            assertEquals("Комиссия составляет 0 коп.", result)
        }

        @Test
        fun VK_PAY_Commission_0() {
            val sumOfTransaction: Long = 2000666

            val result = commissionCount(
                transactionAmount = sumOfTransaction
            )
            assertEquals("Слишком большая сумма!", result)
        }

        @Test
        fun VK_PAY_Commission_Too_Much() {
            val type_of_card = VK_PAY
            val monthAmount: Long = 4_000_000
            val sumOfTransaction: Long = 500

            val result = commissionCount(
                card_type = type_of_card,
                monthAmount,
                transactionAmount = sumOfTransaction
            )
            assertEquals("Слишком много переводов!", result)
        }

        @Test
        fun MaestroMasterCard_Commission() {
            val monthAmount: Long = 200
            val sumOfTransaction: Long = 20000

            val result = commissionCountMaestroMastercard(
                transactionAmount = sumOfTransaction,
                previousAmountMonthly = monthAmount
            )
            assertEquals("Комиссия составляет 2120 коп.", result)
        }

        @Test
        fun MaestroMasterCard_Commission_0() {
            val monthAmount: Long = 200
            val sumOfTransaction: Long = 35000

            val result = commissionCountMaestroMastercard(
                transactionAmount = sumOfTransaction,
                previousAmountMonthly = monthAmount
            )
            assertEquals("Комиссия составляет 0 коп.", result)
        }

        @Test
        fun MaestroMasterCard_Commission_Too_Much_For_Month() {
            val monthAmount: Long = 70_000_000
            val sumOfTransaction: Long = 3000

            val result = commissionCountMaestroMastercard(
                transactionAmount = sumOfTransaction,
                previousAmountMonthly = monthAmount
            )
            assertEquals("Слишком много переводов!", result)
        }

        @Test
        fun MaestroMasterCard_Commission_Too_Much_For_Day() {
            val monthAmount: Long = 500
            val sumOfTransaction: Long = 25_000_000

            val result = commissionCountMaestroMastercard(
                transactionAmount = sumOfTransaction,
                previousAmountMonthly = monthAmount
            )
            assertEquals("Слишком большая сумма!", result)
        }

        @Test
        fun Visa_Mir_commissionCount_Too_Much_Month() {
            val monthAmount: Long = 88000000
            val sumOfTransaction: Long = 2000

            val result = commissionVisaMir(
                transactionAmount = sumOfTransaction,
                previousAmountMonthly = monthAmount
            )
            assertEquals("Слишком много переводов!", result)
        }

        @Test
        fun Visa_Mir_commissionCount_Too_Much_Day() {
            val monthAmount: Long = 500
            val sumOfTransaction: Long = 25_000_000

            val result = commissionVisaMir(
                transactionAmount = sumOfTransaction,
                previousAmountMonthly = monthAmount
            )
            assertEquals("Слишком большая сумма!", result)
        }

        @Test
        fun Visa_Mir_commissionCount_Count() {
            val monthAmount: Long = 5000
            val sumOfTransaction: Long = 3333333

            val result = commissionVisaMir(
                transactionAmount = sumOfTransaction,
                previousAmountMonthly = monthAmount
            )
            assertEquals("Комиссия составляет 24999 коп.", result)
        }

    }


}