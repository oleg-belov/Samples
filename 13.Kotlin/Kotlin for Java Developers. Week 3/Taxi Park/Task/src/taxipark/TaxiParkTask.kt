package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
//        First solution
//        allDrivers.filter{ driver -> trips.none {trip -> trip.driver == driver } }.toSet()
        allDrivers - trips.map { it.driver }
/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
//        First solution
    if (minTrips == 0) allPassengers
    else trips
        .flatMap (Trip::passengers)
        .groupBy { passenger -> passenger }
        .filterValues { passengers -> passengers.size >= minTrips }
        .keys
//    Second solution
//    allPassengers
//        .filter { p ->
//            trips.count { t -> p in t.passengers } >= minTrips
//        }
//        .toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
//        First solution
    trips.filter { trip -> trip.driver == driver }
        .flatMap (Trip::passengers)
        .groupBy { passenger -> passenger  }
        .filterValues { passengers -> passengers.size > 1 }
        .keys
//    Second solution
//    allPassengers.filter { p ->
//        trips.any { trip -> trip.driver == driver && p in trip.passengers }
//    }
//    .toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger>  =
//        First solution
//    trips.flatMap { trip -> trip.passengers.map { passenger -> passenger to trip } }
//        .groupBy { (passenger, trip) -> passenger }
//        .mapValues { (_, list) -> list.map { it.second } }
//        .mapValues { (_, trips) -> trips.partition { trip -> trip.discount != null } }
//        .filter { (_, pair) -> pair.first.size > pair.second.size }
//        .keys
//    Second solution
//{
//    val (tripsWithDiscount, tripsWithoutDiscount) = trips.partition { trip -> trip.discount != null }
//
//    return allPassengers.filter { passenger ->
//        tripsWithDiscount.count { trip -> passenger in trip.passengers } >
//                tripsWithoutDiscount.count { trip -> passenger in trip.passengers }
//    }
//        .toSet()
//}
//    Third solution
    allPassengers.associateWith { p ->
        trips.filter { t -> p in t.passengers }
    }
        .filterValues { trips ->
            val (withDiscount, withoutDiscount) = trips
                .partition { trip ->  trip.discount != null }
            withDiscount.size > withoutDiscount.size
        }
        .keys


/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
//        First solution
//    val bucket = trips.map { it.duration }
//        .groupBy { it / 10 }
//        .maxByOrNull { (_, durations) -> durations.size }
//        ?.key
//
//    return bucket?.let {
//        val start = it * 10
//        val end = start + 9
//        IntRange(start, end)
//    }
//    Second solution
    return trips.groupBy { trip ->
        // (5 / 10) -> 0 , (0 * 10) -> 0 => 0..9;
        // (11 / 10) -> 1 , (1 * 10) -> 10 => 10..19;
        // (21 / 10) -> 2 , (2 * 10) -> 20 => 20..29;
        val start = trip.duration / 10 * 10
        val end = start + 9
        start..end
    }
        .maxByOrNull { (_, group) -> group.size }
        ?.key
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean =
    if (trips.isEmpty()) false
    else {
        val totalIncome = trips.sumByDouble (Trip::cost)
        val sortedDriversIncome: List<Double> = trips
            .groupBy(Trip::driver)
            .map { (_, trips) -> trips.sumByDouble (Trip::cost) }
            .sortedDescending()

        val numberOfTopDrivers = (0.2 * allDrivers.size).toInt()
        val incomeByTopDrivers = sortedDriversIncome
            .take(numberOfTopDrivers)
            .sum()

        incomeByTopDrivers >= 0.8 * totalIncome
    }
