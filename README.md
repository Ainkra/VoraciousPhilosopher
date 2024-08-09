# VoraciousPhilo

This project is an implementation of the classic "Dining Philosophers" problem in Java. The problem illustrates synchronization issues in concurrent programming, where multiple philosophers (threads or processes) are sitting around a table, eating, thinking, or sleeping. The project has two main parts:

1. **Part 1**: Philosophers as threads with forks protected by mutex locks.
2. **Part 2**: Philosophers as processes with forks managed by semaphores.

## Context
- Several philosophers are sitting around a circular table doing one of three things: eating, thinking, or sleeping.
- Philosophers need two forks to eat, and they cannot think or sleep while eating.
- After eating, they put down the forks and start sleeping. After sleeping, they start thinking.
- The simulation ends when a philosopher dies from not eating in time.
- The project simulates this problem with threads in Part 1 and processes with semaphores in Part 2.

## Subject
- Several philosophers are sitting at a round table doing one of three things: eating, thinking, or sleeping.
- While eating, they are not thinking or sleeping. While sleeping, they are not eating or thinking, and of course, while thinking, they are not eating or sleeping.
- The philosophers sit at a circular table with a large bowl of spaghetti in the center.
- There are some forks on the table.
- As spaghetti is difficult to serve and eat with a single fork, it is assumed that a philosopher must eat with two forks, one for each hand.
- The philosophers must never be starving.
- Every philosopher needs to eat.
- Philosophers don’t speak with each other.
- Philosophers don’t know when another philosopher is about to die.
- Each time a philosopher has finished eating, he will drop his forks and start sleeping.
- When a philosopher is done sleeping, he will start thinking.
- The simulation stops when a philosopher dies.
- Each program should have the same options: number_of_philosophers, time_to_die, time_to_eat, time_to_sleep, [number_of_times_each_philosopher_must_eat].

1. number_of_philosophers: is the number of philosophers and also the number of forks.
2. time_to_die: is in milliseconds. If a philosopher doesn’t start eating ‘time_to_die’ milliseconds after starting his last meal or the beginning of the simulation, it dies.
3. time_to_eat: is in milliseconds and is the time it takes for a philosopher to eat. During that time he will need to keep the two forks.
4. time_to_sleep: is in milliseconds and is the time the philosopher will spend sleeping.
5. number_of_times_each_philosopher_must_eat: argument is optional. If all philosophers eat at least ‘number_of_times_each_philosopher_must_eat’ times, the simulation will stop. If not specified, the simulation will stop only at the death of a philosopher.

- Each philosopher should be given a number from 1 to ‘number_of_philosophers’.
- Philosopher number 1 is next to philosopher number ‘number_of_philosophers’. Any other philosopher with the number N is seated between philosopher N-1 and philosopher N+1.
- Any change of status of a philosopher must be written as follows (with X replaced with the philosopher number and timestamp_in_ms the current timestamp in milliseconds):
    - timestamp_in_ms X has taken a fork
    - timestamp_in_ms X is eating
    - timestamp_in_ms X is sleeping
    - timestamp_in_ms X is thinking
    - timestamp_in_ms X died

- The status printed should not be scrambled or intertwined with another philosopher’s status.
- You can’t have more than 10 ms between the death of a philosopher and when it will print its death.
- Again, philosophers should avoid dying!

### Part 1:
- One fork between each philosopher. Therefore, if there are multiple philosophers, there will be a fork at the right and the left of each philosopher.
- To avoid philosophers duplicating forks, you should protect the fork’s state with a mutex for each of them.
- Each philosopher should be a thread.

### Part 2:
- All the forks are in the middle of the table.
- They have no states in memory, but the number of available forks is represented by a semaphore.
- Each philosopher should be a process, and the main process should not be a philosopher.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Ensure that Java 17 or later is installed on your system.

### Clone the Repository

```bash
git clone https://github.com/Ainkra/VoraciousPhilosopher.git
cd VoraciousPhilosopher
```
### How to run the project?
Simply use IntelliJ Community IDEA commandlines.

You can modify this part as you want:
```java
int numberOfPhilosophers = 6;
long timeToDie = 1000;
long timeToEat = 200;
long timeToSleep = 100;
int numberOfMeals = 12;
```
