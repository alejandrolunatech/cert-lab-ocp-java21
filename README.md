# cert-lab-ocp-java21

Practice repo for **Oracle Certified Professional: Java SE 21 Developer (exam 1Z0-830)**.
The exam is 50 questions in 120 minutes, pass mark 68%, and most questions are
"what does this code print, or does it compile at all?". So the core of this repo is code you
predict and then run, plus katas that make you write modern Java by hand.

Target: exam on **Fri 26 Feb 2027** (study block 4 Jan – 26 Feb).
The whole three-exam plan is in [`docs/certification-plan.md`](docs/certification-plan.md).

## What's inside

| Path | What it is |
|---|---|
| `drills/NN-topic/*.java` | 54 small programs across the 10 exam topics. Predict the output, `DOES NOT COMPILE`, or `EXCEPTION Name`, then run it |
| `bin/Drill.java` | The trainer: shows a drill, takes your prediction, runs it, tells you why. Needs only a JDK |
| `src/main/java/lab/katas/` | 6 katas with failing tests: sealed types and pattern switch, a validating record, collectors, virtual threads, sequenced collections, resource bundles and NIO.2 |
| `src/solutions/java/` | Reference solutions for the katas (spoilers) |
| `quiz/index.html` | 56 questions on rules and APIs (modules, jlink, concurrency, localization...), practice mode and timed mock. Opens offline |
| `animations/virtual-threads.html` | Watch platform threads, virtual threads and pinning handle the same blocking workload |
| `docs/study-plan.md` | Eight weeks, day by day |
| `docs/exam-blueprint.md` | The exam topics, mapped to drills, katas and quiz domains |
| `PROGRESS.md` | Your log |

CI runs every drill and checks it against `drills/answers.tsv`, so each answer is what Java 21
really does, not what someone remembered.

## Setup on your Mac (once)

Runs in Terminal, from any folder:

```
brew install --cask temurin@21
```

Check it, from any folder:

```
java -version
```

It should say 21. Maven comes with the repo (`./mvnw`).

## Daily use

All commands run inside the repo folder.

Drills, one topic at a time:

```
java bin/Drill.java 03-oop
```

Ten random drills from everything:

```
java bin/Drill.java random 10
```

Your score per topic:

```
java bin/Drill.java
```

A kata: open `src/main/java/lab/katas/K01Shapes.java`, read the instructions at the top, write
the code, then run its tests:

```
./mvnw -q test -Dtest=K01ShapesTest
```

## How to answer a drill

- Output lines are joined with a single space.
- `DOES NOT COMPILE` when the compiler rejects it.
- `EXCEPTION ClassCastException` (simple name) when it throws. If it printed something first,
  write that, then the exception: `start EXCEPTION IllegalStateException`.

Spacing and capital letters are ignored when your answer is compared.

## Exam habits these drills train

- Read the last line first: is the question about output, compilation or an exception?
- Check compilation before you trace: missing `yield`, dominated `case` labels, a checked
  exception that can't be thrown, an unassigned `var`, a lambda changing a local.
- Watch immutable types: String, LocalDate and BigDecimal methods return new objects.
- Count carefully on `substring`, `range` versus `rangeClosed`, and `%` with negatives.
