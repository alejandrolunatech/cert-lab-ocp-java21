# 1Z0-830 exam blueprint

The topic list follows Oracle's published exam topics for Java SE 21 Developer Professional
(check the current page on education.oracle.com before booking). Tick a line when you get its
drills right on the first try and can explain why.

| Topic | Drills | Katas | Quiz domain |
|---|---|---|---|
| Handling date, time, text, numeric and boolean values | `01-values` (8) | K02 (BigDecimal), K06 (dates) | values |
| Controlling program flow | `02-flow` (7) | K01 (pattern switch) | flow |
| Using object-oriented concepts | `03-oop` (8) | K01, K02 | oop |
| Handling exceptions | `04-exceptions` (5) | K04 | exc |
| Working with arrays and collections | `05-collections` (7) | K05 | coll |
| Working with streams and lambda expressions | `06-streams` (7) | K03 | streams |
| Packaging and deploying Java code (modules) | `07-modules` (1) | – | modules |
| Managing concurrent code execution | `08-concurrency` (5) | K04 | conc |
| Using the Java I/O API | `09-io` (3) | K06 | io |
| Implementing localization | `10-localization` (3) | K06 | l10n |

## Checklist

- [ ] Primitives, wrappers, casting, overflow, Math rounding
- [ ] String, StringBuilder, text blocks, String methods (`strip`, `indent`, `repeat`, `formatted`)
- [ ] java.time: LocalDate/Time, ZonedDateTime and DST, Instant, Period vs Duration
- [ ] switch statements and expressions, `yield`, pattern matching, `when` guards, `case null`, record patterns
- [ ] Classes, records, enums, sealed hierarchies, nested and inner classes, initialization order
- [ ] Interfaces: default, static and private methods; resolving default conflicts
- [ ] Overloading and overriding rules; hiding fields and static methods
- [ ] Exceptions: checked vs unchecked, try-with-resources, suppressed exceptions, multi-catch
- [ ] Collections: List/Set/Map/Deque, immutability of `List.of`, sequenced collections, Comparator chains
- [ ] Streams: laziness, short-circuiting, collectors (groupingBy, partitioningBy, toMap, joining), Optional, primitive streams
- [ ] Functional interfaces and method references
- [ ] Modules: `module-info.java`, exports/opens/requires transitive, services, automatic and unnamed modules, `jdeps`, `jlink`
- [ ] Concurrency: platform and virtual threads, ExecutorService, Future, CompletableFuture, concurrent collections, locks, atomics
- [ ] I/O: Path, Files, streams that must be closed, serialization basics
- [ ] Localization: Locale, ResourceBundle lookup order, NumberFormat, DateTimeFormatter, MessageFormat
