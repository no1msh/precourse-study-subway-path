package racingcar.calculate

import racingcar.Car
import racingcar.RacingParameter
import camp.nextstep.edu.missionutils.Randoms
import racingcar.RacingMessage

object RacingCalculator {

    fun splitCarList(cars: String): List<String> = cars.split(",")
    fun makeInitProgressList(cars: List<String>): MutableList<Car> {
        val carProgress = mutableListOf<Car>()
        for (count: Int in RacingParameter.START_COUNT.number until cars.size)
            carProgress.add(Car(cars[count]))
        return carProgress
    }

    fun carMoving(): Boolean {
        val randomNumber = Randoms.pickUniqueNumbersInRange(
            RacingParameter.RANDOM_NUMBER_MINIMUM.number,
            RacingParameter.RANDOM_NUMBER_MAXIMUM.number,
            RacingParameter.HOW_MANY_GET_NUMBERS.number
        )
        return randomNumber[RacingParameter.START_COUNT.number] > RacingParameter.CAR_MOVING_MINIMUM_NUMBER.number
    }

    fun carProgress(position: Int): String {
        var progress = RacingMessage.RACING_PROGRESS_STANDARD.toString()
        for (count: Int in RacingParameter.START_COUNT.number until position) {
            progress += RacingMessage.RACING_PROGRESS
        }
        return progress
    }

    fun getWinner(cars: MutableList<Car>): MutableList<Car> {
        val winners = mutableListOf<Car>()
        winners.add(cars[RacingParameter.START_COUNT.number])
        for (count: Int in RacingParameter.GET_RACE_WINNER_START.number until cars.size) {
            if (winners[RacingParameter.START_COUNT.number].getProgress() < cars[count].getProgress()) {
                winners.clear()
                winners.add(cars[count])
            }
            if (winners[RacingParameter.START_COUNT.number].getProgress() == cars[count].getProgress())
                winners.add(cars[count])
        }
        return winners
    }

}