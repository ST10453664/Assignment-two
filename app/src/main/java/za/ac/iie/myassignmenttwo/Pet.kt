package za.ac.iie.myassignmenttwo

class Pet {
    var health: Int = 100
    var hunger: Int = 0
    var cleanliness: Int = 0

    fun feed() {
        hunger -= 10
        if (hunger < 0) hunger = 0
    }

    fun clean() {
        cleanliness -= 10
        if (cleanliness < 0) cleanliness = 0
    }

    fun decreaseHealth() {
        health -= 10
        if (health < 0) health = 0
    }

    fun increaseHunger() {
        hunger += 10
        if (hunger > 100) hunger = 100
    }

    fun increaseCleanliness() {
        cleanliness += 10
        if (cleanliness > 100) cleanliness = 100
    }
}