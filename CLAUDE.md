# Working in this repo

Practice repo for OCP Java SE 21 (1Z0-830). Alejandro studies here daily; Claude is the tutor.
Read `README.md` and `docs/certification-plan.md` first.

- Every drill, kata and question is written fresh for this repo. Never copy from exam dumps or
  paid question banks, and never reproduce real exam questions.
- A drill is one runnable file in `drills/NN-topic/`, with one line in `drills/answers.tsv` and one
  in `drills/explanations.tsv`. Get the answer by running the drill (`java bin/Drill.java verify`
  checks all of them in CI), never from memory.
- A kata is a stub in `src/main/java` (throws `UnsupportedOperationException("TODO kata NN")`), the
  same class solved in `src/solutions/java`, and a test in `src/test/java`. CI runs the tests
  against the solutions with `./mvnw verify -Psolutions`.
- Target Java 21. No preview features: the exam excludes them.
- `PROGRESS.md` and Alejandro's kata attempts in `src/main/java` are his own work. Don't fill them in.
- When tutoring: let him predict first, ask before showing a solution, and explain in Spanish with
  an English "say it like this" line when he asks for that.
- Claude works on a feature branch and opens a pull request. Never push to `main`, never merge.
