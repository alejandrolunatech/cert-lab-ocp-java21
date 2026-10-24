# Hands-on certification plan

Written 24 Oct 2026. The same plan sits in all three `cert-lab-*` repos. Open
[`certification-plan.html`](certification-plan.html) in a browser for the version with charts.

Scope: freelance AI Engineer and Senior Software Engineer (Java/Spring, TypeScript/Node) roles
on the NL/EU contract market at 100+ EUR/h. No management or coaching certifications.

## The three exams, in order

| # | Certification | Repo | Price | Exam target | Why |
|---|---|---|---|---|---|
| 1 | AWS Certified Generative AI Developer – Professional (AIP-C01) | `cert-lab-aws-genai-pro` | USD 300 | Fri 20 Nov 2026 | New and rare. It tests the AI Engineer job: Bedrock, RAG, agents, guardrails, evals, cost. |
| 2 | Certified Kubernetes Application Developer (CKAD), renewal | `cert-lab-ckad` | USD 445, 1 free retake | Fri 11 Dec 2026 | Hands-on in a live cluster, wanted on both tracks, and it replaces the expired 2020 cert. Buy in the Linux Foundation Black Friday sale. |
| 3 | Oracle Certified Professional: Java SE 21 Developer (1Z0-830) | `cert-lab-ocp-java21` | ~USD 245 (VALIDATE) | Fri 26 Feb 2027 | Moves your public Java from 8/11 to 21 and drills the modern-Java questions senior interviews ask. |

Later, only if the market asks: Azure AI-103 (App and Agent Developer, if Azure shows up in real
leads), CKS in 2027, Claude Certified Architect (partner-only in Oct 2026).

Skipped: Spring Professional (its exam still covers Spring Boot 2.5), Databricks GenAI unless a
data role appears, fundamentals exams, every Scrum/SAFe/PMP-style credential.

## Calendar

| Weeks | Focus | Ends with |
|---|---|---|
| 26 Oct – 20 Nov | AIP-C01 | Exam Fri 20 Nov |
| 23 Nov – 11 Dec | CKAD | Buy voucher Black Friday 27 Nov, exam Fri 11 Dec |
| 19 Dec – 3 Jan | Kerstvakantie | Nothing |
| 4 Jan – 26 Feb | OCP Java 21 | Exam Fri 26 Feb |

About 2 hours a day, Monday to Friday, never Saturdays. The job search stays first.

## The daily loop (same in every repo)

1. **Warm-up, 15 min:** 10 questions in `quiz/index.html` (practice mode, weakest domain first).
2. **Hands-on, 75 min:** the next lab or task in the repo. Try it alone first, then check, then compare with the solution.
3. **Explain it back, 15 min:** tell Claude in English what you did and why, as if in an interview.
4. **Log, 5 min:** one line in `PROGRESS.md`: date, what you did, score.

Every Friday: one timed mock (quiz mock mode, plus `bin/mock` in the CKAD repo) and a 20-minute
mock interview on the week's topics. Book the real exam after two mocks at 80% or more.

## Rules for the material

- Every question and lab is written fresh for these repos. Never use exam dumps: they break the
  candidate agreements of AWS, the Linux Foundation and Oracle, and can cost the certificate.
- Nothing here spends money by itself. Labs that touch a real AWS account are marked with their cost
  and run only when you choose to.
